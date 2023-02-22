package Ticker;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class shoop {
    private  double x=0;
    private double y=0;
    public void gotoBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/tesst1.fxml"));

        Scene scene = new Scene(root);

        FXMLdoccument.rootStage.setScene(scene);



    }

    public void gotoMovi(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/movie.fxml"));

        Scene scene = new Scene(root);

        FXMLdoccument.rootStage.setScene(scene);

    }



    public void gotoTO(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/customers.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }
}
