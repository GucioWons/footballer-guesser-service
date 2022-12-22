package com.guciowons.footballguesser.Footballers.Footballer;

import com.guciowons.footballguesser.Footballers.Club.ClubRepository;
import com.guciowons.footballguesser.Footballers.Club.ClubSummarized;
import com.guciowons.footballguesser.Footballers.External.ExternalProvider;
import com.guciowons.footballguesser.Footballers.League.LeagueRepository;
import com.guciowons.footballguesser.Footballers.League.LeagueSummarized;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;
    private final ClubRepository clubRepository;
    private final ExternalProvider externalProvider;

    public FootballerService(FootballerRepository footballerRepository, ClubRepository clubRepository, ExternalProvider externalProvider) {
        this.footballerRepository = footballerRepository;
        this.clubRepository = clubRepository;
        this.externalProvider = externalProvider;
    }


//    @PostConstruct
//    public void getFootballersFromExternalApi(){
//        externalProvider.getFootballers(Arrays.asList("BL1", "PL", "PD", "FL1", "SA"));
//    }

    public List<Footballer> getFootballers(){
        return footballerRepository.findAll();
    }

    public List<Footballer> getFootballersByClub(Integer clubId) {
        return footballerRepository.findAllByClubId(clubId);
    }

    public LeagueSummarized getFootballersByLeague(Integer leagueId) {
        List<ClubSummarized> clubs = clubRepository.findAllByLeagueId(leagueId)
                .stream().map(club ->
                    new ClubSummarized(club.getName(), club.getShortcut(), club.getUrl(), footballerRepository.findAllByClubId(club.getId())
                            .stream().map(footballer -> new FootballerSummarized(footballer.getName(), footballer.getNationality(), footballer.getNumber(), footballer.getPosition()))
                            .toList()))
                .toList();
        return new LeagueSummarized(clubs);
    }
}
