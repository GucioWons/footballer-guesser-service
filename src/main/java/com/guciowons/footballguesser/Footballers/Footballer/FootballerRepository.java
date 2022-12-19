package com.guciowons.footballguesser.Footballers.Footballer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FootballerRepository extends JpaRepository<Footballer, Integer> {
    List<Footballer> findAllByClubId(Integer clubId);
    List<Footballer> findAllByClubLeagueId(Integer leagueId);
    Optional<Footballer> findByExternalId(Integer externalId);
}
