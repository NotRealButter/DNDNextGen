package com.example.stephenhite.dndnextgen.CreatorLogic;

import java.io.Serializable;

public class UserCharacter implements Serializable {
    private String name;
    private int health;
    private String class1;
    private String class2;
    private int age;
    private String gender;
    private String alignment;
    private String race;
    private int height;
    private int weight;
    private int strVal;
    private int dexVal;
    private int conVal;
    private int wisVal;
    private int chaVal;
    private int intVal;
    private int armorClass;
    private int initiative;
    private int speed;

    public UserCharacter() {
        name = "Default";
        health = 10;
        class1 = "fighter";
        class2 = "wizard";
        age = 30;
        gender = "Female";
        alignment = "True Neutral";
        race = "human";
        height = 68;
        weight = 120;
        strVal = 15;
        dexVal = 12;
        conVal = 13;
        wisVal = 14;
        chaVal = 12;
        intVal = 13;
        armorClass = 16;
        initiative = 2;
        speed = 30;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

//    public InGameClass getClass1() {
//        return class1;
//    }
//
//    public void setClass1(String selectedClass)
//    {
//        switch(selectedClass.toLowerCase())
//        {
//            case "fighter":
//                this.class1 = class1.fighter;
//            case "barbarian":
//                this.class1=class1.fighter;
//            case "bard":
//                this.class1=class1.bard;
//            case "cleric":
//                this.class1=class1.cleric;
//            case "druid":
//                this.class1=class1.druid;
//            case "monk":
//                this.class1 = class1.monk;
//            case "paladin":
//                this.class1=class1.paladin;
//            case "ranger":
//                this.class1=class1.ranger;
//            case "rogue":
//                this.class1=class1.rogue;
//            case "sorceror":
//                this.class1=class1.sorceror;
//            case "wizard":
//                this.class1=class1.wizard;
//            case "oracle":
//    this.class1=class1.oracle;                   }
//    }
//
//    public InGameClass getClass2() {
//        return class2;
//    }
//
//    public void setClass2(String selectedClass) {
//        switch (selectedClass.toLowerCase()) {
//            case "fighter":
//                this.class2 = class2.fighter;
//            case "barbarian":
//                this.class2 = class2.fighter;
//            case "bard":
//                this.class2 = class2.bard;
//            case "cleric":
//                this.class2 = class2.cleric;
//            case "druid":
//                this.class2 = class2.druid;
//            case "monk":
//                this.class2 = class2.monk;
//            case "paladin":
//                this.class2 = class2.paladin;
//            case "ranger":
//                this.class2 = class2.ranger;
//            case "rogue":
//                this.class2 = class2.rogue;
//            case "sorceror":
//                this.class2 = class2.sorceror;
//            case "wizard":
//                this.class2 = class2.wizard;
//            case "oracle":
//                this.class2 = class2.oracle;
//        }
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

//    public Race getRace() {
//        return race;
//    }
//
//    public void setRace(String selectedRace) {
//        switch (selectedRace.toLowerCase()) {
//            case "human":
//                this.race = race.getHuman();
//            case "elf":
//                this.race = race.getElf();
//            case "halfElf":
//                this.race = race.getHalfElf();
//            case "halfOrc":
//                this.race = race.getHalfOrc();
//            case "aasimar":
//                this.race = race.getAasimar();
//            case "halfling":
//                this.race = race.getHalfling();
//            case "tiefling":
//                this.race = race.getTiefling();
//            case "dragonborn":
//                this.race = race.getDragonborn();
//            case "dwarf":
//                this.race = race.getDwarf();
//            case "gnome":
//                this.race = race.getGnome();
//            default:
//                this.race = race.getHuman();
//        }
//    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrVal() {
        return strVal;
    }

    public void setStrVal(int strVal) {
        this.strVal = strVal;
    }

    public int getDexVal() {
        return dexVal;
    }

    public void setDexVal(int dexVal) {
        this.dexVal = dexVal;
    }

    public int getConVal() {
        return conVal;
    }

    public void setConVal(int conVal) {
        this.conVal = conVal;
    }

    public int getWisVal() {
        return wisVal;
    }

    public void setWisVal(int wisVal) {
        this.wisVal = wisVal;
    }

    public int getChaVal() {
        return chaVal;
    }

    public void setChaVal(int chaVal) {
        this.chaVal = chaVal;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

}
