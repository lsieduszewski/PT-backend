package sieduszewski.lukasz.CentralDB.Data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import sieduszewski.lukasz.Tournament.Data.TournamentCouple;

import javax.persistence.*;
import java.util.List;

@Entity
public class Couple {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Dancer male;

    @ManyToOne(fetch = FetchType.EAGER)
    private Dancer female;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="club_id")
    private Club club;

    @JsonIgnore
    @OneToMany(mappedBy = "couple")
    private List<TournamentCouple> tournamentCouple;

    public Couple() {
    }

     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Dancer getMale() {
        return male;
    }

    public void setMale(Dancer male) {
        this.male = male;
    }

    public Dancer getFemale() {
        return female;
    }

    public void setFemale(Dancer female) {
        this.female = female;
    }

    public List<TournamentCouple> getTournamentCouple() {
        return tournamentCouple;
    }

    public void setTournamentCouple(List<TournamentCouple> tournamentCouple) {
        this.tournamentCouple = tournamentCouple;
    }
}
