package com.createment.footballmanager.Match;

import com.createment.footballmanager.Match.Event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(params = "team")
    public List<Match> showMatchesByTeamById(@RequestParam("team") Integer teamId) {
        return matchRepository.findAllByHomeTeamIdOrAwayTeamId(teamId, teamId);
    }


}
