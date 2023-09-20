package com.createment.footballmanager;

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

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public List<Team> showAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{teamId}")
    public Team showTeamById(@PathVariable Integer teamId) {
        return teamRepository.findById(teamId).orElseThrow();
    }
}
