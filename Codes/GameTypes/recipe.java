package Codes.GameTypes;

import java.util.Map;

public class recipe {

    public String name;
    public String description;
    public machine craftType;
    public item[] input;
    public item[] output;
    public Runnable inputFun;
    public Runnable outputFun;

    public String[] flags;
    public Map<String, String> flagSettings;

    public recipe(
            String name,
            String description,
            item[] input,
            item[] output,
            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.description = description;
        this.input = input;
        this.output = output;
        this.flags = flags;
        this.flagSettings = flagSettings;
    }

    public recipe(
            String name,
            String description,
            item[] input,
            item[] output,
            Runnable runFun,
            boolean flag,
            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.description = description;
        this.input = input;
        this.output = output;
        if (flag)
            this.inputFun = runFun;
        else
            this.outputFun = runFun;
        this.flags = flags;
        this.flagSettings = flagSettings;
    }

    public recipe(
            String name,
            String description,
            item[] input,
            item[] output,
            Runnable inputFun,
            Runnable outputFun,
            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.description = description;
        this.input = input;
        this.output = output;
        this.inputFun = inputFun;
        this.outputFun = outputFun;
        this.flags = flags;
        this.flagSettings = flagSettings;
    }

}
