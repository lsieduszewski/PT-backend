package sieduszewski.lukasz.Tournament.Data;

import org.hibernate.annotations.Type;
import sieduszewski.lukasz.CentralDB.Data.Couple;

import javax.persistence.*;

@Entity
public class TournamentCouple {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer startNumber;

    @ManyToOne(fetch=FetchType.EAGER)    //many na później jak będą kategorie, mogłoby być OneToOne na ten moment
    @JoinColumn(name="couple_id")
    private Couple couple;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean inTournament;

    private Integer place;
    private Integer roundPoint;

    public TournamentCouple() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }

    public Couple getCouple() {
        return couple;
    }

    public void setCouple(Couple couple) {
        this.couple = couple;
    }

    public boolean isInTournament() {
        return inTournament;
    }

    public void setInTournament(boolean inTournament) {
        this.inTournament = inTournament;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getRoundPoint() {
        return roundPoint;
    }

    public void setRoundPoint(Integer roundPoint) {
        this.roundPoint = roundPoint;
    }
}
