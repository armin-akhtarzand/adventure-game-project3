package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.characters.Dragon;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.rooms.TowerRoom;
import se.sprinto.hakan.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.view.MultiInputFakeUI;
import java.util.List;

public class TowerRoomTest {

    private TowerRoom towerRoom;
    private Player player;
    private FakeUI fakeUI;
    private Dragon dragon;
    private int expectedHealthAfterBaseDMG;
    private int dragonStartHealth;
    int dragonHealthAfterAttack;
    int dragonDamage;
    private MultiInputFakeUI multiUI;

    @BeforeEach
    public void setUp() {
        towerRoom = new TowerRoom();
        multiUI = new MultiInputFakeUI();
        player = new Player.Builder()
                .strength(10)
                .health(100)
                .build();
        dragonStartHealth = 110;
        dragonDamage = 15;

    }

    @Test
    void takesExtraDamageWithoutArmor(){
        player.setHasNewArmor(false);
        expectedHealthAfterBaseDMG = player.getHealth()-dragonDamage;
        multiUI.setInputs(List.of("a","r"));
        towerRoom.enterRoom(player,multiUI);

        Assertions.assertTrue(player.getHealth()< expectedHealthAfterBaseDMG);

    }

    @Test
    void takesNoExraDamageWithArmor(){
        player.setHasNewArmor(true);
        expectedHealthAfterBaseDMG = player.getHealth()-dragonDamage;
        multiUI.setInputs(List.of("a","r"));
        towerRoom.enterRoom(player,multiUI);

        Assertions.assertEquals(expectedHealthAfterBaseDMG,player.getHealth());
    }

    @Test
    void playerDoesExtraDamageWithSword(){
        player.newSword();
        dragonHealthAfterAttack = dragonStartHealth - player.getStrength();
        multiUI.setInputs(List.of("a","r"));
        towerRoom.enterRoom(player,multiUI);

        Assertions.assertEquals(90,dragonHealthAfterAttack);
    }
}
