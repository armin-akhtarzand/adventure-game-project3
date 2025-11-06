package se.sprinto.hakan.adventuregame.model.characters;

public class Player extends AbstractCharacter {
    private boolean foundFirstKey;
    private boolean foundSecondKey;
    private boolean foundThirdKey;
    private boolean defeatedGoblin;
    private boolean openedChest;
    private boolean hasNewArmor = false;
    private boolean dragonSlayed;
    private boolean hasWon = false;

    private boolean infoLastKeys;

    private Player(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    private Player(Builder builder) {
        this(builder.name, builder.health, builder.score, builder.strength);

    }

    public boolean hasFoundFirstKey() {return foundFirstKey;}
    public boolean hasFoundSecondKey() {return foundSecondKey;}
    public boolean hasFoundThirdKey() {return foundThirdKey;}
    public boolean hasInfoLastKeys() {return infoLastKeys;}

    public void setFoundFirstKey(boolean foundFirstKey) {this.foundFirstKey = foundFirstKey;}
    public void setFoundSecondKey(boolean foundSecondKey) {this.foundSecondKey = foundSecondKey;}
    public void setFoundThirdKey(boolean foundThirdKey) {this.foundThirdKey = foundThirdKey;}

    public boolean hasFoundAllKeys() {
        if(hasFoundFirstKey() && hasFoundSecondKey() && hasFoundThirdKey()) {
            return true;
        }
        return false;}

    public void setInfoLastKeys(boolean infoLastKeys) {this.infoLastKeys = infoLastKeys;}



    public boolean hasDefeatedGoblin() {
        return defeatedGoblin;
    }


    public void setDefeatedGoblin(boolean defeatedGoblin) {
        this.defeatedGoblin = defeatedGoblin;
    }

    public boolean hasOpenedChest() {
        return openedChest;
    }

    public void setOpenedChest(boolean openedChest) {
        this.openedChest = openedChest;
    }

    public boolean hasWon(){
        return hasWon;
    }
    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public boolean getDragonSlayed() {return dragonSlayed;}
    public void setDragonSlayed(boolean dragonSlayed) {this.dragonSlayed = dragonSlayed;}


    public void newSword() {
        setStrength(20);
    }
    public boolean hasNewArmor() {
        return hasNewArmor;
    }
    public void setHasNewArmor(boolean hasNewArmor) {
        this.hasNewArmor = hasNewArmor;
        if(hasNewArmor){
            setHealth(200);
        }
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());

        if (!target.isAlive()) {
            addScore(50);
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

        public Player build() {
            return new Player(this);
        }
    }
}
