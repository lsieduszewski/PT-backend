package sieduszewski.lukasz.Tournament.DTO;

public class NewTournamentJudgeDTO {

    private Integer id;
    private String tournamentId;

    public NewTournamentJudgeDTO() {
    }

    public NewTournamentJudgeDTO(Integer id, String tournamentId) {
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
