package com.example.stephenhite.dndnextgen.CreatorLogic;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Stephen Hite on 4/14/2015.
 */
public class CreatorCntl {
    public UserCharacter userCharacter = new UserCharacter();

    private String path = "/sdcard/";
    private final String charFilePath = "character_saves";
    private String charID = "char" + userCharacter.getName();
    private String fileExt = ".dndng";
    Context context = this.context;
    public String filePath = charFilePath + charID + fileExt;


    public Object loadCharacter() {
        FileInputStream saveInput = null;
        ObjectInputStream charInput = null;
        String filePath = charFilePath + charID + fileExt;

        try {
            File f = new File(context.getFilesDir(), filePath);
            if (f.exists()) {
                saveInput = new FileInputStream(filePath);
                charInput = new ObjectInputStream(saveInput);
                userCharacter = (UserCharacter) charInput.readObject();
                charInput.close();
            }
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
}
