package com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.factories;

import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.types.Archer;
import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.types.Mage;
import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.types.Warrior;

/**
 * Created by apop on 4/12/2017.
 */
public abstract class SquadronFactory {
    public abstract Mage createMage();

    public abstract Archer createArcher();

    public abstract Warrior createWarrior();
}

