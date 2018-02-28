package sieduszewski.lukasz.Tournament.DTO;

import sieduszewski.lukasz.Tournament.Data.TournamentJudgeRating;

public class TournamentJudgeRatingDTO {

    private Integer oprtationId;
    private String round;
    private String dance;
    private Integer judgeId;
    private String judgesRating;

    public TournamentJudgeRatingDTO() {
    }

    public TournamentJudgeRatingDTO(TournamentJudgeRating tournamentJudgeRating) {
        this.oprtationId = tournamentJudgeRating.getOperationId();
        this.round = tournamentJudgeRating.getRound();
        this.dance = tournamentJudgeRating.getDance();
        this.judgeId = tournamentJudgeRating.getTournamentJudge().getJudge().getId();
        this.judgesRating = tournamentJudgeRating.getJudgesRating();
    }

    public Integer getOprtationId() {
        return oprtationId;
    }

    public void setOprtationId(Integer oprtationId) {
        this.oprtationId = oprtationId;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getDance() {
        return dance;
    }

    public void setDance(String dance) {
        this.dance = dance;
    }

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public String getJudgesRating() {
        return judgesRating;
    }

    public void setJudgesRating(String judgesRating) {
        this.judgesRating = judgesRating;
    }


}
