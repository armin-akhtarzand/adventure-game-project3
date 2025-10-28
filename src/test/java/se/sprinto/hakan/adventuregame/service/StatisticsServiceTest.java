package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.dao.FakeFileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StatisticsServiceTest {

    StatisticsService service;
    StatisticsDao dao;






    @BeforeEach
    void setUp() {

        dao = new FakeFileStatisticsDao();
        service = new StatisticsService(dao);

    }


    @Test
    void statisticsSortedInPointsOrder() {
        List<Statistics> list = service.getSortedStatistics();
        int index0 = 0;
        int index1 = 0;

        for(int i = 0; i<list.size()-1;i++){
             index0 = list.get(i).getScore();
             index1 = list.get(i+1).getScore();

            //System.out.println(previous+","+current);

            assertTrue(index0 > index1);
        }


        }




}