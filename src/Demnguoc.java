import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class Demnguoc extends Thread {

    public Label min;
    public Label sec;

    private Integer  minutes=9, seconds=10;


    public void start(ActionEvent actionEvent) {
        minutes = Integer.parseInt(min.getText());
        seconds = Integer.parseInt(sec.getText());
        for (int m = minutes;m>=0;m--){
            int bd ;
            int dl;
            if (m==minutes){
                bd=seconds;
            }else {
                bd=59;
            }
            if (m==0){
                dl=0;
            }else {
                dl=-1;
            }
            for (int s=bd;s>dl;s--){
                min.setText(String.format("%02d:%02d",m,s));

                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

    }
}
