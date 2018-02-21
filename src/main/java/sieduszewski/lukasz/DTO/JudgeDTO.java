package sieduszewski.lukasz.DTO;

import sieduszewski.lukasz.Data.Judge;

public class JudgeDTO {

    private Integer id;
    private String surname;
    private String name;
    private String city;
    private String country;

    public JudgeDTO() {
    }

    public JudgeDTO(Judge judge) {
        this.id = judge.getId();
        this.surname = judge.getSurname();
        this.name = judge.getName();
        this.city = judge.getCity();
        this.country = judge.getCountry();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
}
