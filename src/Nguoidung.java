public class Nguoidung {
    String Name;
    String Phone;

    public Nguoidung(String name, String phone) {
        Name = name;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
    public  String toString(){
        return this.Name;
    }

    public void setOnAction(Object o) {

    }
}
