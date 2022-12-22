package com.guciowons.footballguesser.Users.Score;

import com.guciowons.footballguesser.Footballers.League.LeagueService;
import com.guciowons.footballguesser.Users.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserService userService;
    private final LeagueService leagueService;
    private final ScoreSummarizer scoreSummarizer;

    public ScoreService(ScoreRepository scoreRepository, UserService userService, LeagueService leagueService, ScoreSummarizer scoreSummarizer) {
        this.scoreRepository = scoreRepository;
        this.userService = userService;
        this.leagueService = leagueService;
        this.scoreSummarizer = scoreSummarizer;
    }

    public Score createScore(Integer userId, Integer leagueId, Integer points) {
        return userService.getUserById(userId)
                        .map(user -> leagueService.getLeagueById(leagueId)
                                .map(league -> scoreRepository.save(new Score(user, league, points, LocalDateTime.now())))
                                        .orElseThrow(() -> new IllegalArgumentException("No user")))
                                .orElseThrow(() -> new IllegalArgumentException("No league"));
    }

    public List<ScoreSummarized> getLeagueScoresWithTime(String time, Integer leagueId){
        if(time.equals("weekly")){
            return scoreSummarizer.summarizeScores(scoreRepository.findByDateTimeAfterAndLeague_Id(LocalDateTime.now().minusWeeks(1), leagueId))
                    .stream().sorted(Comparator.comparingInt(ScoreSummarized::getScore).reversed()).toList();
        }else if(time.equals("monthly")){
            return scoreSummarizer.summarizeScores(scoreRepository.findByDateTimeAfterAndLeague_Id(LocalDateTime.now().minusMonths(1), leagueId))
                    .stream().sorted(Comparator.comparingInt(ScoreSummarized::getScore).reversed()).toList();
        }else{
            throw new IllegalArgumentException();
        }
    }

    public List<ScoreSummarized> getLeagueScoresWithoutTime(Integer leagueId){
        return scoreSummarizer.summarizeScores(scoreRepository.findByLeague_Id(leagueId))
                .stream().sorted(Comparator.comparingInt(ScoreSummarized::getScore).reversed()).toList();
    }

    public List<ScoreSummarized> getScoresWithTime(String time){
        if(time.equals("weekly")){
            return scoreSummarizer.summarizeScores(scoreRepository.findByDateTimeAfter(LocalDateTime.now().minusWeeks(1)))
                    .stream().sorted(Comparator.comparingInt(ScoreSummarized::getScore).reversed()).toList();
        }else if(time.equals("monthly")){
            return scoreSummarizer.summarizeScores(scoreRepository.findByDateTimeAfter(LocalDateTime.now().minusMonths(1)))
                    .stream().sorted(Comparator.comparingInt(ScoreSummarized::getScore).reversed()).toList();
        }else{
            throw new IllegalArgumentException();
        }
    }

    public List<ScoreSummarized> getScoresWithoutTime(){
        return scoreSummarizer.summarizeScores(scoreRepository.findAll())
                .stream().sorted(Comparator.comparingInt(ScoreSummarized::getScore).reversed()).toList();
    }
}
