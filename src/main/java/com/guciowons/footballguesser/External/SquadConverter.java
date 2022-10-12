package com.guciowons.footballguesser.External;

import com.guciowons.footballguesser.Club.Club;
import com.guciowons.footballguesser.footballer.Footballer;
import com.guciowons.footballguesser.footballer.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SquadConverter {

    public List<Footballer> convertSquadToFootballers(Squad squad, Club club){
        return squad.getSquad().stream()
                .filter(player -> player.getShirtNumber() != null && player.getPosition() != null)
                .map(player -> convertPlayerToFootballer(player, club))
                .toList();
    }

    private Footballer convertPlayerToFootballer(Squad.Player player, Club club){
        return new Footballer(player.getId(),
                player.getName(), player.getNationality(),
                club, player.getShirtNumber(),
                getPosition(player.getPosition()));
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
