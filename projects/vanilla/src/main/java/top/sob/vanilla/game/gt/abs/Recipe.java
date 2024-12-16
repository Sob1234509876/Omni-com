package top.sob.vanilla.game.gt.abs;

import org.jetbrains.annotations.Unmodifiable;
import top.sob.core.api.devTools.Amount;
import top.sob.core.api.devTools.GInstance;
import top.sob.vanilla.game.gt.resource.Item;

import java.util.Set;

public interface Recipe extends GInstance {

    Amount getDuration();

    @Unmodifiable
    Set<Item> getInput();

    @Unmodifiable
    Set<Item> getOutput();

}
