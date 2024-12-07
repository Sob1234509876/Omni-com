package top.sob.core.models.translation.zhCn;

import org.apache.log4j.Logger;
import top.sob.core.Meta;
import top.sob.core.exceptions.ResourceException;
import top.sob.core.models.translation.DecoratedDict;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

public class ZhCnDictionary extends HashMap<String, String> implements DecoratedDict {

    private static final ZhCnDictionary DICTIONARY = new ZhCnDictionary();
    private static final Logger LOGGER = Logger.getLogger(ZhCnDictionary.class);

    static {
        try {
            getInstance().load(
                    Objects.requireNonNull(
                            Meta.THIS_CLASS_LOADER
                                    .getResource("assets/lang/zh_cn.lang")));
        } catch (IOException e) {
            throw new ResourceException("IOException during <cinit>", e);
        }
    }

    private ZhCnDictionary() {
    }

    /**
     * Definitely nothing political
     */
    public static ZhCnDictionary getInstance() {
        return DICTIONARY;
    }

    @Override
    public Locale getLocale() {
        return Locale.SIMPLIFIED_CHINESE;
    }

    @Override
    public String get(Object key) {

        LOGGER.debug("Translate \"" + key + "\".");

        return super.get(key.toString().replace(' ', '_'));
    }
}
