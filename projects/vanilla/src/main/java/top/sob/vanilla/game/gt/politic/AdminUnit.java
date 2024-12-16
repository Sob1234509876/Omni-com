package top.sob.vanilla.game.gt.politic;

import top.sob.core.api.devTools.DynamicGInstance;

import java.util.Set;

public interface AdminUnit extends DynamicGInstance {

    Set<AdminUnit> getChildrenUnit();

    Set<Plot> getSupervisedPlots();

}
