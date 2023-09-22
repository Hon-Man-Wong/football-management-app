package com.createment.footballmanager.Team;

import com.createment.footballmanager.Country;
import com.createment.footballmanager.League;
import com.createment.footballmanager.Match.Match;
import com.createment.footballmanager.Player.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 40)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private List<Player> playerList = new ArrayList<>();
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private League league;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Country country;
    @Column
    private String city;
    @JsonIgnore
    @OneToMany(mappedBy = "homeTeam")
    private List<Match> homeMatchList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "awayTeam")
    private List<Match> awayMatchList = new ArrayList<>();

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

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Match> getHomeMatchList() {
        return homeMatchList;
    }

    public void setHomeMatchList(List<Match> homeMatchList) {
        this.homeMatchList = homeMatchList;
    }

    public List<Match> getAwayMatchList() {
        return awayMatchList;
    }

    public void setAwayMatchList(List<Match> awayMatchList) {
        this.awayMatchList = awayMatchList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name) && Objects.equals(playerList, team.playerList) && Objects.equals(description, team.description) && Objects.equals(league, team.league) && Objects.equals(country, team.country) && Objects.equals(city, team.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, playerList, description, league, country, city);
    }
}
