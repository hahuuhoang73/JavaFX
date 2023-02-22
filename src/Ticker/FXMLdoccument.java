package Ticker;

import controler.Home;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLdoccument implements Initializable {
    private  double x=0;
    private double y=0;
    public   static  Stage rootStage;
    @FXML
    private Button main_minisize;

    @FXML
    private AnchorPane main_from1;

    @FXML
    private Button main_close;

    @FXML
    private AnchorPane main_from;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img3;



    @FXML
    private ImageView img2;

    @FXML
    private ImageView img1;
    @FXML
    private Button signin_close;

    @FXML
    private PasswordField signin_password;

    @FXML
    private TextField signUp_username;

    @FXML
    private AnchorPane signUp_form;

    @FXML
    private TextField signin_username;

    @FXML
    private Button signUp_minimize;

    @FXML
    private Button signin_minimize;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private Button signUp_signupBtn;

    @FXML
    private Button signin_loginBtn;

    @FXML
    private PasswordField signUp_password;

    @FXML
    private Hyperlink signUp_alreadyAccount;

    @FXML
    private Hyperlink signin_createAccount;

    @FXML
    private TextField signUp_email;

    @FXML
    private Button signUp_close;
public void slider(){
    new Thread(){
        public void run(){
            int count =0;
            try {
                while (true) {
                    switch (count) {
                        case 0:
                            Thread.sleep(5000);

                            TranslateTransition slider1 = new TranslateTransition();
                            slider1.setNode(img1);
                            slider1.setDuration(Duration.seconds(3));
                            slider1.setToX(0);
                            slider1.play();

                            TranslateTransition slider2 = new TranslateTransition();
                            slider2.setNode(img2);
                            slider2.setDuration(Duration.seconds(3));
                            slider2.setToX(0);
                            slider2.play();

                            TranslateTransition slider3 = new TranslateTransition();
                            slider3.setNode(img3);
                            slider3.setDuration(Duration.seconds(3));
                            slider3.setToX(-600);
                            slider3.play();

                            TranslateTransition slider4 = new TranslateTransition();
                            slider4.setNode(img4);
                            slider4.setDuration(Duration.seconds(3));
                            slider4.setToX(-1200);
                            slider4.play();

                            count =1;
                            break;
                        case 1:
                            Thread.sleep(5000);
                            TranslateTransition slider5 = new TranslateTransition();
                            slider5.setNode(img1);
                            slider5.setDuration(Duration.seconds(3));
                            slider5.setToX(600);
                            slider5.play();

                            TranslateTransition slider6 = new TranslateTransition();
                            slider6.setNode(img2);
                            slider6.setDuration(Duration.seconds(3));
                            slider6.setToX(600);
                            slider6.play();

                            TranslateTransition slider7 = new TranslateTransition();
                            slider7.setNode(img3);
                            slider7.setDuration(Duration.seconds(3));
                            slider7.setToX(0);
                            slider7.play();

                            TranslateTransition slider8 = new TranslateTransition();
                            slider8.setNode(img4);
                            slider8.setDuration(Duration.seconds(3));
                            slider8.setToX(-600);
                            slider8.play();

                            count =2;
                            break;

                        case  2:
                            Thread.sleep(5000);
                            TranslateTransition slider9 = new TranslateTransition();
                            slider9.setNode(img1);
                            slider9.setDuration(Duration.seconds(3));
                            slider9.setToX(1200);
                            slider9.play();

                            TranslateTransition slider10 = new TranslateTransition();
                            slider10.setNode(img2);
                            slider10.setDuration(Duration.seconds(3));
                            slider10.setToX(1200);
                            slider10.play();

                            TranslateTransition slider11 = new TranslateTransition();
                            slider11.setNode(img3);
                            slider11.setDuration(Duration.seconds(3));
                            slider11.setToX(600);
                            slider11.play();

                            TranslateTransition slider12 = new TranslateTransition();
                            slider12.setNode(img4);
                            slider12.setDuration(Duration.seconds(3));
                            slider12.setToX(0);
                            slider12.play();

                            count =3;
                            break;
                        case 3:
                            Thread.sleep(5000);
                            TranslateTransition slider13 = new TranslateTransition();
                            slider13.setNode(img1);
                            slider13.setDuration(Duration.seconds(3));
                            slider13.setToX(1200);
                            slider13.play();

                            TranslateTransition slider14 = new TranslateTransition();
                            slider14.setNode(img2);
                            slider14.setDuration(Duration.seconds(3));
                            slider14.setToX(1200);
                            slider14.play();

                            TranslateTransition slider15 = new TranslateTransition();
                            slider15.setNode(img3);
                            slider15.setDuration(Duration.seconds(3));
                            slider15.setToX(1200);
                            slider15.play();

                            TranslateTransition slider16 = new TranslateTransition();
                            slider16.setNode(img4);
                            slider16.setDuration(Duration.seconds(3));
                            slider16.setToX(600);
                            slider16.play();

                            count =0;
                            break;









                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }.start();
}

    public void switchFrom(ActionEvent event){
        if (event.getSource() == signin_createAccount ){
            signin_form.setVisible(false);
            signUp_form.setVisible(true);
        }else if (event.getSource() == signUp_alreadyAccount){
            signin_form.setVisible(true);
            signUp_form.setVisible(false);
        }
    }
    public void main_close(){
       System.exit(0);
    }
    public void main_minisize(){
        Stage stage = (Stage)main_from.getScene().getWindow();
        stage.setIconified(true);

    }
    public void signup_close(){





        System.exit(0);
    }
    public void signup_minisize(){
        Stage stage = (Stage)signin_form.getScene().getWindow();
        stage.setIconified(true);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slider();

    }

    public void gotoShoop(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../MovieTicket/Movie/tesst2.fxml"));

        Scene scene = new Scene(root);


        FXMLdoccument.rootStage.setScene(scene);



    }
}
