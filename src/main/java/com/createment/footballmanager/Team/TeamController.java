package com.createment.footballmanager.Team;

import com.createment.footballmanager.Player.Player;
import com.createment.footballmanager.Player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public List<Team> showAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{teamId}")
    public Team showTeamById(@PathVariable Integer teamId) {
        return teamRepository.findById(teamId).orElseThrow();
    }

    @GetMapping("/{teamId}/players")
    public List<Player> showPlayersByTeamById(@PathVariable Integer teamId) {
        return playerRepository.findAllByTeamId(teamId);
    }
}
