package com.createment.footballmanager.Match;

import com.createment.footballmanager.Player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findAllByHomeTeamIdOrAwayTeamId(Integer homeTeamId, Integer awayTeamId);
}
