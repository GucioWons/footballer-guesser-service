package com.guciowons.footballguesser.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Game findByPlayerIdAndLeagueId(Integer playerId, Integer leagueId);
}
