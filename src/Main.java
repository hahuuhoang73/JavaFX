import controler.Home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
//        Parent root = FXMLLoader.load(getClass().getResource("thongtin.fxml"));
//        primaryStage.setScene(new Scene(root,800,600));
//        primaryStage.show();
//        Parent root = FXMLLoader.load(getClass().getResource("demnguoc.fxml"));
//        primaryStage.setScene(new Scene(root,600,400));
//        primaryStage.show();




        Home.rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("ressouver/home.fxml"));
        primaryStage.setScene(new Scene(root,800,600));
        primaryStage.show();

    }

}
