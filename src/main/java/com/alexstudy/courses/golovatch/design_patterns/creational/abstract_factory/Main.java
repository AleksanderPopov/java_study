package com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory;

import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.factories.DwarfSquadronFactory;
import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.factories.ElfSquadronFactory;
import com.alexstudy.courses.golovatch.design_patterns.creational.abstract_factory.factories.SquadronFactory;

/**
 * Created by apop on 4/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        createSquadron(new ElfSquadronFactory());
        createSquadron(new DwarfSquadronFactory());
    }

    public static void createSquadron(SquadronFactory factory) {
        factory.createArcher();
        factory.createMage();
        factory.createWarrior();
    }
}
