package game.utils.templates;

import java.util.Map;

import game.gts.*;
import game.utils.*;

public class RecipeTemplate extends ItemTemplate {

    public Item[] Input;
    public Item[] Output;
    public Runnable InputFun;
    public Runnable OutputFun;
    public Machine BindedMachine;

    public Reg<Recipe> ParentOfThis;

    @Override
    public RecipeTemplate clone() {
        RecipeTemplate NEW = null;
        try {
            NEW = (RecipeTemplate) (super.clone());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return NEW;
    }

    public RecipeTemplate setName(String Name) {
        RecipeTemplate NEW = this.clone();
        NEW.Name = Name;
        return NEW;
    }

    public RecipeTemplate setDescription(String Description) {
        RecipeTemplate NEW = this.clone();
        NEW.Description = Description;
        return NEW;
    }

    public RecipeTemplate setFlags(String[] Flags) {
        RecipeTemplate NEW = this.clone();
        NEW.Flags = Flags;
        return NEW;
    }

    public RecipeTemplate setFlagSettings(Map<String, String> FlagSettings) {
        RecipeTemplate NEW = this.clone();
        NEW.FlagSettings = FlagSettings;
        return NEW;
    }

    public RecipeTemplate setParentOfThis(Reg<Recipe> ParentOfThis) {
        RecipeTemplate NEW = this.clone();
        NEW.ParentOfThis = ParentOfThis;
        return NEW;
    }

    public RecipeTemplate setInput(Item[] Input) {
        RecipeTemplate NEW = this.clone();
        NEW.Input = Input;
        return NEW;
    }

    public RecipeTemplate setOutput(Item[] Output) {
        RecipeTemplate NEW = this.clone();
        NEW.Output = Output;
        return NEW;
    }

    public RecipeTemplate setInputFun(Runnable InputFun) {
        RecipeTemplate NEW = this.clone();
        NEW.InputFun = InputFun;
        return NEW;
    }

    public RecipeTemplate setOutputFun(Runnable OutputFun) {
        RecipeTemplate NEW = this.clone();
        NEW.OutputFun = OutputFun;
        return NEW;
    }

    public RecipeTemplate setBindedMachine(Machine BindedMachine) {
        RecipeTemplate NEW = this.clone();
        NEW.BindedMachine = BindedMachine;
        return NEW;
    }

}