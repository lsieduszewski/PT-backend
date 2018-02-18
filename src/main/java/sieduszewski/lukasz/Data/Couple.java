package sieduszewski.lukasz.Data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import sieduszewski.lukasz.DTO.newCoupleDTO;

import javax.persistence.*;

@Entity
public class Couple {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Dancer male;

    @ManyToOne(fetch = FetchType.LAZY)
    private Dancer female;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="club_id")
    private Club club;

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
}
