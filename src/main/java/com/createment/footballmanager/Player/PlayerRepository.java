package com.createment.footballmanager.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllByTeamId(Integer teamId);
    Optional<Player> findByImageName(String imageName);
}
