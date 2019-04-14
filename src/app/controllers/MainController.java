package app.controllers;

import app.solvers.DFSolver;
import app.solvers.VFSolver;
import com.jfoenix.controls.JFXTextField;
import com.med.mdvfd2.ASolver;
import com.med.mdvfd2.Pair;
import com.med.mdvfd2.Vector;
import com.med.mdvfd2.Vectorizable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private AnchorPane chartContainer;
    @FXML
    private JFXTextField fExpression;
    @FXML
    private JFXTextField gExpression;
    @FXML
    private JFXTextField nValue;

    private String fString = "";
    private String gString = "";
    private int n = 0;

    private DFSolver dfSolver = new DFSolver();
    private VFSolver vfSolver = new VFSolver();

    private Vectorizable vector1 = null;
    private Vectorizable vector2 = null;


    private boolean multithreading = false;
    private byte viewType = 1;
    private byte methodType = 1;

    private NumberAxis xAxis = new NumberAxis(0, 1, 0.1);
    private NumberAxis yAxis = new NumberAxis(0, 1, 0.1);

    private ScatterChart<String, Number> scatterChart = new ScatterChart(xAxis, yAxis);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.xAxis.setLabel("x");
        this.yAxis.setLabel("y");
        this.chartContainer.getChildren().add(scatterChart);
        this.scatterChart.setMinHeight(460);
        this.scatterChart.setMinWidth(700);
    }

    @FXML
    private void setView1(ActionEvent event) {
        this.viewType = 1;
    }

    @FXML
    private void setView2(ActionEvent event) {
        this.viewType = 2;
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

            if (fString.isEmpty() || this.gString.isEmpty() || n<=0) {
                return;
            }
            else {
                this.xAxis.setTickUnit(1./(n+1));
                this.yAxis.setTickUnit(1./(n+1));


                if (this.methodType == 1) {
                    this.dfSolver.setF(fString);
                    this.dfSolver.setG(gString);
                    this.dfSolver.setN(n);

                    this.vector1 = new Vector(n);

                    (new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Vectorizable v = dfSolver.solve(multithreading);
                            for (int i = 0; i<n; i++ )
                                vector1.set(i, v.get(i));
                        }
                    }).start();

                    Pair[] pairs =  ASolver.getMaillage(n);

                    XYChart.Series series = new XYChart.Series();

                    for (int i= 0; i<pairs.length; i++)
                        series.getData().add(new XYChart.Data(pairs[i].x(), pairs[i].y()));

                    scatterChart.getData().clear();
                    scatterChart.getData().addAll(series);

                }
                else {

                }

            }

        }catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
