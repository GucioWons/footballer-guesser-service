package com.guciowons.footballguesser.users.score;

import com.guciowons.footballguesser.excepitons.scores.IncorrectTimeException;
import com.guciowons.footballguesser.excepitons.scores.IncorrectLeagueIdException;
import com.guciowons.footballguesser.excepitons.scores.IncorrectUserIdException;
import com.guciowons.footballguesser.footballers.league.LeagueService;
import com.guciowons.footballguesser.users.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public ScoreResponse createScore(Integer userId, Integer leagueId, Integer points) {
        return userService.getUserById(userId)
                        .map(user -> leagueService.getLeagueById(leagueId)
                                .map(league -> scoreRepository.save(new Score(user, league, points, LocalDateTime.now())))
                                    .map(score -> new ScoreResponse(score.getPoints(), score.getDateTime(), score.getUser().getId()))
                                        .orElseThrow(() -> new IncorrectUserIdException("There isn't any league with id = " + userId)))
                                .orElseThrow(() -> new IncorrectLeagueIdException("There isn't any user with id = " + leagueId));
    }

    public List<ScoreSummarized> getLeagueScoresWithTime(String time, Integer leagueId){
        if(time.equals("weekly")){
            return scoreSummarizer.summarizeScores(scoreRepository.findByDateTimeAfterAndLeague(LocalDateTime.now().minusWeeks(1),
                            leagueService.getLeagueById(leagueId).orElseThrow(
                                    () -> new IncorrectLeagueIdException("There isn't any league with id = " + leagueId))))
                    .stream().sorted(Comparator.comparingInt(ScoreSummarized::getScore).reversed()).toList();
        }else if(time.equals("monthly")){
            return scoreSummarizer.summarizeScores(scoreRepository.findByDateTimeAfterAndLeague(LocalDateTime.now().minusMonths(1),
                            leagueService.getLeagueById(leagueId).orElseThrow(
                                    () -> new IncorrectLeagueIdException("There isn't any league with id = " + leagueId))))
                    .stream().sorted(Comparator.comparingInt(ScoreSummarized::getScore).reversed()).toList();
        }else{
            throw new IncorrectTimeException("Incorrect time. Choose weekly, monthly or leave this field empty");
        }
    }

    public List<ScoreSummarized> getLeagueScoresWithoutTime(Integer leagueId){
        return scoreSummarizer.summarizeScores(scoreRepository.findByLeague(leagueService.getLeagueById(leagueId)
                        .orElseThrow(() -> new IncorrectLeagueIdException("There isn't any league with id = " + leagueId))))
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
            throw new IncorrectTimeException("Incorrect time. Choose weekly, monthly or leave this field empty");
        }
    }

    public List<ScoreSummarized> getScoresWithoutTime(){
        return scoreSummarizer.summarizeScores(scoreRepository.findAll())
                .stream().sorted(Comparator.comparingInt(ScoreSummarized::getScore).reversed()).toList();
    }
}
