package cangtin;

import Ticker.FXMLdoccument;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Home {

    public void gotoBanhang(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/cuahang.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);


    }

    public void gotoLS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/lichsu.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }
}
