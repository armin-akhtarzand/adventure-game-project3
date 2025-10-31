package se.sprinto.hakan.adventuregame.model.characters;

import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

public class Mermaid extends AbstractCharacter {




    private Mermaid(String name, int health, int score, int strength) {super(name, health, score, strength);}
    private Mermaid(Builder builder) {super(builder.name, builder.health, builder.score, builder.strength);}

    @Override
    public void attack(AbstractCharacter target) {target.setHealth(target.getHealth() - this.getStrength());}




    public void interact(Player player,UI ui) {
        int dmg = player.getHealth();
        int originalStrength = this.getStrength();
        boolean correct = false;
        int triesLeft = 2;
        ui.showMessage("Hon vet vad du är ute efter (hon visar upp nyckeln runt hennes hals");
        ui.showMessage("Nyckeln är din ifall du kan besvara hennes gåta (du har 2 försök)");

        while(triesLeft > 0) {
            String choice = ui.getInput("“\nJag föds i himlen, faller mot jorden, släcker törst och tystar damm." +
                    "\nVad är jag?: ”").toUpperCase().trim();

            if(choice.equals("REGN")){
                correct = true;
                break;
            }else{
                --triesLeft;
                ui.showMessage("Du svarade fel! Försök kvar: " + triesLeft);
            }
        }
        if(correct) {
            ui.showMessage("Du är fri igen! Hon ger dig en till nyckel! Men du får även en present av henne.\n" +
                    "En flamsäker rustning! \"Den lär behövas\" säger sjöjungfrun");

            ui.showMessage("\nRustning: FENIXRUSTNINGEN");
            ui.showMessage(player.getName()+" känner sig som återfödd i lågor!");
            player.setFoundSecondKey(true);
            //player.newArmor();
            player.setHasNewArmor(true);
            ui.showMessage("HP = " + player.getHealth());
            player.addScore(50);
        }else{
            ui.showMessage("Dina försök är slut...Sjönungfruns vattenbubbla kväver dig...");
            this.setStrength(dmg);
            attack(player);
            this.setStrength(originalStrength);
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
        public Mermaid build() {
            return new Mermaid(this);
        }
    }

}
