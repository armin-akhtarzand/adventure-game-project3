package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Goblin;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.view.UI;
public class DungeonRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        Goblin goblin = new Goblin.Builder()
                .name("Vätte")
                .health(20)
                .score(0)
                .strength(5)
                .build();
        if(player.hasDefeatedGoblin()) {
            ui.showMessage("Vätten är dräpt, fängelsehålan stor nu tom..");
            return;
        }
        ui.showMessage("Du går ner i en kall fängelsehåla. En vätte står i vägen!");
        while (player.isAlive() && goblin.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(goblin);
                ui.showMessage("Du attackerar vätten! Vättens HP: " + goblin.getHealth());
                if (goblin.isAlive()) {
                    goblin.attack(player);
                    ui.showMessage("Vätten attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade vätten!");
                    player.setDefeatedGoblin(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }

    }
}

