package com.createment.footballmanager.Team;

import com.createment.footballmanager.Player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team updateTeam(Integer teamId, Team updatedTeam) {
        Optional<Team> existingTeamOptional = teamRepository.findById(teamId);

        if (existingTeamOptional.isPresent()) {
            Team existingTeam = existingTeamOptional.get();

            // Update specific fields from the request, if provided
            if (updatedTeam.getName() != null) {
                existingTeam.setName(updatedTeam.getName());
            }
            if (updatedTeam.getCountry() != null) {
                existingTeam.setCountry(updatedTeam.getCountry());
            }
            if (updatedTeam.getDescription() != null) {
                existingTeam.setDescription(updatedTeam.getDescription());
            }
            if (updatedTeam.getLeague() != null) {
                existingTeam.setLeague(updatedTeam.getLeague());
            }
            if (updatedTeam.getCity() !=null){
                existingTeam.setCity(updatedTeam.getCity());
            }

            // Save the updated team
            return teamRepository.save(existingTeam);

        }
        return null;


        }
    }


