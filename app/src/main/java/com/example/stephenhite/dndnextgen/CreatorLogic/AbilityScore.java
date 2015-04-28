package com.example.stephenhite.dndnextgen.CreatorLogic;

public class AbilityScore {
    private String name;
    private int value = 0;
    private int modifier = 0;

    AbilityScore() {

    }

    public int calcMod() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the modifier
     */
    public int getModifier() {
        return modifier;
    }

    /**
     * @param modifier the modifier to set
     */
    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

}

