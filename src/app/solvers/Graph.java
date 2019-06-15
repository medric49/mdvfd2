package app.solvers;


import eu.hansolo.tilesfx.chart.PixelMatrix;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Graph{

    public static Color[] colors = new Color[]{
            Color.color(0, 0.5, 0.8,0.1),
            Color.color(0, 0.5, 0.8,0.15),
            Color.color(0, 0.5, 0.8,0.2),
            Color.color(0, 0.5, 0.8,0.25),
            Color.color(0, 0.5, 0.8,0.3),
            Color.color(0, 0.5, 0.8,0.35),
            Color.color(0, 0.5, 0.8,0.4),
            Color.color(0, 0.5, 0.8,0.45),
            Color.color(0, 0.5, 0.8,0.5),
            Color.color(0, 0.5, 0.8,0.55),
            Color.color(0, 0.5, 0.8,0.6),
            Color.color(0, 0.5, 0.8,0.65),
            Color.color(0, 0.5, 0.8,0.7),
            Color.color(0, 0.5, 0.8,0.75),
            Color.color(0, 0.5, 0.8,0.8),
            Color.color(0, 0.5, 0.8,0.85),
            Color.color(0, 0.5, 0.8,0.9),
            Color.color(0, 0.5, 0.8,1),

            };
    public Tooltip mousePositionToolTip = new Tooltip("");
    public static double U[][];
    private PixelMatrix matrix;
    
    public Graph(){

    }

    public PixelMatrix go() {
        int N = U.length - 2;
        matrix = new PixelMatrix();
        matrix.setMinSize(450, 450);
        matrix.setColsAndRows(N+1,N+1);
        matrix.setSquarePixels(true);
        matrix.setSpacerSizeFactor(0);
        matrix.setStyle("-fx-border-color:#00aae4");
        matrix.setAllPixelsOn();
        double min  = 0, max = 0;
        double averages[][] = new double[N+1][N+1];
        for(int j = 0; j < N+1; j++){
            for(int i = 0; i < N+1; i++){
                averages[i][j] = (U[i][j]+U[i+1][j]+U[i][j+1]+U[i+1][j+1])/4;
                if(i + j == 0){
                    min = averages[i][j];
                    max = averages[i][j];
                }else{
                    min = Math.min(min, averages[i][j]);
                    max = Math.max(max, averages[i][j]);
                }
            }
        }

        for(int j = 0; j < N+1; j++){
            for(int i = 0; i < N+1; i++){
                if(max == min){
                    matrix.setPixel(i, j, colors[0]);
                }else{
                    matrix.setPixel(i,N-j, colors[Math.min(colors.length-1,Math.round((float)(colors.length*(averages[i][j]-min)/(max-min))))]);
                }
            }
        }
         
        matrix.setOnMouseMoved((event)->{
            javafx.geometry.Point2D point = matrix.sceneToLocal(event.getSceneX(), event.getSceneY());
            double x = point.getX()/matrix.getWidth();
            double y = 1-point.getY()/matrix.getHeight();
            double u = interpolation(x,y);
            mousePositionToolTip.setText(String.format("(x = %.5f; y = %.5f ; U = %.5f)",x,y,u));
            Node node = (Node) event.getSource();
            mousePositionToolTip.show(node, event.getScreenX() + 50, event.getScreenY());            
        });
        
        
        matrix.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mousePositionToolTip.hide();
            }
        });
        
        return matrix;
    }
    
    public double interpolation(double x, double y){
        int N = U.length - 2;
        double u = 0.0;
        double h = 1.0/(N+1);
        int n = (int)(x*(N+1));
        int m = (int)(y*(N+1));
        if(n == N + 1 && m == N + 1){
            u = U[N+1][N+1];
        }else if(n == N + 1 && m != N + 1){
            u = ((y-m*h)*U[N+1][m+1]-(y-(m+1)*h)*U[N+1][m])*(N+1);  
        }else if(n != N + 1 && m == N + 1){
            u = ((x-n*h)*U[n+1][N+1]-(x-(n+1)*h)*U[n][N+1])*(N+1);
        }else{
            for(int i = n ; i < n + 2 ; i++){
                for(int j = m ; j < m + 2 ; j++){
                    double numerateur = 1.0;
                    double denominateur = 1.0;
                    for(int a = n ; a < n + 2 ; a++){
                        for(int b = m ; b < m + 2 ; b++){
                            if( a != i && b != j){
                                numerateur *= (x-a*h)*(y-b*h);
                                denominateur *= (i-a)*(j-b)*h*h;
                            }
                        }
                    }
                    
                    u += (numerateur/denominateur)*U[i][j];  
                }
            }
        }
        return u;
    }
    
}
