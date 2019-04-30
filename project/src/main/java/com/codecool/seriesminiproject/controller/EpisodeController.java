package com.codecool.seriesminiproject.controller;

import com.codecool.seriesminiproject.entity.Episode;
import com.codecool.seriesminiproject.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    EpisodeService episodeService;

    private static final String SUCCESSFULLY = "The action was successfully";

    @GetMapping("/")
    public List<Episode> getAllEpisode() {
        return episodeService.getAllEpisode();
    }

    @GetMapping("/{id}")
    public Episode getEpisode(@PathVariable long id) {
        return episodeService.getEpisodeById(id);
    }

}
