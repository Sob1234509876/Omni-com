package top.sob.core.utils;

import top.sob.core.models.translation.Translator;

public final class TranslationUtils {

    private TranslationUtils() {
    }

    public static final String TERMINAL_NAME = Translator.getDefTranslator().translate("Omni com | Terminal");
    public static final String INFO_NAME = Translator.getDefTranslator().translate("Omni com | Info");

}
