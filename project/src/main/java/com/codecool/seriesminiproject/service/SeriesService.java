package com.codecool.seriesminiproject.service;

import com.codecool.seriesminiproject.entity.Series;
import com.codecool.seriesminiproject.repository.SeriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

    public void addSeries(Series series) {
        seriesRepo.save(series);
    }


    public void deleteSeries(long id) {
        seriesRepo.deleteById(id);
    }
}
