package com.guciowons.footballguesser.footballers.league;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeagueRepository extends JpaRepository<League, Integer> {
    Optional<League> findByExternalId(Integer externalId);
}
