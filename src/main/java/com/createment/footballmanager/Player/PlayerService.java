package com.createment.footballmanager.Player;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    private final String FOLDER_PATH = "/football-management-app/src/main/java/com/createment/footballmanager/Assets/";

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);
        return age.getYears();
    }

    public ResponseEntity updatePlayer(Integer playerId, Player updatedPlayer) {
        return playerRepository.findById(playerId)
                .map(existingPlayer -> {
                    Arrays.asList("name", "team", "position", "dateOfBirth", "city", "country", "shirtNumber")
                            .forEach(field -> {
                                Object updatedValue = getFieldValue(updatedPlayer, field);
                                if (updatedValue != null) {
                                    setFieldValue(existingPlayer, field, updatedValue);
                                }
                            });
                    return new ResponseEntity<>(playerRepository.save(existingPlayer), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private Object getFieldValue(Player player, String fieldName) {
        try {
            Field field = Player.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(player);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }

    private void setFieldValue(Player player, String fieldName, Object value) {
        try {
            Field field = Player.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(player, value);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException{

        String imagePath = FOLDER_PATH + file.getOriginalFilename();

        Player player = playerRepository.save(Player.builder()
                .imageName(file.getOriginalFilename())
                .imageType(file.getContentType())
                .imagePath(imagePath).build());

        file.transferTo( new File(imagePath));

        if (player != null){
            return "file uploaded succesfully: " + imagePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String imageName) throws IOException {
        Optional<Player> imageData = playerRepository.findByImageName(imageName);
        String imagePath = imageData.get().getImagePath();
        byte[] images = Files.readAllBytes(new File(imagePath).toPath());
        return images;
    }
}
