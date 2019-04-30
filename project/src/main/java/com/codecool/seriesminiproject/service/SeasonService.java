package com.codecool.seriesminiproject.service;

import com.codecool.seriesminiproject.entity.Season;
import com.codecool.seriesminiproject.repository.SeasonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepo;


    public List<Season> getAllSeasons() {
        return seasonRepo.findAll();
    }

    public Season getSeasonsById(long id) {
        for (Season season : seasonRepo.findAll()) {
            if (season.getId().equals(id)) {
                return season;
            }
        }
        return null;
    }

    public void addSeason(Season season) {
        seasonRepo.save(season);
    }

    public void deleteSeasonById(long id) {
        seasonRepo.deleteById(id);
    }
}
