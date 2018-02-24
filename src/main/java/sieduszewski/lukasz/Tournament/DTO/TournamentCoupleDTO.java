package sieduszewski.lukasz.Tournament.DTO;

import sieduszewski.lukasz.CentralDB.Data.Couple;
import sieduszewski.lukasz.Tournament.Data.TournamentCouple;

public class TournamentCoupleDTO {

    private Integer startNumber;
    private String maleName;
    private String femaleName;
    private String club;

    public TournamentCoupleDTO() {
    }

    public TournamentCoupleDTO(TournamentCouple tournamentCouple) {
        this.startNumber = tournamentCouple.getStartNumber();
        this.maleName = tournamentCouple.getCouple().getMale().getSurname() + " " +  tournamentCouple.getCouple().getMale().getName();
        this.femaleName = tournamentCouple.getCouple().getFemale().getSurname() + " " + tournamentCouple.getCouple().getFemale().getName();
        this.club = tournamentCouple.getCouple().getClub().getName() + " " + tournamentCouple.getCouple().getClub().getCity();
    }

    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }

    public String getMaleName() {
        return maleName;
    }

    public void setMaleName(String maleName) {
        this.maleName = maleName;
    }

    public String getFemaleName() {
        return femaleName;
    }

    public void setFemaleName(String femaleName) {
        this.femaleName = femaleName;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
