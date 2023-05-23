package efs.task.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Villager kashya = new Villager("Kashya", 30);
        Villager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager gheed = new Villager("Gheed", 50);
        Villager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        kashya.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckardCain.sayHello();
        warriv.sayHello();
        flawia.sayHello();

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;
//        objectAkara.sayHello();
//        objectDeckardCain.sayHello();
//        Powyższych nie możemy wykonać i dostajemy informacje
//        Cannot resolve method 'sayHello' in 'Object'

        List<Villager> villagers = new ArrayList<>();
        villagers.add(kashya);
        villagers.add(akara);
        villagers.add(gheed);
        villagers.add(deckardCain);
        villagers.add(warriv);
        villagers.add(flawia);

        Monster monster1 = Monsters.andariel;
        Monster monster2 = Monsters.blacksmith;

        int fightingVillagerIndex = 0;

        while (Monsters.getMonstersHealth() > 0 && !villagersAreDead(villagers)) {
            Villager currentFighter = villagers.get(fightingVillagerIndex);
            System.out.println("Potwory posiadaja jeszcze " + Monsters.getMonstersHealth() + " punktow zycia.");
            System.out.println("Aktualnie walczacy osadnik to " + currentFighter.getName());

            if (monster1.getHealth() > 0) {
                currentFighter.attack(monster1);
                if (monster1.getHealth() > 0) {
                    monster1.attack(currentFighter);
                }
            }

            if (currentFighter.getHealth() <= 0)
            {
                fightingVillagerIndex = chooseNextVillager(villagers, fightingVillagerIndex);
                currentFighter = villagers.get(fightingVillagerIndex);
            }

            if (monster2.getHealth() > 0) {
                currentFighter.attack(monster2);
                if (monster2.getHealth() > 0) {
                    monster2.attack(currentFighter);
                }
            }

            fightingVillagerIndex = chooseNextVillager(villagers, fightingVillagerIndex);
        }

        if (Monsters.getMonstersHealth() <= 0) {
            System.out.println("Obozowisko ocalone!");
        } else {
            System.out.println("Potwory pokonaly obozowisko!");
        }


        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;
        deckardCain.sayHello();
        akara.sayHello();

    }

    private static boolean villagersAreDead(List<Villager> villagers) {
        for (Villager villager : villagers) {
            if (villager.getHealth() > 0) {
                return false;
            }
        }
        return true;
    }

    private static int chooseNextVillager(List<Villager> villagers, int currentIndex) {
        do {
            currentIndex++;
            if (currentIndex >= villagers.size()) {
                currentIndex = 0;
            }
        } while (villagers.get(currentIndex).getHealth() <= 0);

        return currentIndex;
    }
}
