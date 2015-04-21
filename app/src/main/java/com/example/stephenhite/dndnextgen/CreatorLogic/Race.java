package com.example.stephenhite.dndnextgen.CreatorLogic;

import java.io.Serializable;

/**
 * Created by Stephen Hite on 4/5/2015.
 */
public class Race implements Serializable {
    String name;
    int raceID;
    int strMod;
    int dexMod;
    int conMod;
    int wisMod;
    int chaMod;
    int intMod;

    private Race dwarf;
    private Race elf;
    private Race gnome;
    private Race halfElf;
    private Race halfOrc;
    private Race halfling;
    private Race human;
    private Race dragonborn;
    private Race aasimar;
    private Race tiefling;


    Race(String name, int raceID, int strMod, int dexMod, int conMod, int wisMod, int chaMod, int intMod) {
        this.name = name;
        this.raceID = raceID;
        this.strMod = strMod;
        this.dexMod = dexMod;
        this.conMod = conMod;
        this.wisMod = wisMod;
        this.chaMod = chaMod;
        this.intMod = intMod;
    }

    public Race getDwarf() {
        return dwarf;
    }

    public void setDwarf(Race dwarf) {
        this.dwarf = dwarf;
    }

    public Race getElf() {
        return elf;
    }

    public void setElf(Race elf) {
        this.elf = elf;
    }

    public Race getGnome() {
        return gnome;
    }

    public void setGnome(Race gnome) {
        this.gnome = gnome;
    }

    public Race getHalfElf() {
        return halfElf;
    }

    public void setHalfElf(Race halfElf) {
        this.halfElf = halfElf;
    }

    public Race getHalfOrc() {
        return halfOrc;
    }

    public void setHalfOrc(Race halfOrc) {
        this.halfOrc = halfOrc;
    }

    public Race getHalfling() {
        return halfling;
    }

    public void setHalfling(Race halfling) {
        this.halfling = halfling;
    }

    public Race getHuman() {
        return human;
    }

    public void setHuman(Race human) {
        this.human = human;
    }

    public Race getDragonborn() {
        return dragonborn;
    }

    public void setDragonborn(Race dragonborn) {
        this.dragonborn = dragonborn;
    }

    public Race getAasimar() {
        return aasimar;
    }

    public void setAasimar(Race aasimar) {
        this.aasimar = aasimar;
    }

    public Race getTiefling() {
        return tiefling;
    }

    public void setTiefling(Race tiefling) {
        this.tiefling = tiefling;
    }
}

