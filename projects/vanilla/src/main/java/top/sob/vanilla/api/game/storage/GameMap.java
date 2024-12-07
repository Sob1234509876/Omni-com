package top.sob.vanilla.api.game.storage;

import top.sob.vanilla.api.game.gt.Placeable;
import top.sob.vanilla.exceptions.proof.WIPException;

import java.util.HashMap;
import java.util.Map;

public class GameMap extends HashMap<Map.Entry<Integer, Integer>, Placeable> {

    public GameMap() {
        throw new WIPException();
    }

}
