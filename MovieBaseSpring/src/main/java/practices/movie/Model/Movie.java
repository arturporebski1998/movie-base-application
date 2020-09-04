package practices.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private double avgRate;
    private String director;
    private String description;
    private String country;
    private String genre;

    //Będzie enum tylko niech najpierw zadziała apka
//    @Enumerated(EnumType.STRING)
//    private ECountry country;
//    @Enumerated(EnumType.STRING)
//    private EGenre genre;

    @Column(nullable = false, unique = true)
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAvgRate() { return avgRate; }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }

//    public EGenre getGenre() { return genre; }
//
//    public void setGenre(EGenre genre) { this.genre = genre; }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

//    public ECountry getCountry() { return country; }
//
//    public void setCountry(ECountry country) { this.country = country; }

}