package se.sprinto.hakan.adventuregame.model.characters;
import se.sprinto.hakan.adventuregame.model.rooms.TownRoom;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

public class MysteriousMan extends AbstractCharacter {
    TownRoom townRoom;
    private boolean walkAway;


    public MysteriousMan(String name, int health, int score, int strength) {super(name, health, score, strength);}
    private MysteriousMan(Builder builder) {super(builder.name,  builder.health, builder.score, builder.strength);}

    public void attack(AbstractCharacter target) {target.setHealth(target.getHealth() - this.getStrength());}


    public void interact(Player player,UI ui){
        int dmg = player.getHealth();
        int originalStrength = this.getStrength();
        if(walkAway){
            ui.showMessage("Du är oförskämd och vänder ryggen mot den mysteriska mannen");
            ui.showMessage("Han hugger dig i ryggen för din oförskämdhet");
            this.setStrength(dmg);
            attack(player);
            this.setStrength(originalStrength);
        }else{
            ui.showMessage("Han ger dig ett litet papper med informationen");
            player.setInfoLastKeys(true);
            ui.showMessage("Men han ger dig även ett nytt vapen! Vapnet känns bra i din hand. Du känner dig starkare!\n");
            player.newSword();
            ui.showMessage("Svärd: BENBRYTAREN");
            ui.showMessage(player.getName()+"s styrka växer!");
            ui.showMessage("STR = " + player.getStrength());

            ui.showMessage("\n2 nya dörrar har dykt upp i startrummet!");

        }

    }
    public void setWalkAway(boolean walkAway) {
        this.walkAway = walkAway;

    }




    public static class Builder{
        private String name;
        private int health;
        private int score;
        private int strength;


        public Builder name(String name) {
            this.name = name;
            return this;}

        public Builder health(int health) {
            this.health = health;
            return this;}

        public Builder score(int score) {
            this.score = score;
            return this;}

        public Builder strength(int strength) {
            this.strength = strength;
            return this;}



        public MysteriousMan build() {
            return new MysteriousMan(this);
        }
    }
}
