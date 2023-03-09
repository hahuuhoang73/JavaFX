package entities;

public class Cuahang {
    Integer id;
    String name;
    Double giatien;

    public Cuahang(Integer id, String name, Double giatien) {
        this.id = id;
        this.name = name;
        this.giatien = giatien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGiatien() {
        return giatien;
    }

    public void setGiatien(Double giatien) {
        this.giatien = giatien;
    }
}
