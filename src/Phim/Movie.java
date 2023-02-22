package Phim;

import java.sql.Date;

public class Movie {
    Integer id;
    String tile;
    String genre;
    String img;
    String time;
    Date date;

    public Movie(Integer id, String tile, String genre, String img, String time, Date date) {
        this.id = id;
        this.tile = tile;
        this.genre = genre;
        this.img = img;
        this.time = time;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
