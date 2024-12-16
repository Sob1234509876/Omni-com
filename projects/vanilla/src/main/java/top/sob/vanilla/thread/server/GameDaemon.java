package top.sob.vanilla.thread.server;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.sob.vanilla.proof.WIPException;

public class GameDaemon extends Thread {


    private static final Logger LOGGER = Logger.getLogger(GameDaemon.class);

    {
        setDaemon(true);

        LOGGER.fatal("WIP :", new WIPException());
    }

    public GameDaemon() {
    }

    public GameDaemon(Runnable target) {
        super(target);
    }

    public GameDaemon(@Nullable ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public GameDaemon(@NotNull String name) {
        super(name);
    }

    public GameDaemon(@Nullable ThreadGroup group, @NotNull String name) {
        super(group, name);
    }

    public GameDaemon(Runnable target, String name) {
        super(target, name);
    }

    public GameDaemon(@Nullable ThreadGroup group, Runnable target, @NotNull String name) {
        super(group, target, name);
    }

    public GameDaemon(@Nullable ThreadGroup group, Runnable target, @NotNull String name, long stackSize) {
        super(group, target, name, stackSize);
    }

    public GameDaemon(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
        super(group, target, name, stackSize, inheritThreadLocals);
    }
}
