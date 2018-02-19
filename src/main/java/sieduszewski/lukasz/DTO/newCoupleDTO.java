package sieduszewski.lukasz.DTO;

import sieduszewski.lukasz.Data.Couple;
import sieduszewski.lukasz.Data.Dancer;

public class newCoupleDTO {

    private Integer male;
    private Integer female;
    private String club;

    public newCoupleDTO() {
    }

    public newCoupleDTO(Integer male, Integer female, String club) {
        this.male = male;
        this.female = female;
        this.club = club;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public Integer getFemale() {
        return female;
    }

    public void setFemale(Integer female) {
        this.female = female;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
