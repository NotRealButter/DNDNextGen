package com.example.stephenhite.dndnextgen.CreatorLogic;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Stephen Hite on 4/14/2015.
 */
public class CreatorCntl implements Parcelable {
    public UserCharacter userCharacter = new UserCharacter();

    private String path = "/sdcard/";
    private final String charFilePath = "/character_saves/";
    private String charID = "char" + userCharacter.getName();
    private String fileExt = ".dndng";
    public String filePath = charID + fileExt;
    public ArrayList<String> fileNames = new ArrayList<String>();

    private Race human, elf, halfling, halfOrc, halfElf, dwarf, tiefling, eladrin, dragonBorn;
    InGameClass barbarian, bard, cleric, druid, fighter, monk, paladin, ranger, rogue, sorcerer, warlock, wizard;

    public File[] listFilesMatching(File root, String regex) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(userCharacter);
    }

    public void readFromParcel(Parcel in) {
        in.readParcelable(CreatorCntl.class.getClassLoader());
    }
}
