package com.createment.footballmanager.Match;

import com.createment.footballmanager.Team.Team;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalDateTime startTime;
    @OneToOne
    @JoinColumn(name = "home_team")
    private Team homeTeam;
    @OneToOne
    @JoinColumn(name = "away_team")
    private Team awayTeam;
    @Column(length = 10)
    private String score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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
