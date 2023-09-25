package com.createment.footballmanager.Player;

import com.createment.footballmanager.Team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerRepository playerRepository, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }

//    @GetMapping
//    public List<Player> showAllPlayers() {
//        return playerRepository.findAll();
//    }

    @GetMapping("/{playerId}")
    public Player showPlayerById(@PathVariable Integer playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new PlayerNotFoundException(String.format("No player with id %s is available", playerId)));
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping("{playerId}")
    public ResponseEntity updatePlayer(@PathVariable Integer playerId, @RequestBody Player player) {
        return playerService.updatePlayer(playerId, player);
    }

    @DeleteMapping("{playerId}")
    public void deletePlayer(@PathVariable Integer playerId) {
        playerRepository.deleteById(playerId);
    }

    @GetMapping("")
    public List<Player> filterPlayers(
            @RequestParam(name = "name", required = false) String nameFilter,
            @RequestParam(name = "team", required = false) String teamFilter
    ){

        List<Player> filteredPlayers = playerRepository.findAll().stream()
                .filter(player -> nameFilter == null || player.getName().contains(nameFilter))
                .filter(player -> teamFilter == null || player.getTeamName().contains(teamFilter))
                .collect(Collectors.toList());

        return filteredPlayers;
    };
}
