package se.sprinto.hakan.adventuregame.dao;

import se.sprinto.hakan.adventuregame.model.Statistics;
import se.sprinto.hakan.adventuregame.service.StatisticsService;

import java.util.ArrayList;
import java.util.List;


public class FakeFileStatisticsDao implements StatisticsDao {


    @Override
    public void save(Statistics stat) {

    }

    @Override
    public List<Statistics> loadAll() {

        return new ArrayList<>(List.of(
                new Statistics("Jörgen",130),
                new Statistics("Stolpe",90),
                new Statistics("Ragnar",100),
                new Statistics("Folke",170)));
    }
}