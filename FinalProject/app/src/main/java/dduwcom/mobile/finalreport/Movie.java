package dduwcom.mobile.finalreport;

import java.io.Serializable;

public class Movie implements Serializable {
    long _id;
    String movieName;
    String genre;
    String rating;
    int imgIcon;
    String director;
    String actor;
    String date;

    public Movie(long _id, String movieName, String genre, String rating, int imgIcon) {
        this._id = _id;
        this.movieName = movieName;
        this.genre = genre;
        this.rating = rating;
        this.imgIcon = imgIcon;
    }

    public Movie(long _id, String movieName, String genre, String rating, int imgIcon, String director, String actor, String date) {
        this._id = _id;
        this.movieName = movieName;
        this.genre = genre;
        this.rating = rating;
        this.imgIcon = imgIcon;
        this.director = director;
        this.actor = actor;
        this.date = date;
    }

    public Movie(String movieName, String genre, String rating, int imgIcon, String director, String actor, String date) {
        this.movieName = movieName;
        this.genre = genre;
        this.rating = rating;
        this.imgIcon = imgIcon;
        this.director = director;
        this.actor = actor;
        this.date = date;
    }

    public Movie(String movieName, String genre, String rating, int imgIcon) {
        this.movieName = movieName;
        this.genre = genre;
        this.rating = rating;
        this.imgIcon = imgIcon;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(int imgIcon) {
        this.imgIcon = imgIcon;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
