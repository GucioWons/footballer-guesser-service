package com.guciowons.footballguesser.Users.Score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    Optional<Score> findByUserIdAndLeagueId(Integer userId, Integer leagueId);
}
