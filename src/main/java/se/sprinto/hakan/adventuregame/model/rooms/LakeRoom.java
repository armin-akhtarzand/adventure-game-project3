package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Mermaid;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.view.UI;

public class LakeRoom implements Room {


    @Override
    public void enterRoom(Player player, UI ui) {

        if(player.hasFoundSecondKey()){
            ui.showMessage("Du ser sjön framför dig, sjöjungfrun är borta.");
            ui.showMessage("Du greppar tag i nyckeln hon gav dig och går tillbaka till startrummet");
            return;
        }


        if(!player.getDragonSlayed()) {
            ui.showMessage("Du ser en stor sjö framför dig, en sjöjunfru simmar mot dig med fullt fart!");
            Mermaid mermaid = new Mermaid.Builder()
                    .health(20)
                    .strength(10)
                    .build();
            ui.showMessage("Hon binder din kropp inom en vattenbubbla, du är fast!");

            mermaid.interact(player);
        }else{
            ui.showMessage("Du ser en stor sjö framför dig, en sjöjungfru simmar mot dig med full fart!");
            ui.showMessage("Hon stannar upp! Hon har hört om draken du dräpt, hon vet vad du vill ha...");
            ui.showMessage("Du får nyckeln runt hennes hals utan bekymmer..hon vill inte dräpas...");
            player.setFoundSecondKey(true);
            player.addScore(20);
        }

    }
}
