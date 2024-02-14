package Codes.GameTypes;

import java.util.HashMap;
import java.util.Map;

public class material {

    public String name;
    public String color;
    public String chemFormula;
    public material[] component;
    public element[] elements;

    public String[] flags;
    public Map<String, String> flagSetting = new HashMap<String, String>();
    public Map<String, Integer> createdItemsID = new HashMap<String, Integer>();

    public long amount;

}
