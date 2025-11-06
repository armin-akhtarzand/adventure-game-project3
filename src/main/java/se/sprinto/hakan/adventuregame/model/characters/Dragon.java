package se.sprinto.hakan.adventuregame.model.characters;

import se.sprinto.hakan.adventuregame.view.UI;

import java.util.Random;

public class Dragon extends AbstractCharacter {
    private Random random = new Random();


    private Dragon(String name, int health, int score, int strength) {super(name, health, score, strength);}
    private Dragon(Builder builder) {super(builder.name, builder.health, builder.score, builder.strength);}

    @Override
    public void attack(AbstractCharacter target) {target.setHealth(target.getHealth() - this.getStrength());}

    public int getStrength() {return super.getStrength();}
    public void setStrength(int strength) {super.setStrength(strength);}

    public void interact(Player player, UI ui) {

        if(!player.hasNewArmor()){
            setStrength(getStrength()+random.nextInt(5)+1);
        }while (player.isAlive() && isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(this);
                ui.showMessage("Du attackerar draken! Drakens HP: " + getHealth());
                if (isAlive()) {
                    attack(player);
                    ui.showMessage("Draken attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade draken!");
                    ui.showMessage("Du ser en nyckel fast i draken fjäll. Du plockar upp den. ");
                    player.setFoundThirdKey(true);
                    player.setDragonSlayed(true);
                    player.addScore(50);

                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }
    }

    public static class Builder{
        private String name;
        private int health;
        private int strength;
        private int score;

        public Builder name (String name) {
            this.name = name;
            return this;
        }
        public Builder health(int health) {
            this.health = health;
            return this;
        }
        public Builder strength(int strength) {
            this.strength = strength;
            return this;
        }
        public Builder score(int score) {
            this.score = score;
            return this;
        }

        public Dragon build() {
            return new Dragon(this);
        }
    }
}
