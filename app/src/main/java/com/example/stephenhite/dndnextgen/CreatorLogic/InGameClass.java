package com.example.stephenhite.dndnextgen.CreatorLogic;

import java.io.Serializable;

/**
 * Created by Stephen Hite on 4/5/2015.
 */
public class InGameClass implements Serializable {
    private String name;
    private int classID;
    String description;


    String barbarianText;
    String bardText;
    String clericText;
    String druidText;
    String fighterText;
    String monkText;
    String paladinText;
    String rangerText;
    String rogueText;
    String sorcerorText;
    String warlockText;
    String wizardText;

    InGameClass barbarian, bard, cleric, druid, fighter, monk, paladin, ranger, rogue, sorcerer, warlock, wizard;

    InGameClass(String name, int classID) {
        this.name = name;
        this.classID = classID;
    }

    public void initClasses() {
        barbarian = new InGameClass("Barbarian", 1);
        bard = new InGameClass("Bard", 2);
        cleric = new InGameClass("Cleric", 3);
        druid = new InGameClass("Druid", 4);
        fighter = new InGameClass("Fighter", 5);
        monk = new InGameClass("Monk", 6);
        paladin = new InGameClass("Paladin", 7);
        ranger = new InGameClass("Ranger", 8);
        rogue = new InGameClass("Rogue", 9);
        sorcerer = new InGameClass("Sorcerer", 10);
        warlock = new InGameClass("Warlock", 11);
        wizard = new InGameClass("Wizard", 12);
    }

}
