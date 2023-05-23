package efs.task.oop;

public class Monsters {
    static final Monster andariel = new Monster(10, 70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            this.health -= damage;
            Monsters.monstersHealth -= damage;
        }
    };

    static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            this.health -= (5 + damage);
            Monsters.monstersHealth -= (5 + damage);
        }
    };

    static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

    public static int getMonstersHealth() {
        return monstersHealth;
    }

    public static Monster getAndariel() {
        return andariel;
    }

    public static Monster getBlacksmith() {
        return blacksmith;
    }
}
