package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.entity.Club;
import com.guciowons.footballguesser.entity.League;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class FootballerRepository implements FootballerDao {
    @Override
    public List<Footballer> getFootballers() {
        return null;
    }

    @Override
    public List<Footballer> getFootballersByClub(Integer clubId) {
        return null;
    }

    @Override
    public List<Footballer> getFootballersByLeague(Integer leagueId) {
        return null;
    }

//    @Override
//    public List<Footballer> getFootballers(){
//        return footballers;
//    }
//
//    @Override
//    public List<Footballer> getFootballersByClub(Integer clubId){
//        return footballers.stream().filter(footballer -> footballer.getClub().getId().equals(clubId)).toList();
//    }
//
//    @Override
//    public List<Footballer> getFootballersByLeague(Integer leagueId) {
//        return footballers.stream().filter(footballer -> footballer.getClub().getLeague().getId().equals(leagueId)).toList();
//    }
}
