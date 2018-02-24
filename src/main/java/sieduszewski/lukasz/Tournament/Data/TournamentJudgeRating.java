package sieduszewski.lukasz.Tournament.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class TournamentJudgeRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer operationId;

    private String round;
    private String dance;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="judge_id")
    private TournamentJudge tournamentJudge;

    private String judgesRating;

    public TournamentJudgeRating() {
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getDance() {
        return dance;
    }

    public void setDance(String dance) {
        this.dance = dance;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public TournamentJudge getTournamentJudge() {
        return tournamentJudge;
    }

    public void setTournamentJudge(TournamentJudge tournamentJudge) {
        this.tournamentJudge = tournamentJudge;
    }

    public String getJudgesRating() {
        return judgesRating;
    }

    public void setJudgesRating(String judgesRating) {
        this.judgesRating = judgesRating;
    }
}
