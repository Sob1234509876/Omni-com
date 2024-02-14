package Codes.GameTypes;

import java.util.Map;

public class item {

    public String name;
    public String description;
    public String type;
    public String getType;
    public String recipeType;
    public item[] recipe;

    public long amount = 0;
    public double damage = 0;
    public long temperature = 300;
    public long poison = 0;
    public long radioactivity = 0;

    public Runnable useFun;
    public Runnable passiveFun;

    public String[] flags;
    public Map<String, String> flagSettings;

    public item(
            String name,
            String description,
            String type,
            String getType,

            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.getType = getType;

        this.amount = 0;

        this.flags = flags;
        this.flagSettings = flagSettings;
    }

}
