package top.sob.vanilla.handler;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import static top.sob.vanilla.Main.LOGGER;

public class DefUEHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        LOGGER.callAppenders(new LoggingEvent(LOGGER.getClass().getName(),
                LOGGER,
                System.currentTimeMillis(),
                Level.FATAL,
                "Something EXTREMELY FATAL happened:",
                t.getName(),
                new ThrowableInformation(e),
                null,
                new LocationInfo(e, e.getStackTrace()[0].getClassName()),
                null));

        System.exit(1);

    }

}
