package com.codecool.seriesminiproject.service;

import com.codecool.seriesminiproject.entity.Episode;
import com.codecool.seriesminiproject.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepo;

    public List<Episode> getAllEpisode() {
        return episodeRepo.findAll();
    }

    public Episode getEpisodeById(long id) {
        for (Episode episode : episodeRepo.findAll()) {
            if (episode.getId().equals(id)) {
                return episode;
            }
        }
        return null;
    }
}
