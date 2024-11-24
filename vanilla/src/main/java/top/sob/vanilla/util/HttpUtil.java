package top.sob.vanilla.util;

import com.sun.net.httpserver.HttpExchange;
import org.apache.log4j.Logger;
import top.sob.vanilla.api.game.trans.Operation;
import top.sob.vanilla.api.game.trans.Response;
import top.sob.vanilla.util.serialize.Serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Objects;

import static top.sob.core.api.Meta.DEF_CHARSET;

public final class HttpUtil {

    public static final int DEF_BUFFER_SIZE = 8192;
    public static final int DEF_TIMEOUT = 4096;
    public static final Serializer DEF_SERIALIZER = Serializer.getBuilderForName("IO").build();

    private static final Logger LOGGER = Logger.getLogger(HttpUtil.class);

    private HttpUtil() {
    }

    /**
     * Handles illegal requests. E.x requests using GET or other methods.
     *
     * @param exchange The illegal exchange.
     * @throws IOException See {@link HttpExchange}.
     */
    public static void handleIllegal(HttpExchange exchange) throws IOException {

        Objects.requireNonNull(exchange);

        LOGGER.info(String.format("Invalid request from %s using %s.", exchange.getRemoteAddress(), exchange.getRequestMethod()));
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_METHOD, 0);
    }

    // Sends the string (decoded with the default charset) from the static register
    // api thing.
    public static void writeToExchange(HttpExchange exchange, Response<?> response) throws IOException {

        Objects.requireNonNull(exchange);
        Objects.requireNonNull(response);

        var data = DEF_SERIALIZER.writeObject(response);

        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, data.length);
        exchange.getResponseHeaders().add("Content-Type", "application/jsonBuilder; charset=" + DEF_CHARSET.name());
        OutputStream os = exchange.getResponseBody();
        os.write(data);
        os.flush();
        os.close();

    }

    // Just reads all the data from the exchange and decodes (Also replaces all the
    // nulls in the decoded string).
    public static Operation<?> readFromExchange(HttpExchange exchange) throws IOException {

        Objects.requireNonNull(exchange);

        return (Operation<?>) DEF_SERIALIZER.readObject(exchange.getRequestBody().readAllBytes());

    }

    public static void writeToConn(HttpURLConnection conn, Operation<?> operation) throws IOException {

        Objects.requireNonNull(conn);
        Objects.requireNonNull(operation);

        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setConnectTimeout(DEF_TIMEOUT);
        conn.setReadTimeout(DEF_TIMEOUT);

        conn.setInstanceFollowRedirects(true);

        conn.getOutputStream().write(DEF_SERIALIZER.writeObject(operation));
        conn.getOutputStream().flush();

    }

    public static Response<?> readFromConn(HttpURLConnection conn) throws IOException {
        return (Response<?>) DEF_SERIALIZER.readObject(conn.getInputStream().readAllBytes());
    }
}
