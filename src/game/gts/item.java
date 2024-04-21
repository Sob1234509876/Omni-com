package game.gts;

import java.util.*;

import game.utils.*;
import game.utils.templates.*;

public class Item {

    public String Name;
    public String Description;
    public String[] Flags;
    public Map<String, String> FlagSettings;
    public Reg<Item> ParentOfThis;

    public static Item valueOf(ItemTemplate IF) {
        Item tmp = new Item();

        tmp.Name = IF.Name;
        tmp.Description = IF.Description;
        tmp.Flags = IF.Flags;
        tmp.FlagSettings = IF.FlagSettings;
        tmp.ParentOfThis = IF.ParentOfThis;

        return tmp;
    }

}
