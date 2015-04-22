package com.example.stephenhite.dndnextgen.CreatorLogic;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Stephen Hite on 4/14/2015.
 */
public class CreatorCntl implements Parcelable {
    public UserCharacter userCharacter = new UserCharacter();

    private String path = "/sdcard/";
    private final String charFilePath = "character_saves";
    private String charID = "char" + userCharacter.getName();
    private String fileExt = ".dndng";
    public String filePath = charFilePath + charID + fileExt;

    private Race human, elf, halfling, halfOrc, halfElf, dwarf, tiefling, eladrin, dragonBorn;
    InGameClass barbarian, bard, cleric, druid, fighter, monk, paladin, ranger, rogue, sorcerer, warlock, wizard;


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
