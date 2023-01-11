package com.guciowons.footballguesser.footballers.external;

import com.guciowons.footballguesser.footballers.club.Club;
import com.guciowons.footballguesser.footballers.club.TeamConverter;
import com.guciowons.footballguesser.footballers.footballer.PlayerConverter;
import com.guciowons.footballguesser.footballers.league.CompetitionConverter;
import com.guciowons.footballguesser.footballers.league.League;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ExternalProvider {
    private final CompetitionConverter competitionConverter;
    private final TeamConverter teamConverter;
    private final PlayerConverter playerConverter;
    private final SquadClient squadClient;

    public ExternalProvider(CompetitionConverter competitionConverter, TeamConverter teamConverter, PlayerConverter playerConverter, SquadClient squadClient) {
        this.competitionConverter = competitionConverter;
        this.teamConverter = teamConverter;
        this.playerConverter = playerConverter;
        this.squadClient = squadClient;
    }

    public void getFootballers(List<String> leagues){
        AtomicInteger counter = new AtomicInteger(0);
        leagues.forEach(leagueCode ->{
            Teams teams = getTeamsFromLeague(counter, leagueCode);
            League league = competitionConverter.createLeague(teams.getCompetition());
            teams.getTeams().forEach(team -> getPlayersAndSave(counter, team, league));
        });
    }

    private Teams getTeamsFromLeague(AtomicInteger counter, String leagueCode){
        checkCounter(counter);
        return squadClient.getTeams("5740d267c15143f5b1ab75b03ffce4a3", leagueCode);
    }

    private void getPlayersAndSave(AtomicInteger counter, Teams.Team team, League league){
        checkCounter(counter);
        getPlayersFromTeam(team, league);
    }

    private void getPlayersFromTeam(Teams.Team team, League league) {
        Club club = teamConverter.createClub(team, league);
        squadClient.getSquad("5740d267c15143f5b1ab75b03ffce4a3", team.getId()).getSquad().stream()
                .filter(player -> player.getShirtNumber() != null && player.getPosition() != null)
                .forEach(player -> playerConverter.createFootballer(player, club));
    }

    private void checkCounter(AtomicInteger counter) {
        System.out.println(counter.get());
        if (counter.get() % 10 == 0 && counter.get() != 0) {
            try {
                TimeUnit.MINUTES.sleep(1);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        counter.incrementAndGet();
    }
}
