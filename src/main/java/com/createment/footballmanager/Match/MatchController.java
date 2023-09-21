package com.createment.footballmanager.Match;

import com.createment.footballmanager.Match.Event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private MatchRepository matchRepository;

    @Autowired
    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public List<Match> showAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("teams/{teamId}")
    public List<Match> showMatchesByTeamById(@PathVariable Integer teamId) {
        return matchRepository.findAllByHomeTeamIdOrAwayTeamId(teamId, teamId);
    }


}
