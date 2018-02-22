package sieduszewski.lukasz.CentralDB.DTO;

import sieduszewski.lukasz.CentralDB.Data.Couple;

public class CoupleDTO {

    private Integer id;
    private String male;
    private String female;
    private String club;

    public CoupleDTO() {
    }

    public CoupleDTO(Couple couple) {
        this.id = couple.getId();
        this.male = couple.getMale().getSurname() + " " + couple.getMale().getName();
        this.female = couple.getFemale().getSurname() + " " + couple.getFemale().getName();
        this.club = couple.getClub().getName() + " " + couple.getClub().getCity() + " " + couple.getClub().getCountry();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
