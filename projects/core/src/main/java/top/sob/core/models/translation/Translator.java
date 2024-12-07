package top.sob.core.models.translation;

import org.jetbrains.annotations.Unmodifiable;
import top.sob.core.Meta;
import top.sob.core.models.translation.enUs.EnUsTranslator;
import top.sob.core.models.translation.zhCn.ZhCnTranslator;

import java.util.*;

public interface Translator {

    boolean supportSyntaxCheck();

    boolean supportIsLangCheck();

    @Unmodifiable
    Set<Throwable> syntaxCheck(String s);

    boolean isLang(String s);

    @Unmodifiable
    Set<Character> strictLanguageWords();

    @Unmodifiable
    Set<Locale> allowedInputLanguage();

    @Unmodifiable
    Locale getLanguage();

    @Unmodifiable
    Dictionary getDictionary();

    String translate(String string);

    @Unmodifiable
    static Set<Translator> getAvailableTranslators() {
        return Set.of(EnUsTranslator.getInstance(), ZhCnTranslator.getInstance());
    }

    static Translator getDefTranslator() {
        switch (Meta.LANGUAGE.toUpperCase()) {
            case "ZH_CN" -> {
                return ZhCnTranslator.getInstance();
            }

            case "EN_US" -> {
                return EnUsTranslator.getInstance();
            }

            default ->
                    throw new IllegalArgumentException("Illegal or unsupported core argument \"lang\" (Current: " + Meta.LANGUAGE + ").");

        }
    }

}
