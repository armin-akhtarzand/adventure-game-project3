package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;
    FakeUI fakeUI;
    Enemy enemy;

    @BeforeEach
    void setUp() {
        fakeUI = new FakeUI();
        player = new Player.Builder()
                .strength(10)
                .build();
        enemy = new Enemy.Builder()
                .health(20)
                .build();
    }



    @Test
    void attackReduceEnemyHealth() {
        player.attack(enemy);

        assertEquals(10,enemy.getHealth());

    }
}