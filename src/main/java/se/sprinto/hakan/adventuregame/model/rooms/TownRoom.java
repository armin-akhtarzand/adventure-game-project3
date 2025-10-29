package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.MysteriousMan;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.view.UI;

public class TownRoom implements Room {

    private boolean walkAway;


    @Override
    public void enterRoom(Player player, UI ui) {


        if(player.hasInfoLastKeys() && !player.getDragonSlayed()){
            ui.showMessage("Du kliver in i staden, du ser inga människor på gatan. Värdshusen är tysta....");
            ui.showMessage("En drake har synts vid tornet!");
            return;
        }else if(player.hasInfoLastKeys() && player.getDragonSlayed()){
            ui.showMessage("Du kliver in i staden, folket och musiken i värdshusen är tillbaka!");
            ui.showMessage("Du har skyddat staden från draken! Du går självsäkert tillbaka till start rummet");
            return;
        }

        if(player.hasFoundFirstKey()&&player.hasDefeatedEnemy()) {
            ui.showMessage("Du kliver in i staden, en mystiskt man med luva går fram till dig");
            MysteriousMan npc = new MysteriousMan.Builder()
                    .name("Myserious Man")
                    .health(5)
                    .strength(10)
                    .build();
            ui.showMessage("Han har hört att du har hittat första nyckeln till skattkammaren" +
                    " samt dräpt vätten i fängelsehålan");
            ui.showMessage("Han har information gällande resterande nycklarna (2 till)");
            String choice = ui.getInput("Vill du veta informationen? (ja/nej)");
            if(choice.equals("ja")) {
                npc.setWalkAway(false);
                player.addScore(30);
            }
            else{
                npc.setWalkAway(true);
            }
            npc.interact(player);
        }else{
            ui.showMessage("Du kliver in i staden, du ser glada miner och hör musiken från stadens alla värdshus ");
            ui.showMessage("Inget är utöver det vanliga, du går tillbaka till start rummet");
        }
    }




}
