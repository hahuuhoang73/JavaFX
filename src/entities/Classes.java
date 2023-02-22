package entities;

public class Classes {
    Integer id;
    String Name;
    String Room;

    public Classes(Integer id, String name, String room) {
        this.id = id;
        Name = name;
        Room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }
    public  String toString(){
        return this.getName();
    }

}
