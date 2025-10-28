package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class TreasureRoomTest {

    Player player;
    TreasureRoom treasureRoom;
    FakeUI fakeUI;
    ForestRoom forestRoom;


    @BeforeEach
    void setUp() {
        fakeUI = new FakeUI();
        player = new Player.Builder()
                .build();
        treasureRoom = new TreasureRoom();
        forestRoom = new ForestRoom();

        fakeUI.setInput("ja");
        forestRoom.enterRoom(player,fakeUI);
    }

    @Test
    void playerOpensChestWithKey() {
        treasureRoom.enterRoom(player, fakeUI);
        assertTrue(player.hasOpenedChest());
    }
}