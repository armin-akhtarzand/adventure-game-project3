package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Dragon;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

public class TowerRoom implements Room {

    UI ui = new ScannerUI();


    @Override
    public void enterRoom(Player player, UI ui) {

        if(player.getDragonSlayed()){
            ui.showMessage("Tornet brinner inte längre, du ser drakens kvarlevor framför dig..");
            ui.showMessage("Du går tillbaka till startrummet");
            return;
        }



        ui.showMessage("Du kommer till ett brinnande torn, på toppen utav tornet sitter en drake och vaktar!");
        Dragon dragon = new Dragon.Builder()
                .health(110)
                .strength(15)
                .build();


        if (!player.hasNewArmor()) {
            ui.showMessage("OBS: Din rustning är inte flamsäker! Drakens eld gör extra skada!\n");

        }else{
            ui.showMessage("Du känner ingen hetta från drakens eld," +
                    " din nya rustning ger dig ett brinnande självförtroende\n");
        }
        dragon.interact(player,ui);

    }
}
