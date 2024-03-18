package src.gts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.utils.factories.itemFactory;

/**
 * {@code material} class, use for making formatted items
 * <p>
 * example : Cyberium plate & Cyberium screw; Sodium ingot & Sodium dust
 */

public class material {

    public String name;
    public String color;
    public String chemFormula;
    public material[] component;
    public element[] elements;

    public String[] flags;
    public Map<String, String> flagSettings = new HashMap<String, String>();
    public Map<String, Integer> createdItemsID = new HashMap<String, Integer>();

    public long amount = 0;

    public material(
            String name,
            String color,
            material[] component,
            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.color = color;
        this.component = component;
        this.flags = flags;
        this.flagSettings = flagSettings;

        for (material matter : component) {
            this.chemFormula += "(" + matter.chemFormula + ")" + matter.amount;
        }
    }

    public material(
            String name,
            String color,
            element[] elements,
            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.color = color;
        this.elements = elements;
        this.flags = flags;
        this.flagSettings = flagSettings;

        for (element element : elements) {
            this.chemFormula += element.chemSymbol + element.amount;
        }

    }

    /**
     * Peice of junk
     */

    public void registerItems(String[] flags, Map<String, String> flagSettings) {

        boolean fuel = false;
        boolean RAD = false;
        boolean solid = true;
        List<String> TFlags = new ArrayList<String>();
        Map<String, String> TMap = new HashMap<String, String>();
        int ID;

        for (String flag : flags) {

            if (fuel) {
                TFlags.add("FUEL");
                TMap.put("FUEL", this.flagSettings.get("FUEL"));
            }

            if (RAD) {
                TFlags.add("RAD");
                TMap.put("RAD", this.flagSettings.get("RAD"));
            }

            if (flag.equals("DECREATE"))
                break;

            if (flag.equals("LIQUID")) {
                solid = false;
            }

            if (solid) { // Create solid stuffs

                if (flag.equals("GENERATE_PLATE"))

                    ID = new itemFactory()
                            .setName(String.format("%s plate", name))
                            .setDescription(String.format("%s\n%s\n%s RAD/s", this.chemFormula, this.name))
                            .setFlags((String[]) (TFlags.toArray()))
                            .register();

                else if (flag.equals("GENERATE_PLATE_DENSE"))

                    ID = new itemFactory()
                            .setName(String.format("%s plate", name))
                            .setDescription(String.format("%s\n%s\n%s RAD/s", this.chemFormula, this.name))
                            .setFlags((String[]) (TFlags.toArray()))
                            .register();

                else if (flag.equals("GENERATE_FOIL"))

                    ID = new itemFactory()
                            .setName(String.format("%s foil", name))
                            .setDescription(String.format("%s\n%s\n%s RAD/s", this.chemFormula, this.name))
                            .setFlags((String[]) (TFlags.toArray()))
                            .register();

                else if (flag.equals("GENERATE_ROD"))

                    ID = new itemFactory()
                            .setName(String.format("%s rod", name))
                            .setDescription(String.format("%s\n%s\n%s RAD/s", this.chemFormula, this.name))
                            .setFlags((String[]) (TFlags.toArray()))
                            .register();

                else if (flag.equals("GENERATE_WIRE"))

                    ID = new itemFactory()
                            .setName(String.format("%s wire", name))
                            .setDescription(String.format("%s\n%s\n%s RAD/s", this.chemFormula, this.name))
                            .setFlags((String[]) (TFlags.toArray()))
                            .register();

                else if (flag.equals("GENERATE_WIRE_THIN"))

                    ID = new itemFactory()
                            .setName(String.format("%s thin wire", name))
                            .setDescription(String.format("%s\n%s\n%s RAD/s", this.chemFormula, this.name))
                            .setFlags((String[]) (TFlags.toArray()))
                            .register();

                else if (flag.equals("GENERATE_COIL"))

                    ID = new itemFactory()
                            .setName(String.format("%s coil", name))
                            .setDescription(String.format("%s\n%s\n%s RAD/s", this.chemFormula, this.name))
                            .setFlags((String[]) (TFlags.toArray()))
                            .register();

                else if (flag.equals("GENERATE_BOUL"))

                    ID = new itemFactory()
                            .setName(String.format("%s doped silicon boule", name))
                            .setDescription(String.format("%s\n%s\n%s RAD/s", this.chemFormula, this.name))
                            .setFlags((String[]) (TFlags.toArray()))
                            .register();

            }

        }
    }

}
