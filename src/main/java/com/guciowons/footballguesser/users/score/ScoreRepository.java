package com.guciowons.footballguesser.users.score;

import com.guciowons.footballguesser.footballers.league.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    List<Score> findByDateTimeAfter(LocalDateTime dateTime);

    List<Score> findByDateTimeAfterAndLeague(LocalDateTime dateTime, League league);

    List<Score> findByLeague(League league);
}
