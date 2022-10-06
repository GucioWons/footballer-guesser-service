package com.guciowons.footballguesser.footballer;

import com.guciowons.footballguesser.footballer.Footballer;

import java.util.List;

public interface FootballerDao {
    List<Footballer> getFootballers();

    List<Footballer> getFootballersByClub(String club);
}
