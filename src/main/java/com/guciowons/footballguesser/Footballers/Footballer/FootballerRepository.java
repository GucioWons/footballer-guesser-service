package com.guciowons.footballguesser.Footballers.Footballer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FootballerRepository extends JpaRepository<Footballer, Integer> {
    List<Footballer> findAllByClubId(Integer clubId);
    List<Footballer> findAllByClubLeagueId(Integer leagueId);
}
