package com.codecool.seriesminiproject.controller;

import com.codecool.seriesminiproject.entity.Series;
import com.codecool.seriesminiproject.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    private static final String SUCCESSFULLY = "The action was successfully";

    @GetMapping("/")
    public List<Series> getAllSeries() {
        return seriesService.getAllSeries();
    }

    @GetMapping("/{id}")
    public Series getSeries(@PathVariable long id) {
        return seriesService.getSeriesById(id);
    }

    @PostMapping("/add")
    public String addSeries(@RequestBody Series series) {
        seriesService.addSeries(series);
        return SUCCESSFULLY;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSeries(@PathVariable long id) {
        seriesService.deleteSeries(id);
        return SUCCESSFULLY;
    }


}
