package src.gts;

import java.io.File;
import java.util.Map;

import src.utils.reg;
import src.utils.factories.ItemFactory;
import src.main.Main;

public class item {

    public String Name;
    public String Description;
    public String[] Flags;
    public Map<String, String> FlagSettings;
    public reg<item> ParentOfThis;
    public File DesPath;

    public void InitMDPath() throws NullPointerException {
        try {
            this.DesPath = new File(Main.RESOURCE_PATH, this.Name + ".des");
        } catch (NullPointerException e) {
            throw new NullPointerException("ParentOfThis un-initilize.");
        }
    }

    public static item valueOf(ItemFactory IF) {
        item tmp = new item();

        tmp.Name = IF.Name;
        tmp.Description = IF.Description;
        tmp.Flags = IF.Flags;
        tmp.FlagSettings = IF.FlagSettings;
        tmp.ParentOfThis = IF.ParentOfThis;

        return tmp;
    }

}
