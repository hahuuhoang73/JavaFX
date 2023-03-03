package Phim;

import java.sql.Date;
import java.sql.Time;

public class Cutommer {
    Integer id;
    String type;
    Double toal;
    Date date;
    String title;
    Time time;

    public Cutommer(Integer id, String type, Double toal, Date date, String title, Time time) {
        this.id = id;
        this.type = type;
        this.toal = toal;
        this.date = date;
        this.title = title;
        this.time = time;
    }

    public Cutommer(int id) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getToal() {
        return toal;
    }

    public void setToal(Double toal) {
        this.toal = toal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
