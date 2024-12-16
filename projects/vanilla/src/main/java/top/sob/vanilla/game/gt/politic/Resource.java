package top.sob.vanilla.game.gt.politic;

import top.sob.core.api.devTools.DynamicGInstance;
import top.sob.core.proof.Modifiable;
import top.sob.vanilla.game.gt.Player;
import top.sob.vanilla.utils.misc.Range;

import java.util.Date;
import java.util.Set;

public interface Resource extends DynamicGInstance {

    Range<Date> getSuggestedExistDate();

    boolean isOwned();

    @Modifiable
    Set<Player> getOwner();

}
