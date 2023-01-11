package com.guciowons.footballguesser.footballers.footballer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FootballerRepository extends JpaRepository<Footballer, Integer> {
    List<Footballer> findAllByClubId(Integer clubId);
    Optional<Footballer> findByExternalId(Integer externalId);
}
