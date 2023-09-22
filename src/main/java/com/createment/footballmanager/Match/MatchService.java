package com.createment.footballmanager.Match;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public ResponseEntity updateMatch(Integer matchId, Match updatedMatch) {
        return matchRepository.findById(matchId)
                .map(existingMatch -> {
                    Arrays.asList("name", "startTime", "homeTeam", "awayTeam", "homeScore", "awayScore")
                            .forEach(field -> {
                                Object updatedValue = getFieldValue(updatedMatch, field);
                                if (updatedValue != null) {
                                    setFieldValue(existingMatch, field, updatedValue);
                                }
                            });
                    return new ResponseEntity<>(matchRepository.save(existingMatch), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private Object getFieldValue(Match match, String fieldName) {
        try {
            Field field = Match.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(match);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }

    private void setFieldValue(Match match, String fieldName, Object value) {
        try {
            Field field = Match.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(match, value);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
    }
}
