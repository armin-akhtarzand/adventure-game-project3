package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.view.UI;

public class StartRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du befinner dig i start-rummet. Du ser fyra dörrar framför dig.");
        boolean exit = false;
        while (!exit) {
            String choice;
            if(!player.hasInfoLastKeys()) {
                choice = ui.getInput("Vilken dörr vill du ta? (1.Skog, 2.Fängelse, 3.Skattkammare,4.Staden q.avsluta)");
            }else{
                choice = ui.getInput("Vilken dörr vill du ta? (1.Skog, 2.Fängelse, 3.Skattkammare," +
                        "4.Staden, 5.Sjön, 6.Tornet q.avsluta)");
            }
            switch (choice) {
                case "1":
                    if (!player.hasFoundFirstKey()) {
                        new ForestRoom().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan hittat och plockat upp nyckeln.");
                    }

                    break;
                case "2":
                    new DungeonRoom().enterRoom(player, ui);
                    break;
                case "3":
                    if (!player.hasOpenedChest()) {
                        new TreasureRoom().enterRoom(player, ui);
                    } else {
                        System.out.println("Du har redan hittat och öppnat kistan");
                    }
                    break;

                case "4":
                    new TownRoom().enterRoom(player, ui);
                    break;

                case "5":
                    if(player.hasInfoLastKeys()) {
                        new LakeRoom().enterRoom(player, ui);
                    }else{
                        ui.showMessage("Ogiltigt val");
                    }
                    break;
                case "6":
                    if(player.hasInfoLastKeys()) {
                        new TowerRoom().enterRoom(player, ui);
                    }else{
                        ui.showMessage("Ogiltigt val");
                    }
                    break;

                case "q":
                    exit = true;
                    break;
                default:
                    ui.showMessage("Ogiltigt val.");
            }
            if (player.hasWon()) {
                ui.showMessage("Grattis! Du har klarat spelet!");
                exit = true;
            } else if (player.getHealth() <= 0) {
                ui.showMessage(("Din hälsa är kritisk, du vacklar till och dör!"));
                exit = true;
            }
        }
    }
}

