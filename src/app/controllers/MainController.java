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
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

    private VBox vb =new VBox();
    private HBox hb =new HBox();

    private String fString = "";
    private String gString = "";
    private int n = 0;

    private DFSolver dfSolver = new DFSolver(); // Solveur des differences finies
    private VFSolver vfSolver = new VFSolver(); // Solveur des volumes finis

    private Vectorizable vector1 = null; // Vecteur des differences finies
    private Vectorizable vector2 = null; // Vecteur des volumes finis


    private boolean multithreading = false; // Indicateur du multithread
    private byte methodType = 1; // Indicateur de la methode (differences finies ou volume finis)

    private NumberAxis xAxis = new NumberAxis(0, 1, 0.1); // Axe des absisses
    private NumberAxis yAxis = new NumberAxis(0, 1, 0.1); // Axe des ordonnées

    private PixelMatrix M;

    private double U[][] = new double[4][4];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.xAxis.setLabel("x");
        this.yAxis.setLabel("y");
    }


    @FXML
    private void setFiniteDifference(ActionEvent event) {
        this.methodType = 1;

    }

    @FXML
    private void setFiniteVolume(ActionEvent event) {
        this.methodType = 2;
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
                return;
            }
            else {
                this.xAxis.setTickUnit(1./(n+1));
                this.yAxis.setTickUnit(1./(n+1));

                this.visualiser.setDisable(true);

                if (this.methodType == 1) {

                    this.dfSolver.setF(fString);
                    this.dfSolver.setG(gString);
                    this.dfSolver.setN(n);

                    this.vector1 = new Vector(n*n);



                    final Service<Void> calculateService = new Service<Void>() {

                        @Override

                        protected Task<Void> createTask() {
                            return new Task<Void>() {

                                @Override
                                protected Void call() throws Exception {
                                    double[][] v = dfSolver.solve(multithreading);

                                    /*for (int i = 0; i<(n*n); i++ ) {
                                        vector1.set(i, v.get(i));

                                    }*/

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

                                U[0][0] =2.2 ;U[0][1] = 3;U[0][2] =2.5 ;U[0][3] =1.5 ;
                                U[1][0] =1 ;U[1][1] = 4;U[1][2] =1.5 ;U[1][3] =3 ;
                                U[2][0] =2 ;U[2][1] = 3;U[2][2] =3.2;U[2][3] =1.5 ;
                                U[3][0] =2.2 ;U[3][1] = 3;U[3][2] =2.5 ;U[3][3] =2.2 ;



                                this.visualiser.setDisable(false);
                                try {
                                    this.M = drawSolution(U);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                vb.getChildren().add(M);
                                hb.getChildren().add(vb);
                                this.chartContainer.getChildren().add(hb);

                                break;
                        }
                    });
                    calculateService.start();
                }
                else {

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
