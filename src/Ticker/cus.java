package Ticker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.io.IOException;

public class cus {
    @FXML
    private Label custom_total;

    @FXML
    private TextField custom_seach;

    @FXML
    private AnchorPane sold_from;

    @FXML
    private Label custom_id;

//    @FXML
//    private TableView<?> custom_table;

    @FXML
    private Label custom_tile;

//    @FXML
//    private TableColumn<?, ?> custom_col_time;
//
//    @FXML
//    private TableColumn<?, ?> custom_col_tile;
//
//    @FXML
//    private TableColumn<?, ?> custom_col_total;
//
//    @FXML
//    private TableColumn<?, ?> custom_col_id;

    @FXML
    private Label custom_time;

//    @FXML
//    private TableColumn<?, ?> custom_col_date;

    @FXML
    private Label custom_date;

    @FXML
    private Button custom_clear;

    @FXML
    private Button custom_delete;

    public void gotoTo(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/movie.fxml"));

        Scene scene = new Scene(root);

        FXMLdoccument.rootStage.setScene(scene);
    }

    public void gotoShop(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/tesst2.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);
    }

    public void gotoBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/tesst1.fxml"));

        Scene scene = new Scene(root);

        FXMLdoccument.rootStage.setScene(scene);
    }
}
