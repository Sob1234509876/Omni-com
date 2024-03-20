package src.gts;

import java.util.Map;

import src.utils.reg;

public class item {

    public String name;
    public String description;

    public String[] flags;
    public Map<String, String> flagSettings;
    public reg<item> ParentOfThis;

    public item(
            String name,
            String description,

            String[] flags,
            Map<String, String> flagSettings,
            reg<item> ParentOfThis) {
        this.name = name;
        this.description = description;

        this.flags = flags;
        this.flagSettings = flagSettings;
        this.ParentOfThis = ParentOfThis;
    }

}
