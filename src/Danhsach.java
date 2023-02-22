import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Danhsach {

    public TextField txtNguoinhan;
    public TextField txtTieude;
    public TextArea txtNoidung;
    public Text txtInfo;

    public void submit(ActionEvent actionEvent) {
        String nn=txtNguoinhan.getText();
        String tt=txtTieude.getText();
        String nd = txtNoidung.getText();
        String txt =txtInfo.getText();
        txt+="\n============";
        txt+="\nTên Người dùng: "+nn+"\n"+"Tiêu Đề: "+tt+"\n"+"Nội Dung: "+"\n"+nd;
        txtInfo.setText(txt);
        txtNguoinhan.clear();
        txtTieude.clear();
        txtNoidung.clear();
    }
}
