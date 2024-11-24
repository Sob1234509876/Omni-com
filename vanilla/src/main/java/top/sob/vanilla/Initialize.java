package top.sob.vanilla;

import org.apache.log4j.Logger;
import top.sob.vanilla.thread.PreGameSolver;

public final class Initialize {

    public static final PreGameSolver PGS_THREAD = new PreGameSolver("PGS");
    public static final Logger LOGGER = Logger.getLogger(Initialize.class);

    private Initialize() {
    }

    public static void runGTInit() {
        LOGGER.info("Running GT Init");
    }

    public static void runGameLogicInit() {
        LOGGER.info("Running Game Logic Init");
        PGS_THREAD.start();
    }

}
