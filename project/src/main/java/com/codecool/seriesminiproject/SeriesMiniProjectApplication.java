package com.codecool.seriesminiproject;

import com.codecool.seriesminiproject.entity.Episode;
import com.codecool.seriesminiproject.entity.Season;
import com.codecool.seriesminiproject.entity.Series;
import com.codecool.seriesminiproject.repository.EpisodeRepository;
import com.codecool.seriesminiproject.repository.SeasonRepository;
import com.codecool.seriesminiproject.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class SeriesMiniProjectApplication {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeriesRepository seriesRepository;


    public static void main(String[] args) {
        SpringApplication.run(SeriesMiniProjectApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {

            Episode firstEpisode = Episode.builder()
                    .title("The Party of the Century")
                    .releaseDate(LocalDate.of(2015, 6, 23))
                    .build();
            Episode secondEpisode = Episode.builder()
                    .title("Tubman")
                    .releaseDate(LocalDate.of(2016, 6, 15))
                    .build();
            Episode thirdEpisode = Episode.builder()
                    .title("Congress")
                    .releaseDate(LocalDate.of(2018, 1, 23))
                    .build();

            Season firstSeason = Season.builder()
                    .episodeNum(10)
                    .releaseDate(LocalDate.of(2015, 6, 23))
                    .episode(firstEpisode)
                    .build();
            Season secondSeason = Season.builder()
                    .episodeNum(11)
                    .releaseDate(LocalDate.of(2016, 6, 15))
                    .episode(secondEpisode)
                    .build();
            Season thirdSeason = Season.builder()
                    .episodeNum(11)
                    .releaseDate(LocalDate.of(2018, 1, 23))
                    .episode(thirdEpisode)
                    .build();

            Series anotherPeriod = Series.builder()
                    .name("Another Period")
                    .seasons(Arrays.asList(firstSeason, secondSeason, thirdSeason))
                    .releaseDate(LocalDate.of(2015, 6, 23))
                    .build();


            firstEpisode.setSeason(firstSeason);
            firstSeason.setSeries(anotherPeriod);
            secondEpisode.setSeason(secondSeason);
            secondSeason.setSeries(anotherPeriod);
            thirdEpisode.setSeason(thirdSeason);
            thirdSeason.setSeries(anotherPeriod);
            seriesRepository.save(anotherPeriod);


        };
    }

}
