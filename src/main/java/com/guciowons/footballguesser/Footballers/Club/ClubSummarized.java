package com.guciowons.footballguesser.Footballers.Club;

import com.guciowons.footballguesser.Footballers.Footballer.Footballer;
import com.guciowons.footballguesser.Footballers.Footballer.FootballerSummarized;

import java.util.List;

public class ClubSummarized {
    private String name;
    private String shortcut;
    private String url;
    private List<FootballerSummarized> footballers;

    public ClubSummarized(String name, String shortcut, String url, List<FootballerSummarized> footballers) {
        this.name = name;
        this.shortcut = shortcut;
        this.url = url;
        this.footballers = footballers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<FootballerSummarized> getFootballers() {
        return footballers;
    }

    public void setFootballers(List<FootballerSummarized> footballers) {
        this.footballers = footballers;
    }
}
