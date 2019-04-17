package com.codecool.seriesminiproject.service;

import com.codecool.seriesminiproject.entity.Series;
import com.codecool.seriesminiproject.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepo;

    public List<Series> getAllSeries() {
        return seriesRepo.findAll();
    }

    public Series getSeriesById(long id) {
        for (Series series : seriesRepo.findAll()) {
            if (series.getId().equals(id)) return series;
        }
        return null;
    }


}
