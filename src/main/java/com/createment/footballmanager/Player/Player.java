package com.createment.footballmanager.Player;

import com.createment.footballmanager.Enumerations.Country;
import com.createment.footballmanager.Enumerations.Position;
import com.createment.footballmanager.Team.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;
    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;
    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    private Position position;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private Integer age;
    @Column
    private String city;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Country country;
    @Column
    private Integer shirtNumber;
    @Column
    private String imagePath;
    private String imageType;
    private String imageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @JsonIgnore
    public String getTeamName(){
        Team team = this.getTeam();
        return team.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(team, player.team) && Objects.equals(position, player.position) && Objects.equals(dateOfBirth, player.dateOfBirth) && Objects.equals(city, player.city) && Objects.equals(country, player.country) && Objects.equals(shirtNumber, player.shirtNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, team, position, dateOfBirth, city, country, shirtNumber);
    }
}
