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

    public void setRace(String race) {
    this.race = race;
}

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    public String getRace() {
        return race;
    }

    public String getClass1() {
        return class1;
    }

    public String getClass2() {
        return class2;
    }

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
