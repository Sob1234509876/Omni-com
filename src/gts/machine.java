package src.gts;

import java.util.Map;

import src.utils.reg;

public class machine {

    public String name;
    public String description;

    public Map<String, recipe> ChildOfThis;

    public String[] flags;
    public Map<String, String> flagSettings;
    public reg<machine> ParentOfThis;

    public machine(

            String name,
            String description,

            Map<String, recipe> ChildOfThis,

            String[] flags,
            Map<String, String> flagSettings,
            reg<machine> ParentOfThis) {
        this.name = name;
        this.description = description;
        this.ChildOfThis = ChildOfThis;
        this.flags = flags;
        this.flagSettings = flagSettings;
        this.ParentOfThis = ParentOfThis;
    }
}
