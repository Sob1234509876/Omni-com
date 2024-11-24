package top.sob.vanilla.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import static top.sob.vanilla.util.HttpUtil.DEF_BUFFER_SIZE;
import static top.sob.vanilla.Meta.*;

@SuppressWarnings("unused")
public class FrontHtmlHandler implements HttpHandler {

    private static final Logger LOGGER = Logger.getLogger(FrontHtmlHandler.class);

    public static final File HTML_INDEX_PATH = new File(TMP_FILE_DIR, INDEX_NAME);

    @Override
    public void handle(HttpExchange exchange) {

        try {

            InputStream is = new FileInputStream(HTML_INDEX_PATH);
            OutputStream os = exchange.getResponseBody();
            byte[] buffer = new byte[DEF_BUFFER_SIZE];
            int len;

            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, HTML_INDEX_PATH.length());
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");

            // I/O
            while ((len = is.read(buffer)) > 0) {
                os.write(buffer, 0, len); // Make sure no nulls are sent
            }

            is.close();
            exchange.close();

        } catch (Exception e) {
            LOGGER.error("Exception detected during front handling:", e);
            // Hope this thing would not throw any sort of exceptions, except internet
            // service problems.
            throw new RuntimeException(e);
        }

    }

}