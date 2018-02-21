package sieduszewski.lukasz.DTO;

import sieduszewski.lukasz.Data.Club;

public class ClubDTO {

    private Integer id;
    private String name;
    private String city;
    private String country;

    public ClubDTO() {
    }

    public ClubDTO(Club club) {
        this.id = club.getId();
        this.name = club.getName();
        this.city = club.getCity();
        this.country = club.getCountry();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
