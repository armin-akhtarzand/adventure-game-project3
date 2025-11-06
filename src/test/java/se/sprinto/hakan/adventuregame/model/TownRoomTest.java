package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.rooms.TownRoom;
import se.sprinto.hakan.adventuregame.view.FakeUI;

public class TownRoomTest {

    private TownRoom townRoom;
    private Player player;
    FakeUI fakeUI;
    int expectedSTR;
    int playerDead;



    @BeforeEach
    public void setUp() {
        fakeUI = new FakeUI();
        townRoom = new TownRoom();
        player = new Player.Builder()
                .health(10)
                .strength(10)
                .build();

        expectedSTR = 20;

        player.setDefeatedGoblin(true);
        player.setFoundFirstKey(true);
    }

    @Test
     void answerYesIncreasesPlayerStrength(){
        fakeUI.setInput("ja");
        townRoom.enterRoom(player,fakeUI);

        Assertions.assertEquals(expectedSTR,player.getStrength());
    }

    @Test
    void answerYesGivesPlayerInformation(){
        fakeUI.setInput("ja");
        townRoom.enterRoom(player,fakeUI);

        Assertions.assertTrue(player.hasInfoLastKeys());
    }

    @Test
    void answerNoKillsPlayer(){
        fakeUI.setInput("nej");
        townRoom.enterRoom(player,fakeUI);

        Assertions.assertEquals(0,player.getHealth());
    }
}
