package top.sob.vanilla.game.storage;

import top.sob.vanilla.game.gt.abs.Placeable;
import top.sob.vanilla.proof.WIPException;

import java.util.HashMap;
import java.util.Map;

public class GameWideMap extends HashMap<Map.Entry<Integer, Integer>, Placeable> {

    public GameWideMap() {
        throw new WIPException();
    }

}
