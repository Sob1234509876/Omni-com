package top.sob.vanilla.api.game.gt;

import org.jetbrains.annotations.NotNull;
import top.sob.core.api.devTools.GInstance;
import top.sob.core.api.devTools.GTag;
import top.sob.vanilla.exceptions.proof.WIPException;

import javax.swing.*;
import java.math.BigDecimal;

public class Material extends GInstance {

    private final Material[] materials;
    private final String chemicalName;

    public Material(@NotNull GTag<?> body, Material[] materials, String specializedName) {
        super(body, specializedName);
        this.materials = materials;
        chemicalName = getChemicalString(materials, getAmount());
    }

    public static String getChemicalString(Material[] materials, BigDecimal amt) {
        var sb = new StringBuilder();
        var flag = amt.compareTo(BigDecimal.ONE) > 0;

        if (flag)
            sb.append('(');

        for (Material m : materials) {
            sb.append(m);
        }

        if (flag)
            sb.append(')').append(Element.toLoweredString(amt.toBigInteger()));

        return sb.toString();
    }

    @Override
    public String toString() {
        return getChemicalName();
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public Material[] getMaterials() {
        return materials;
    }

    @Override
    public Painter<GInstance> getPainter() {
        throw new WIPException();
    }
}
