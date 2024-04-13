package game.utils.factories;

import java.util.Map;

import game.gts.*;
import game.utils.reg;

public class RecipeFactory extends ItemFactory {

    public item[] Input;
    public item[] Output;
    public Runnable InputFun;
    public Runnable OutputFun;
    public machine BindedMachine;

    public reg<recipe> ParentOfThis;

    public RecipeFactory setName(String Name) {
        super.Name = Name;
        return this;
    }

    public RecipeFactory setDescription(String Description) {
        super.Description = Description;
        return this;
    }
    public RecipeFactory setFlags(String[] Flags) {
        super.Flags = Flags;
        return this;
    }

    public RecipeFactory setFlagSettings(Map<String, String> FlagSettings) {
        super.FlagSettings = FlagSettings;
        return this;
    }
    public RecipeFactory setParentOfThis(reg<recipe> ParentOfThis) {
        this.ParentOfThis = ParentOfThis;
        return this;
    }

    public RecipeFactory setInput(item[] Input) {
        this.Input = Input;
        return this;
    }

    public RecipeFactory setOutput(item[] Output) {
        this.Output = Output;
        return this;
    }

    public RecipeFactory setInputFun(Runnable InputFun) {
        this.InputFun = InputFun;
        return this;
    }

    public RecipeFactory setOutputFun(Runnable OutputFun) {
        this.OutputFun = OutputFun;
        return this;
    }

    public RecipeFactory setBindedMachine(machine BindedMachine) {
        this.BindedMachine = BindedMachine;
        return this;
    }



}