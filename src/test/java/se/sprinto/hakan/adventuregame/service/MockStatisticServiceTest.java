package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class MockStatisticServiceTest {
    @Mock
    FileStatisticsDao fileDao;

    @InjectMocks
    StatisticsService service;

    List<Statistics> mockList;



    @BeforeEach
    public void setup() {
       mockList = new ArrayList<>(List.of(
                new Statistics("Felix",150),
                new Statistics("Anna",200),
                new Statistics("Pelle",140),
                new Statistics("Lars",180)));

        Mockito.when(fileDao.loadAll()).thenReturn(mockList);
    }

    @Test
    public void sortStatistics() {
        List<Statistics> list = service.getSortedStatistics();
        int scoreNow = 0;
        int scoreNext = 0;

        for(int i = 1; i< list.size()-1; i++){
            scoreNow = list.get(i).getScore();
            scoreNext = list.get(i+1).getScore();

            assertTrue(scoreNow > scoreNext);
        }
    }
}
