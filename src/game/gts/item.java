package game.gts;

import java.util.*;

import game.utils.*;
import game.utils.templates.*;

public class item {

    public String Name;
    public String Description;
    public String[] Flags;
    public Map<String, String> FlagSettings;
    public reg<item> ParentOfThis;

    public static item valueOf(ItemTemplate IF) {
        item tmp = new item();

        tmp.Name = IF.Name;
        tmp.Description = IF.Description;
        tmp.Flags = IF.Flags;
        tmp.FlagSettings = IF.FlagSettings;
        tmp.ParentOfThis = IF.ParentOfThis;

        return tmp;
    }

}
