package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home {
    public  static  Stage rootStage;


    public void gotoClasss(ActionEvent actionEvent) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../ressouver/classer/list.fxml"));
         Home.rootStage.setScene(new Scene(root,800,600));





    }

    public void gotoStudent(ActionEvent actionEvent)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../ressouver/classer/studenlist.fxml"));
       Home.rootStage.setScene(new Scene(root,800,600));
    }
}
