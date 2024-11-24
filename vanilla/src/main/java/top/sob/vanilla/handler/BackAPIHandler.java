package top.sob.vanilla.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import org.apache.log4j.Logger;

import top.sob.vanilla.event.ServerEvent;
import top.sob.vanilla.event.ServerEventBus;
import top.sob.vanilla.api.game.trans.OperationElement;
import top.sob.vanilla.api.game.trans.Response;
import top.sob.vanilla.event.ServerEvents;
import top.sob.vanilla.util.GameBaseProvider;
import top.sob.vanilla.util.RandomUtil;

import java.io.IOException;

import static top.sob.vanilla.util.HttpUtil.handleIllegal;
import static top.sob.vanilla.util.HttpUtil.readFromExchange;
import static top.sob.vanilla.util.HttpUtil.writeToExchange;

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

            ServerEventBus.getEventBus()
                    .post(
                            new ServerEvent<>(
                                    ServerEvents.ReceiveCmd,
                                    operation)); // Fire event

            var response = GameBaseProvider.getDefaultProvider()
                    .getLogic()
                    .actToOperation(
                            RandomUtil.requireInstanceOf(
                                    operation.getBody(),
                                    OperationElement[].class));

            writeToExchange(exchange, RandomUtil.requireInstanceOf(response, Response.class));

        } catch (Exception e) {
            LOGGER.error("Exception detected during back handling:", e);
            // Curse the executors, it never showed up any exception stuff and I wasted
            // about 1 hour.
            throw new IOException(e);
        }

    }

}
