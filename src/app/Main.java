package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("chatViewer.fxml"));
        primaryStage.setTitle("Chat Viewer");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.setMinHeight(100);
        primaryStage.setMinWidth(100);
        primaryStage.show();
        stage = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
