package top.sob.vanilla.api.game.storage;

import top.sob.core.utils.SecurityUtils;
import top.sob.vanilla.api.game.gt.Player;

import java.util.HashSet;

public class Players extends HashSet<Player> {

    public static final Players INSTANCE = new Players();

    public static Players getInstance() {

        SecurityUtils.requireNonScriptInvoker();

        return INSTANCE;
    }

}
