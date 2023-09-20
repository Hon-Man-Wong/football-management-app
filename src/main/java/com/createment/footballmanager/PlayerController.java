package com.createment.footballmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public List<Player> showAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/{playerId}")
    public Player showPlayerById(@PathVariable Integer playerId) {
        return playerRepository.findById(playerId).orElseThrow();
    }
}
