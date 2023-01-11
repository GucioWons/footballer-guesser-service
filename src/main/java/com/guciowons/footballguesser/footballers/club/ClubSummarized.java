package com.guciowons.footballguesser.footballers.club;

import com.guciowons.footballguesser.footballers.footballer.FootballerSummarized;

import java.util.List;

public class ClubSummarized {
    private final String name;
    private final String shortcut;
    private final String url;
    private final List<FootballerSummarized> footballers;

    public ClubSummarized(String name, String shortcut, String url, List<FootballerSummarized> footballers) {
        this.name = name;
        this.shortcut = shortcut;
        this.url = url;
        this.footballers = footballers;
    }

    public String getName() {
        return name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getUrl() {
        return url;
    }

    public List<FootballerSummarized> getFootballers() {
        return footballers;
    }
}
