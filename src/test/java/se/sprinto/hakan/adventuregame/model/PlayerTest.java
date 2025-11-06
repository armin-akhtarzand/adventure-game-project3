package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.characters.Goblin;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;
    FakeUI fakeUI;
    Goblin goblin;

    @BeforeEach
    void setUp() {
        fakeUI = new FakeUI();
        player = new Player.Builder()
                .strength(10)
                .build();
        goblin = new Goblin.Builder()
                .health(20)
                .build();
    }



    @Test
    void attackReduceEnemyHealth() {
        player.attack(goblin);

        assertEquals(10, goblin.getHealth());

    }
}