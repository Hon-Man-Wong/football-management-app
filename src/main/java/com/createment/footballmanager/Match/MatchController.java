package com.createment.footballmanager.Match;

import com.createment.footballmanager.Player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

//    @GetMapping
//    public List<Match> showAllMatches() {
//        return matchRepository.findAll();
//    }

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

    @GetMapping("")
    public List<Match> filterPlayers(
            @RequestParam(name = "homeTeam", required = false) String homeTeamNameFilter,
            @RequestParam(name = "awayTeam", required = false) String awayTeamNameFilter
    ){

        List<Match> filteredTeamMatches = matchRepository.findAll().stream()
                .filter(player -> homeTeamNameFilter == null || player.getHomeTeam().getName().toLowerCase().contains(homeTeamNameFilter.toLowerCase()))
                .filter(player -> awayTeamNameFilter == null || player.getAwayTeam().getName().toLowerCase().contains(awayTeamNameFilter.toLowerCase()))
                .collect(Collectors.toList());

        return filteredTeamMatches;
    };
}
