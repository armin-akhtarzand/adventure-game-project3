package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class DungeonRoomTest{

    Player player;
    DungeonRoom dungeonRoom;
    FakeUI fakeUI;

    @BeforeEach
    void setUp() {
        player = new Player.Builder()
                .strength(10)
                .health(100)
                .build();
        fakeUI = new FakeUI();
        dungeonRoom = new DungeonRoom();


    }

    @Test
    void playerDefeatsEnemyTest() {
        fakeUI.setInput("a");
        dungeonRoom.enterRoom(player, fakeUI);


        assertTrue(player.hasDefeatedEnemy());
    }
}