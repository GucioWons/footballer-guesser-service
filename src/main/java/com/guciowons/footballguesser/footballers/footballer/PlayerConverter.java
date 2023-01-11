package com.guciowons.footballguesser.footballers.footballer;

import com.guciowons.footballguesser.footballers.club.Club;
import com.guciowons.footballguesser.footballers.external.Squad;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {
    private final FootballerRepository footballerRepository;

    public PlayerConverter(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    public void createFootballer(Squad.Player player, Club club){
        footballerRepository.save(footballerRepository.findByExternalId(player.getId()).map(
                        footballer ->updateFootballer(footballer, player, club))
                .orElse(convertPlayerToFootballer(player, club)));
    }

    public Footballer convertPlayerToFootballer(Squad.Player player, Club club) {
        return new Footballer(player.getId(), player.getName(), player.getNationality(), club, player.getShirtNumber(), getPosition(player.getPosition()));
    }

    public Footballer updateFootballer(Footballer footballer, Squad.Player player, Club club) {
        Footballer updatedFootballer = new Footballer(player.getId(), player.getName(), player.getNationality(), club, player.getShirtNumber(), getPosition(player.getPosition()));
        updatedFootballer.setId(footballer.getId());
        return updatedFootballer;
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
