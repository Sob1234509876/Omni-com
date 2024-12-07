package top.sob.core.models.translation;

import top.sob.core.Meta;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public interface DecoratedDict extends Dictionary {

    default void load(Map<String, String> dict) {
        putAll(dict);
    }

    default void load(Reader reader) throws IOException {

        var p = new Properties();
        p.load(reader);

        var tmp = new HashMap<String, String>();

        p.forEach((K, V) -> tmp.put(K.toString(), V.toString()));

        load(tmp);
    }

    default void load(InputStream inputStream, Charset charset) throws IOException {
        load(new InputStreamReader(inputStream, charset));
    }

    default void load(InputStream inputStream) throws IOException {
        load(inputStream, Meta.DEF_CHARSET);
    }

    default void load(URL url, Charset charset) throws IOException {
        load(url.openStream(), charset);
    }

    default void load(URL url) throws IOException {
        load(url.openStream());
    }

}
