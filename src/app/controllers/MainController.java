package app.controllers;

import app.solvers.DFSolver;
import app.solvers.Graph;
import app.solvers.VFSolver;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.med.mdvfd2.ASolver;
import com.med.mdvfd2.Pair;
import com.med.mdvfd2.Vector;
import com.med.mdvfd2.Vectorizable;
import eu.hansolo.tilesfx.chart.PixelMatrix;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.concurrent.Worker.State.*;

public class MainController implements Initializable {
    @FXML
    private AnchorPane chartContainer;
    @FXML
    private JFXTextField fExpression;
    @FXML
    private JFXTextField gExpression;
    @FXML
    private JFXTextField nValue;
    @FXML
    private JFXButton visualiser; // le bouton visualiser
    @FXML
    private JFXButton dif; // le bouton Différences finies
    @FXML
    private JFXButton vof; // le bouton Volumes finis

    @FXML
    private HBox hb = new HBox();
    @FXML
    private Label labe = new Label();

    private VBox vb =new VBox();

    private PixelMatrix M = new PixelMatrix();

    private String fString = "";
    private String gString = "";
    private int n = 0;

    private DFSolver dfSolver = new DFSolver(); // Solveur des differences finies
    private VFSolver vfSolver = new VFSolver(); // Solveur des volumes finis

    private Vectorizable vector1 = null; // Vecteur des differences finies
    private Vectorizable vector2 = null; // Vecteur des volumes finis


    private boolean multithreading = true; // Indicateur du multithread
    private byte methodType = 1; // Indicateur de la methode (differences finies ou volume finis)

    private NumberAxis xAxis = new NumberAxis(0, 1, 0.1); // Axe des absisses
    private NumberAxis yAxis = new NumberAxis(0, 1, 0.1); // Axe des ordonnées

    private double[][] U;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.xAxis.setLabel("x");
        this.yAxis.setLabel("y");
        hb.getChildren().add(vb);

        setFiniteDifference(null);

    }


    @FXML
    private void setFiniteDifference(ActionEvent event) {
        this.labe.setText("Différences finies");
        this.methodType = 1;

        this.fExpression.setText("");
        this.gExpression.setText("");
        this.nValue.setText("");

        this.vb.getChildren().clear();

    }

    @FXML
    private void setFiniteVolume(ActionEvent event) {
        this.labe.setText("Volumes finis");
        this.methodType = 2;
        this.fExpression.setText("");
        this.gExpression.setText("");
        this.nValue.setText("");
        this.vb.getChildren().clear();
    }


    @FXML
    private void toggleMultiThreading(ActionEvent event) {
        this.multithreading =  !this.multithreading;
    }

    @FXML
    private void apply(ActionEvent event) {

        try {
            this.fString = this.fExpression.getText();
            this.gString = this.gExpression.getText();
            this.n = Integer.parseInt(this.nValue.getText());

            if (fString.isEmpty() || this.gString.isEmpty() || n<=0 || this.nValue.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisi");
                alert.setHeaderText(null);
                alert.setContentText("Les valeurs entrées sont incorrects");
                alert.showAndWait();

            }
            else {
                this.xAxis.setTickUnit(1./(n+1));
                this.yAxis.setTickUnit(1./(n+1));

                this.visualiser.setDisable(true);


                if (this.methodType == 1) {

                    this.dfSolver.setF(fString);
                    this.dfSolver.setG(gString);
                    this.dfSolver.setN(n);

                    final Service<Void> calculateService = new Service<Void>() {

                        @Override

                        protected Task<Void> createTask() {
                            return new Task<Void>() {

                                @Override
                                protected Void call() throws Exception {
                                    U = dfSolver.solve(multithreading);

                                    return null;
                                }
                            };
                        }


                    };

                    calculateService.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
                        switch (newValue) {
                            case FAILED:
                            case CANCELLED:
                            case SUCCEEDED:

                                this.visualiser.setDisable(false);
                                try {
                                    this.M = drawSolution(U);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                vb.getChildren().clear();
                                vb.getChildren().add(M);


                                break;
                        }
                    });
                    calculateService.start();




                }
                else if(this.methodType == 2){
                    this.vfSolver.setF(fString);
                    this.vfSolver.setG(gString);
                    this.vfSolver.setN(n);


                    final Service<Void> calculateService = new Service<Void>() {

                        @Override

                        protected Task<Void> createTask() {
                            return new Task<Void>() {

                                @Override
                                protected Void call() throws Exception {
                                    U = vfSolver.solve(multithreading);

                                    return null;
                                }
                            };
                        }


                    };

                    calculateService.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
                        switch (newValue) {
                            case FAILED:
                            case CANCELLED:
                            case SUCCEEDED:

                                this.visualiser.setDisable(false);
                                try {
                                    this.M = drawSolution(U);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                vb.getChildren().clear();
                                vb.getChildren().add(M);


                                break;
                        }
                    });
                    calculateService.start();
                }

            }

        }catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public PixelMatrix drawSolution(double[][] solution) throws Exception{
        Graph G = new Graph();
        G.U = solution.clone();
        return G.go();
    }


}
