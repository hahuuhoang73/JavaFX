package test;

import Ticker.FXMLdoccument;
import controler.Home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MovieTicke extends Application {

    private  double x=0;
    private double y=0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
//        Parent root = FXMLLoader.load(getClass().getResource("thongtin.fxml"));
//        primaryStage.setScene(new Scene(root,800,600));
//        primaryStage.show();
//        Parent root = FXMLLoader.load(getClass().getResource("danhsach.fxml"));
//        primaryStage.setScene(new Scene(root,800,600));
//        primaryStage.show();
        FXMLdoccument.rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/tesst1.fxml"));


        Scene scene = new Scene(root);




//        root.setOnMousePressed((MouseEvent event)->{
//            x = event.getSceneX();
//            y = event.getSceneY();
//        });
//        root.setOnMouseDragged((MouseEvent event)->{
//            primaryStage.setX(event.getScreenX()-x);
//            primaryStage.setY(event.getScreenY()-y);
//
//        });
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("Css/test.css");
        primaryStage.show();
    }
}

