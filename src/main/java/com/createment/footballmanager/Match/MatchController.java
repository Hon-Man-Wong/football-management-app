package com.createment.footballmanager.Match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/matches")
public class MatchController {
    private MatchRepository matchRepository;
    private MatchService matchService;

    @Autowired
    public MatchController(MatchRepository matchRepository, MatchService matchService) {
        this.matchRepository = matchRepository;
        this.matchService = matchService;
    }

    @GetMapping
    public List<Match> showAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping(params = "team")
    public List<Match> showMatchesByTeamById(@RequestParam("team") Integer teamId) {
        return matchRepository.findAllByHomeTeamIdOrAwayTeamId(teamId, teamId);
    }

    @PostMapping
    public Match addMatch(@RequestBody Match match) {
        return matchRepository.save(match);
    }

    @PutMapping("{matchId}")
    public ResponseEntity updateMatch(@PathVariable Integer matchId, @RequestBody Match match) {
        return matchService.updateMatch(matchId, match);
    }

    @DeleteMapping("{matchId}")
    public void deleteMatch(@PathVariable Integer matchId) {
        matchRepository.deleteById(matchId);
    }
}
