package com.codecool.seriesminiproject.controller;

import com.codecool.seriesminiproject.entity.Season;
import com.codecool.seriesminiproject.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seasons")
public class SeasonController {

    @Autowired
    SeasonService seasonService;

    private static final String SUCCESSFULLY = "The action was successfully";

    @GetMapping("/")
    public List<Season> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    @GetMapping("/{id}")
    public Season getSeason(@PathVariable long id) {
        return seasonService.getSeasonsById(id);
    }

}
