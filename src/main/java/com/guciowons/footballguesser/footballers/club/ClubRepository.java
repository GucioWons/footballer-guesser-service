package com.guciowons.footballguesser.footballers.club;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Integer> {
    List<Club> findAllByLeagueId (Integer league_id);
    Optional<Club> findByExternalId(Integer externalId);
}
