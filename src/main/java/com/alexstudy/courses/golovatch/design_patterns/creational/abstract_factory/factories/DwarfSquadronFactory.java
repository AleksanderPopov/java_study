package com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.factories;

import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.types.Archer;
import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.types.Mage;
import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.types.Warrior;

/**
 * Created by apop on 4/12/2017.
 */
public class DwarfSquadronFactory extends SquadronFactory {
    public Mage createMage() {
        return new DwarfMage();
    }

    public Archer createArcher() {
        return new DwarfArcher();
    }

    public Warrior createWarrior() {
        return new DwarfWarrior();
    }
}

class DwarfMage implements Mage {
    public void cast() {
        // use dwarf magic
    }
}

class DwarfArcher implements Archer {
    public void shoot() {
        // use dwarf gun
    }
}

class DwarfWarrior implements Warrior {
    public void attack() {
        // use dwarf weapon
    }
}