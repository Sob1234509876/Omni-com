package game.utils.templates;

import java.util.Map;

import game.gts.*;
import game.utils.reg;

public class RecipeTemplate extends ItemTemplate {

    public item[] Input;
    public item[] Output;
    public Runnable InputFun;
    public Runnable OutputFun;
    public machine BindedMachine;

    public reg<recipe> ParentOfThis;

    public RecipeTemplate setName(String Name) {
        super.Name = Name;
        return this;
    }

    public RecipeTemplate setDescription(String Description) {
        super.Description = Description;
        return this;
    }
    public RecipeTemplate setFlags(String[] Flags) {
        super.Flags = Flags;
        return this;
    }

    public RecipeTemplate setFlagSettings(Map<String, String> FlagSettings) {
        super.FlagSettings = FlagSettings;
        return this;
    }
    public RecipeTemplate setParentOfThis(reg<recipe> ParentOfThis) {
        this.ParentOfThis = ParentOfThis;
        return this;
    }

    public RecipeTemplate setInput(item[] Input) {
        this.Input = Input;
        return this;
    }

    public RecipeTemplate setOutput(item[] Output) {
        this.Output = Output;
        return this;
    }

    public RecipeTemplate setInputFun(Runnable InputFun) {
        this.InputFun = InputFun;
        return this;
    }

    public RecipeTemplate setOutputFun(Runnable OutputFun) {
        this.OutputFun = OutputFun;
        return this;
    }

    public RecipeTemplate setBindedMachine(machine BindedMachine) {
        this.BindedMachine = BindedMachine;
        return this;
    }



}