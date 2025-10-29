package se.sprinto.hakan.adventuregame.model.characters;

public class Enemy extends AbstractCharacter {

    private Enemy(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    private Enemy (Builder builder) {
        this(builder.name, builder.health, builder.score, builder.strength);
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());
    }


    public static class Builder{
        private int health;
        private int strength;
        private int score;
        private String name;

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
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Enemy build(){
            return new Enemy(this);
        }

    }
}
