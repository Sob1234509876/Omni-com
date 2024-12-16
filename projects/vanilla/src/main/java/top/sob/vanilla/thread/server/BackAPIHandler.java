package top.sob.vanilla.thread.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import org.apache.log4j.Logger;

import top.sob.vanilla.game.trans.Response;
import top.sob.vanilla.game.trans.abs.GameBaseProvider;
import top.sob.vanilla.utils.CommonUtils;

import java.io.IOException;

import static top.sob.vanilla.utils.HttpUtils.handleIllegal;
import static top.sob.vanilla.utils.HttpUtils.readFromExchange;
import static top.sob.vanilla.utils.HttpUtils.writeToExchange;

@SuppressWarnings("unused")
public class BackAPIHandler implements HttpHandler {

    private static final Logger LOGGER = Logger.getLogger(BackAPIHandler.class);

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            if (!exchange.getRequestMethod().equals("POST")) {
                handleIllegal(exchange);
                return;
            }

            var operation = readFromExchange(exchange);

            LOGGER.info(String.format("Read \"%s\" from client.", operation)); // Logs the data

            // Just inform other listeners from other plugins.
            ServerEventBus.getEventBus()
                    .post(
                            new ServerEvent<>(
                                    ServerEvents.ReceiveCmd,
                                    operation)); // Fire event

            var response = GameBaseProvider.getDefaultProvider()
                    .getLogic()
                    .actToOperation(operation);

            writeToExchange(exchange, CommonUtils.requireInstanceOf(response, Response.class));

        } catch (Exception e) {
            LOGGER.error("Exception detected during back handling:", e);
            // Curse the executors, it never showed up any exception stuff and I wasted
            // about 1 hour.
            throw new IOException("IDK :", e);
        }

    }

}
