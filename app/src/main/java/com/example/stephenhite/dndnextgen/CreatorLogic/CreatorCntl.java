package com.example.stephenhite.dndnextgen.CreatorLogic;

import android.content.Context;
import android.widget.Spinner;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CreatorCntl {
    public UserCharacter userCharacter = new UserCharacter();

    private String path = "/sdcard/";
    private final String charFilePath = "/character_saves/";
    private String charID = "char" + userCharacter.getName();
    private String fileExt = ".dndng";
    public String filePath = charID + fileExt;
    public ArrayList<String> fileNames = new ArrayList<String>();

    public String currentSave = null;

    private Race human, elf, halfling, halfOrc, halfElf, dwarf, tiefling, eladrin, dragonBorn;
    InGameClass barbarian, bard, cleric, druid, fighter, monk, paladin, ranger, rogue, sorcerer, warlock, wizard;
    int diceValue;


    public File[] listFilesMatching(File root, String regex) {
        if (fileNames != null) {
            fileNames.clear();
        }
        if (!root.isDirectory()) {
            throw new IllegalArgumentException(root + "is not directory");
        }
        final Pattern p = Pattern.compile(regex);
        return root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                fileNames.add(file.getName());
                return p.matcher(file.getName()).matches();
            }
        });
    }

    public Object loadCharacter(Context context) {
        FileInputStream saveInput = null;
        ObjectInputStream charInput = null;

        try {
            saveInput = context.openFileInput(filePath);
            charInput = new ObjectInputStream(saveInput);
            userCharacter = (UserCharacter) charInput.readObject();
            saveInput.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Object loadCharacter(Context context, String fileName) {
        FileInputStream saveInput = null;
        ObjectInputStream charInput = null;
        currentSave = fileName;

        try {
            saveInput = context.openFileInput(fileName);
            charInput = new ObjectInputStream(saveInput);
            userCharacter = (UserCharacter) charInput.readObject();
            saveInput.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public void saveCharacter(Context context) {
        FileOutputStream saveCharacter = null;
        ObjectOutputStream objectOutputStream = null;
        charID = "char" + userCharacter.getName();
        fileExt = ".dndng";
        filePath = charID + fileExt;

        try {
            saveCharacter = context.openFileOutput(filePath, Context.MODE_PRIVATE);
            objectOutputStream = new ObjectOutputStream(saveCharacter);
            objectOutputStream.writeObject(userCharacter);
            objectOutputStream.close();
        } catch (IOException x) {
            x.printStackTrace();
        }
    }

    public int findIndexOf(String compareVal, Spinner source) {
        int index = 0;
        for (int i = 0; i < source.getCount(); i++) {
            if (source.getItemAtPosition(i).toString().equals(compareVal)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int calcMod(int value) {
        switch (value) {
            case 1:
            case 2:
            case 3:
                return -4;
            case 4:
            case 5:
                return -3;
            case 6:
            case 7:
                return -2;
            case 8:
            case 9:
                return -1;
            case 10:
            case 11:
                return 0;
            case 12:
            case 13:
                return 1;
            case 14:
            case 15:
                return 2;
            case 16:
            case 17:
                return 3;
            case 18:
            case 19:
                return 4;
            case 20:
            case 21:
                return 5;
            case 22:
            case 23:
                return 6;
        }
        return 0;
    }

    public int abilityScoreRoll() {
        int firstDie = 0;
        int secondDie = 0;
        int thirdDie = 0;
        int fourthDie = 0;
        int total = 0;

        firstDie = rollDice(6);
        secondDie = rollDice(6);
        thirdDie = rollDice(6);
        fourthDie = rollDice(6);

        total = firstDie + secondDie + thirdDie + fourthDie - Math.min(Math.min(firstDie, secondDie), Math.min(thirdDie, fourthDie));
        return total;
    }

    public int rollDice(int numOfSides) {
        diceValue = (int) (Math.random() * numOfSides + 1);
        return diceValue;
    }
}