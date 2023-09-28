package com.createment.footballmanager.Team;

import com.createment.footballmanager.Enumerations.Country;
import com.createment.footballmanager.Player.Player;
import com.createment.footballmanager.Player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamRepository teamRepository, PlayerRepository playerRepository, TeamService teamService) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.teamService = teamService;
    }

    @GetMapping("/{teamId}")
    public Team showTeamById(@PathVariable Integer teamId) {
        return teamRepository.findById(teamId).orElseThrow();
    }

    @GetMapping("/{teamId}/players")
    public List<Player> showPlayersByTeamById(@PathVariable Integer teamId) {
        return playerRepository.findAllByTeamId(teamId);
    }

    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @PutMapping("update-team/{teamId}")
    public ResponseEntity<Team> updateTeam(@PathVariable Integer teamId, @RequestBody Team updatedTeam) {
        Team updatedTeamResult = teamService.updateTeam(teamId, updatedTeam);
        return new ResponseEntity<>(updatedTeamResult, HttpStatus.OK);
    }

    @DeleteMapping("{teamId}")
    public void deleteTeam(@PathVariable Integer teamId){
        teamRepository.deleteById(teamId);
    }

    @GetMapping("")
    public List<Team> filterTeams(
            @RequestParam(name = "name", required = false) String nameFilter,
            @RequestParam(name = "country", required = false) String countryFilter
    ){

        List<Team> filteredTeams = teamRepository.findAll().stream()
                .filter(team -> nameFilter == null || team.getName().contains(nameFilter))
//                .filter(team -> countryFilter == null || team.getCountry().name().toLowerCase().contains(countryFilter.toLowerCase()))
                .filter(team -> countryFilter == null || team.getCountry() == Country.valueOf(countryFilter.toUpperCase()))
                .collect(Collectors.toList());

        return filteredTeams;
    };
}

