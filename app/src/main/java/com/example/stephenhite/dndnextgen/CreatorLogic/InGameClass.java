package com.example.stephenhite.dndnextgen.CreatorLogic;

import java.io.Serializable;

/**
 * Created by Stephen Hite on 4/5/2015.
 */
public class InGameClass implements Serializable {
    private String name;
    private int classID;
    String description;


    String alchemistText;
    String barbarianText;
    String bardText;
    String cavalierText;
    String clericText;
    String druidText;
    String fighterText;
    String gunslingerText;
    String inquisitorText;
    String magusText;
    String monkText;
    String oracleText;
    String paladinText;
    String rangerText;
    String rogueText;
    String sorcerorText;
    String summonerText;
    String wizardText;
    String witchText;

    InGameClass alchemist, barbarian, bard, cavalier, cleric, druid, fighter, gunslinger, inquisitor, magus, monk, oracle, paladin, ranger, rogue, sorceror, summoner, wizard, witch;

    InGameClass(String name, int classID, String description) {
        this.name = name;
        this.classID = classID;
        this.description = description;
    }

    public void initClasses() {
        barbarian = new InGameClass("Barbarian", 1, barbarianText);
        bard = new InGameClass("Bard", 2, bardText);
        cleric = new InGameClass("Cleric", 3, clericText);
        druid = new InGameClass("Druid", 4, druidText);
        fighter = new InGameClass("Fighter", 5, fighterText);
        monk = new InGameClass("Monk", 6, monkText);
        paladin = new InGameClass("Paladin", 7, paladinText);
        ranger = new InGameClass("Ranger", 8, rangerText);
        rogue = new InGameClass("Rogue", 9, rogueText);
        sorceror = new InGameClass("Sorceror", 10, sorcerorText);
        wizard = new InGameClass("Wizard", 11, wizardText);
        oracle = new InGameClass("Oracle", 17, oracleText);
    }

}
