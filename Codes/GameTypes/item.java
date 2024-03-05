package Codes.GameTypes;

import java.util.Map;

public class item {

    public String name;
    public String description;

    public String[] flags;
    public Map<String, String> flagSettings;

    public item(
            String name,
            String description,

            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.description = description;

        this.flags = flags;
        this.flagSettings = flagSettings;
    }

}
