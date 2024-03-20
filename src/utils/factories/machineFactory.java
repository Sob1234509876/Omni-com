package src.utils.factories;

import java.util.Map;

import src.gts.machine;
import src.gts.recipe;
import src.utils.reg;

public class machineFactory implements factory {

    private String name;
    private String description;

    private Map<String, recipe> ChildOfThis;

    private String[] flags;
    private Map<String, String> flagSettings;

    private reg<machine> ParentOfThis;

    public machineFactory setName(String name) {
        this.name = name;
        return this;
    }

    public machineFactory setDescription(String description) {
        this.description = description;
        return this;
    }

    public machineFactory setChildOfThis(Map<String, recipe> ChildOfThis) {
        this.ChildOfThis = ChildOfThis;
        return this;
    }

    public machineFactory setFlags(String[] flags) {
        this.flags = flags;
        return this;
    }

    public machineFactory setFlagSettings(Map<String, String> flagSettings) {
        this.flagSettings = flagSettings;
        return this;
    }

    public machineFactory setParentOfThis(reg<machine> ParentOfThis) {
        this.ParentOfThis = ParentOfThis;
        return this;
    }

    public machine getProduct() {
        return new machine(
                this.name,
                this.description,
                this.ChildOfThis,
                this.flags,
                this.flagSettings,
                this.ParentOfThis);
    }

}