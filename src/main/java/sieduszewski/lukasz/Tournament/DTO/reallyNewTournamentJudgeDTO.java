package sieduszewski.lukasz.Tournament.DTO;

public class reallyNewTournamentJudgeDTO {

    private Integer id;
    private String tournamentId;

    public reallyNewTournamentJudgeDTO() {
    }

    public reallyNewTournamentJudgeDTO(Integer id, String tournamentId) {
        this.id = id;
        this.tournamentId = tournamentId;
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


}
