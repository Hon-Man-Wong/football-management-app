package com.createment.footballmanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
//    List<Player> findAllById(Team team);

    List<Player> findAllByTeamId(Integer teamId);
}
