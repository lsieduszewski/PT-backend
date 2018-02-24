package sieduszewski.lukasz.Tournament.DTO;

import sieduszewski.lukasz.Tournament.Data.TournamentJudge;

public class TournamentJudgeDTO {

//    private Integer id; //niepotrzebne??
    private String tournamentId;
    private String judgeName;
    private String judgeCity;
    private String judgeCountry;

    public TournamentJudgeDTO() {
    }

   public TournamentJudgeDTO(TournamentJudge tournamentJudge) {
//        this.id = tournamentJudge.getId();
        this.tournamentId = tournamentJudge.getTournamentId();
        this.judgeName = tournamentJudge.getJudge().getSurname() + " " + tournamentJudge.getJudge().getName();
        this.judgeCity = tournamentJudge.getJudge().getCity();
        this.judgeCountry = tournamentJudge.getJudge().getCountry();
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    public String getJudgeCity() {
        return judgeCity;
    }

    public void setJudgeCity(String judgeCity) {
        this.judgeCity = judgeCity;
    }

    public String getJudgeCountry() {
        return judgeCountry;
    }

    public void setJudgeCountry(String judgeCountry) {
        this.judgeCountry = judgeCountry;
    }
}
