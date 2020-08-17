package practices.movie.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //public int getDate() { return date; }

    //public void setDate(int date) {
       // this.date = date;
   // }

    public double getAvgRate() { return avgRate; }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    //@Column
    //private int date;

    @Column
    double avgRate;

    @Column
    // should be some kind of string ENUM
    private String genre;

    @Column
    private String director;

    @Column
    private String country;

    @Column
    private String description;



}