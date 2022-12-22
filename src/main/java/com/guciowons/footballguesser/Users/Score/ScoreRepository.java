package com.guciowons.footballguesser.Users.Score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    Optional<Score> findByUserIdAndLeagueId(Integer userId, Integer leagueId);

    List<Score> findByDateTimeAfter(LocalDateTime dateTime);

    List<Score> findByDateTimeAfterAndLeague_Id(LocalDateTime dateTime, Integer leagueId);

    List<Score> findByLeague_Id(Integer leagueId);
}
