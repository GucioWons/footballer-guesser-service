package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.entity.Club;
import com.guciowons.footballguesser.entity.League;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class FootballerRepository implements FootballerDao {
    private List<League> leagues = Arrays.asList(
            new League(1, "Bundesliga"),
            new League(2, "Premier League"));

    private List<Club> clubs = Arrays.asList(
            new Club(1, "Bayern Munchen", "BAY", leagues.get(0)),
            new Club(2, "Borussia Dortmund", "BVB", leagues.get(0)),
            new Club(3, "Manchester City", "MCI", leagues.get(1)));

    private List<Footballer> footballers = Arrays.asList(
            new Footballer(1, "Mannuel", "Neuer", "Germany", clubs.get(0), 1, Position.GK),
            new Footballer(2, "Joshua", "Kimmich", "Germany", clubs.get(0), 6, Position.MF),
            new Footballer(3, "Leroy", "Sane", "Germany", clubs.get(0), 10, Position.ST),
            new Footballer(4, "Marco", "Reus", "Germany", clubs.get(1), 11, Position.ST),
            new Footballer(5, "Erling", "Haaland", "Norway", clubs.get(2), 9, Position.ST)
    );

    @Override
    public List<Footballer> getFootballers(){
        return footballers;
    }

    @Override
    public List<Footballer> getFootballersByClub(Integer clubId){
        return footballers.stream().filter(footballer -> footballer.getClub().getId().equals(clubId)).toList();
    }

    @Override
    public List<Footballer> getFootballersByLeague(Integer leagueId) {
        return footballers.stream().filter(footballer -> footballer.getClub().getLeague().getId().equals(leagueId)).toList();
    }
}
