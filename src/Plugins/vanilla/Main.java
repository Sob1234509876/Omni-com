package Plugins.vanilla;

import java.util.HashMap;
import java.util.Map;

import Codes.Factories.itemFactory;
import Codes.GameTypes.item;

import Codes.Main.mainScript;

public class Main {
    
    public static void main(String[] args) {

        String[] tFlags = {"DEADLY"};
        Map<String, String> tFlagSettings = new HashMap<>();

        tFlagSettings.put("DEADLY", "114514");

        item singularity = mainScript.Items.get(new itemFactory()
        .setName("singularity")
        .setDescription("You`re holding a black hole (")
        .setFlags(tFlags)
        .setFlagSettings(tFlagSettings)
        .register());
    }

}
