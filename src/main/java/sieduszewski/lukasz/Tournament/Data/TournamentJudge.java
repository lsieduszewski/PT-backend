package sieduszewski.lukasz.Tournament.Data;


import sieduszewski.lukasz.CentralDB.Data.Judge;

import javax.persistence.*;
import java.util.List;


@Entity
public class TournamentJudge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tournamentId;

    @ManyToOne(fetch=FetchType.EAGER)    //many na później jak będą kategorie, mogłoby być OneToOne na ten moment
    @JoinColumn(name="judge_id")
    private Judge judge;

    @OneToMany(mappedBy = "tournamentJudge")
    private List<TournamentJudgeRating> tournamentJudgeRatingList;

    public TournamentJudge() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }


    public List<TournamentJudgeRating> getTournamentJudgeRatingList() {
        return tournamentJudgeRatingList;
    }

    public void setTournamentJudgeRatingList(List<TournamentJudgeRating> tournamentJudgeRatingList) {
        this.tournamentJudgeRatingList = tournamentJudgeRatingList;
    }
}
