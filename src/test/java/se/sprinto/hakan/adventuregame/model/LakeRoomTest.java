package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.rooms.LakeRoom;
import se.sprinto.hakan.adventuregame.view.FakeUI;

public class LakeRoomTest {

    private LakeRoom lakeRoom;
    private FakeUI fakeUI;
    private Player player;
    int expectedHP;

    @BeforeEach
    void setUp() {
        lakeRoom = new LakeRoom();
        fakeUI = new FakeUI();
        player = new Player.Builder()
                .health(10)
                .build();

        expectedHP = 200;
    }


    @Test
    void correctAnswerGivesNewArmor() {
        fakeUI.setInput("regn");
        lakeRoom.enterRoom(player,fakeUI);

        Assertions.assertTrue(player.getHasNewArmor());;
    }
    @Test
    void correctAnswerIncreaseHealth() {
        fakeUI.setInput("regn");
        lakeRoom.enterRoom(player,fakeUI);
        Assertions.assertTrue(player.getHealth() == expectedHP);
    }

    @Test
    void wrongAnswerKillsPlayer(){
        fakeUI.setInput("fel");
        lakeRoom.enterRoom(player,fakeUI);
        Assertions.assertEquals(0, player.getHealth());
    }

}
