package sieduszewski.lukasz.CentralDB.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sieduszewski.lukasz.Tournament.Data.TournamentJudge;

import javax.persistence.*;
import java.util.List;

@Entity
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String surname;
    private String name;
    private String city;
    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "judge")
    private List<TournamentJudge> tournamentJudges;

    public Judge() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<TournamentJudge> getTournamentJudges() {
        return tournamentJudges;
    }

    public void setTournamentJudges(List<TournamentJudge> tournamentJudges) {
        this.tournamentJudges = tournamentJudges;
    }
}
