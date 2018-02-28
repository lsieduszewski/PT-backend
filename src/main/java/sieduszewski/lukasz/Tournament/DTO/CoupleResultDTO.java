package sieduszewski.lukasz.Tournament.DTO;

import sieduszewski.lukasz.Tournament.Data.TournamentCouple;

public class CoupleResultDTO {

    private Integer startNumber;
    private String maleName;
    private String femaleName;
    private String club;
    private String place;
    private String inTournament;

    public CoupleResultDTO() {
    }

    public CoupleResultDTO(TournamentCouple tournamentCouple) {
        this.startNumber = tournamentCouple.getStartNumber();
        this.maleName = tournamentCouple.getCouple().getMale().getSurname() + " " +  tournamentCouple.getCouple().getMale().getName();
        this.femaleName = tournamentCouple.getCouple().getFemale().getSurname() + " " + tournamentCouple.getCouple().getFemale().getName();
        this.club = tournamentCouple.getCouple().getClub().getName() + " " + tournamentCouple.getCouple().getClub().getCity();
        if (tournamentCouple.isInTournament()) {
            this.place = "0";
            this.inTournament = "wciąż w zawodach";
        } else {
            this.place = tournamentCouple.getPlace().toString();
            this.inTournament = "zakończył udział w zawodach";
        }

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getInTournament() {
        return inTournament;
    }

    public void setInTournament(String inTournament) {
        this.inTournament = inTournament;
    }
}
