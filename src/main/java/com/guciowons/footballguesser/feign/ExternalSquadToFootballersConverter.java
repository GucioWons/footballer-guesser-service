package com.guciowons.footballguesser.feign;

import com.guciowons.footballguesser.entity.Club;
import com.guciowons.footballguesser.entity.League;
import com.guciowons.footballguesser.footballer.Footballer;
import com.guciowons.footballguesser.footballer.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExternalSquadToFootballersConverter {
    public List<Footballer> convertExternalSquadToFootballers(ExternalSquad externalSquad){
        Club club = new Club(externalSquad.getId(), externalSquad.getName(), externalSquad.getTla(),
                new League(1, "Premier League"));
        return externalSquad.getSquad().stream()
                .filter(externalPlayer -> externalPlayer.getShirtNumber() != null)
                .map(externalPlayer -> convertPlayerToFootballer(externalPlayer, club))
                .toList();

    }

    private Footballer convertPlayerToFootballer(ExternalSquad.ExternalPlayer externalPlayer, Club club){
        return new Footballer(externalPlayer.getId(),
                externalPlayer.getName(), externalPlayer.getNationality(),
                club, externalPlayer.getShirtNumber(),
                getPosition(externalPlayer.getPosition()));
    }

    private Position getPosition(String position){
        if(position.contains("Back")){
            return Position.DF;
        }else if(position.contains("Midfield")){
            return Position.MF;
        }else if(position.contains("Goalkeeper")){
            return Position.GK;
        }else{
            return Position.ST;
        }
    }
}
