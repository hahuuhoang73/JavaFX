package entities;

import java.util.Date;

public class Lichsu {
    Integer id;
    String name;
    Integer soluong;
     Double giatien;
     Date date;

    public Lichsu(Integer id, String name, Integer soluong, Double giatien, Date date) {
        this.id = id;
        this.name = name;
        this.soluong = soluong;
        this.giatien = giatien;
        this.date = date;
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

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Double getGiatien() {
        return giatien;
    }

    public void setGiatien(Double giatien) {
        this.giatien = giatien;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
