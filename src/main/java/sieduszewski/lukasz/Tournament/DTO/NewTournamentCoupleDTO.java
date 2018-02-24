package sieduszewski.lukasz.Tournament.DTO;

public class NewTournamentCoupleDTO {

    private Integer id;
    private Integer startNumber;

    public NewTournamentCoupleDTO() {
    }

    public NewTournamentCoupleDTO(Integer id, Integer startNumber) {
        this.id = id;
        this.startNumber = startNumber;
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
}
