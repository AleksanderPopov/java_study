package com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.factories;

import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.types.Archer;
import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.types.Mage;
import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.types.Warrior;

/**
 * Created by apop on 4/12/2017.
 */
public class ElfSquadronFactory extends SquadronFactory {
    public Mage createMage() {
        return new ElfMage();
    }

    public Archer createArcher() {
        return new ElfArcher();
    }

    public Warrior createWarrior() {
        return new ElfWarrior();
    }
}

class ElfMage implements Mage {
    public void cast() {
        // использовать магию эльфов
    }
}

class ElfArcher implements Archer {
    public void shoot() {
        // использовать лук эльфов
    }
}

class ElfWarrior implements Warrior {
    public void attack() {
        // использовать меч эльфов
    }
}

