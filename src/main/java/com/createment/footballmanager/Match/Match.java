package com.createment.footballmanager.Match;

import com.createment.footballmanager.Team.Team;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String startTime;
    @OneToOne
    @JoinColumn(name = "home_team")
    private Team homeTeam;
    @OneToOne
    @JoinColumn(name = "away_team")
    private Team awayTeam;

    public Integer getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id) && Objects.equals(startTime, match.startTime) && Objects.equals(homeTeam, match.homeTeam) && Objects.equals(awayTeam, match.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, homeTeam, awayTeam);
    }
}
