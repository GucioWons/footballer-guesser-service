package com.guciowons.footballguesser.Users.Score;

import com.guciowons.footballguesser.Footballers.League.LeagueService;
import com.guciowons.footballguesser.Users.UserService;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserService userService;
    private final LeagueService leagueService;

    public ScoreService(ScoreRepository scoreRepository, UserService userService, LeagueService leagueService) {
        this.scoreRepository = scoreRepository;
        this.userService = userService;
        this.leagueService = leagueService;
    }

    public Score createScore(Integer userId, Integer leagueId, Long points) {
        return userService.getUserById(userId)
                        .map(user -> leagueService.getLeagueById(leagueId)
                                .map(league -> scoreRepository.save(new Score(user, league, points)))
                                        .orElseThrow(() -> new IllegalArgumentException("No user")))
                                .orElseThrow(() -> new IllegalArgumentException("No league"));
    }

    public Score addPoints(Integer userId, Integer leagueId, Long points) {
        return scoreRepository.findByUserIdAndLeagueId(userId, leagueId)
                .map(score -> {
                    score.setPoints(score.getPoints()+points);
                    return scoreRepository.save(score);
                }).orElseThrow(() -> new IllegalArgumentException("No score"));
    }
}
