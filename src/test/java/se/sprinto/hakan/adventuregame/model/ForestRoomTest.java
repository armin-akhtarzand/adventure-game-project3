package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.rooms.ForestRoom;
import se.sprinto.hakan.adventuregame.view.FakeUI;


import static org.junit.jupiter.api.Assertions.*;

class ForestRoomTest {

    FakeUI fakeUI;
    ForestRoom forestRoom;
    Player player;

    @BeforeEach
    void setUp() {
        fakeUI = new FakeUI();
        forestRoom = new ForestRoom();
        player = new Player.Builder()
                .build();


    }



    @Test
    void playerFindsKeyTest() {
        fakeUI.setInput("ja");
        forestRoom.enterRoom(player,fakeUI);
        assertTrue(player.hasFoundFirstKey());
    }

    @Test
    void playerDoesNotFindKeyTest() {
        fakeUI.setInput("nej");
        forestRoom.enterRoom(player,fakeUI);
        assertFalse(player.hasFoundFirstKey());
    }
}