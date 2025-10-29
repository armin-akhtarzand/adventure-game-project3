package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.config.AppData;
import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.rooms.StartRoom;
import se.sprinto.hakan.adventuregame.model.Statistics;
import se.sprinto.hakan.adventuregame.service.StatisticsService;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

public class Main {

    public static void main(String[] args) {

        AppData appData = AppData.getInstance();
        UI ui = new ScannerUI();
        ui.showMessage("Välkommen till Äventyrsspelet!");
        ui.showMessage(
                "Utvecklare: " + appData.getAuthor()
                +"\nVersion: " + appData.getVersion() );
        String name = ui.getInput("Ange ditt namn:");
        Player player = new Player.Builder()
                .name(name)
                .health(100)
                .score(0)
                .strength(10)
                .build();

        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}

