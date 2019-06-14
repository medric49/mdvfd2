package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../app/views/main.fxml"));
        primaryStage.setTitle("Différences et Volumes finis");
        primaryStage.getIcons().add(new Image("app/assets/img/icon.png"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(600);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
