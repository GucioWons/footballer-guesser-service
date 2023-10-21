package com.guciowons.footballguesser.score;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScoreSummarizer {
    public List<ScoreSummarized> summarizeScores(List<Score> scores){
        List<ScoreSummarized> scoresSummarized = new ArrayList<>();
        scores.forEach(score -> scoresSummarized.stream().filter(
                scoreSummarized -> scoreSummarized.getUsername().equals(score.getUser().getUsername())).findFirst()
                .ifPresentOrElse(
                scoreSummarized -> scoreSummarized.setScore(scoreSummarized.getScore() + score.getPoints()),
                () -> scoresSummarized.add(new ScoreSummarized(score.getUser().getUsername(), score.getPoints()))));
        return scoresSummarized;
    }
}
