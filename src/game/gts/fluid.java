package game.gts;

import game.utils.reg;
import game.utils.templates.FluidTemplate;

/**
 * 
 */

public class fluid extends item {

    public String Color;
    public material[] Component;
    public element[] Elements;
    public long Temperature;
    public String ChemFormula;
    public reg<fluid> ParentOfThis;

    public void loadChemFormula() {
        if (this.Component == null) {
            for (element e : this.Elements) {
                this.ChemFormula += e.ChemSymbol + element.ChemNumbers[e.Amount.intValue()];
            }
        } else {
            for (material m : this.Component) {
                this.ChemFormula += String.format("(%s%c)", m.Name, element.ChemNumbers[m.Amount.intValue()]);
            }
        }
    }

    public static fluid valueOf(FluidTemplate FF) {
        fluid tmp = new fluid();
        tmp.Name = FF.Name;
        tmp.Description = FF.Description;
        tmp.Flags = FF.Flags;
        tmp.FlagSettings = FF.FlagSettings;
        tmp.ParentOfThis = FF.ParentOfThis;

        tmp.Color = FF.Color;
        tmp.Temperature = FF.Temperature;

        if (FF.Component == null) {
            tmp.Component = FF.Component;
        } else {
            tmp.Elements = FF.Elements;
        }

        return tmp;
    }

}
