package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.footballer.Footballer;
import com.guciowons.footballguesser.footballer.FootballerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballerService {
    private final FootballerRepository footballerRepository;

    public FootballerService(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    public List<Footballer> getFootballersByClub(String club) {
        return footballerRepository.getFootballersByClub(club);
    }

    public List<Footballer> getFotballers() {
        return footballerRepository.getFootballers();
    }
}
