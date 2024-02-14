package Codes.Factories;

import Codes.Main.mainScript;
import Codes.GameTypes.element;

/*
 * This is a factory for making elements, the default element "Nl" (Standing for NULL) has a atomic mass of 0 with 0 protons and neutrons (Which makes it not possible to exsist in real life, but this is a game)
 * Functions:
 *     elementFactory elementFactory.setAtomSymbol(String atomSymbol);
 *     elementFactory elementFactory.setProtonAmount(long protonAmount);
 *     elementFactory elementFactory.setNeutronAmount(long neutronAmount);
 *     element elementFactory.register();
 * 
 * Ex. :
 * element Carbon = elementFactory
 *     .setAtomSymbol("C")
 *     .setProtonAmount(6)
 *     .setNeutronAmount(6)
 *     .register();
 */

public class elementFactory implements factory{
    
    String atomSymbol = "Nl";
    long protonAmount = 0;
    long neutronAmount = 0;

    public elementFactory setAtomSymbol(String atomSymbol){this.atomSymbol = atomSymbol; return this;}
    public elementFactory setProtonAmount(long protonAmount){this.protonAmount = protonAmount; return this;}
    public elementFactory setNeutronAmount(long neutronAmount){this.neutronAmount = neutronAmount; return this;}

    public element register(){

        int ID = mainScript.Element.size();

        mainScript.Element.put(ID, new element(
            atomSymbol,
            protonAmount,
            neutronAmount
        ));

        return mainScript.Element.get(ID);
    }

    public element getProduct(){
        return new element(
            atomSymbol,
            protonAmount,
            neutronAmount
        );
    }

}
