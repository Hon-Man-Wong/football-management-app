package com.createment.footballmanager.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
                .filter(player -> nameFilter == null || player.getName().toLowerCase().contains(nameFilter.toLowerCase()))
                .filter(player -> teamFilter == null || player.getTeamName().toLowerCase().contains(teamFilter.toLowerCase()))
                .collect(Collectors.toList());

        return filteredPlayers;
    };

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = playerService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/fileSystem/{imageName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String imageName) throws IOException {
        byte[] imageData = playerService.downloadImageFromFileSystem(imageName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
