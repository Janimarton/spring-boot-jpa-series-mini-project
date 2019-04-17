package com.codecool.seriesminiproject.controller;

import com.codecool.seriesminiproject.entity.Series;
import com.codecool.seriesminiproject.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @GetMapping("/get-all-series")
    public List<Series> getAllSeries() {
        return seriesService.getAllSeries();
    }

    @GetMapping("/get-series/{id}")
    public Series getSeries(@PathVariable long id){
        return seriesService.getSeriesById(id);
    }


}
