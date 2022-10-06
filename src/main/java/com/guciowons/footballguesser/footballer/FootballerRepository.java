package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.entity.Club;
import com.guciowons.footballguesser.entity.League;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class FootballerRepository implements FootballerDao {
    private List<League> leagues = Arrays.asList(
            new League("Bundesliga"),
            new League("Premier League"));

    private List<Club> clubs = Arrays.asList(
            new Club("Bayern Munchen", "BAY", leagues.get(0)),
            new Club("Borussia Dortmund", "BVB", leagues.get(0)),
            new Club("Manchester City", "MCI", leagues.get(1)));

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
    public List<Footballer> getFootballersByClub(String shortcut){
        return footballers.stream().filter(footballer -> footballer.getClub().getShortcut().equals(shortcut)).toList();
    }
}
