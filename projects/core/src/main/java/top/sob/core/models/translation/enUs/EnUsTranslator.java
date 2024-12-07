package top.sob.core.models.translation.enUs;

import org.jetbrains.annotations.Unmodifiable;
import top.sob.core.models.translation.Dictionary;
import top.sob.core.models.translation.Translator;

import java.util.*;

public class EnUsTranslator implements Translator {

    private static final Set<Character> ASCII_CHARS;
    private static final Set<Locale> INPUTS = Set.of(Locale.ENGLISH);
    private static final EnUsTranslator INSTANCE = new EnUsTranslator();

    private EnUsTranslator() {
    }

    static {

        var tmp = new HashSet<Character>();

        for (int i = 0; i < 128; i++) {
            tmp.add((char) i);
        }

        ASCII_CHARS = Collections.unmodifiableSet(tmp);
    }

    public static EnUsTranslator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean supportSyntaxCheck() {
        return false;
    }

    @Override
    public boolean supportIsLangCheck() {
        return false;
    }

    @Override
    public @Unmodifiable Set<Throwable> syntaxCheck(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isLang(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public @Unmodifiable Set<Character> strictLanguageWords() {
        return ASCII_CHARS;
    }

    @Override
    public @Unmodifiable Set<Locale> allowedInputLanguage() {
        return INPUTS;
    }

    @Override
    public @Unmodifiable Locale getLanguage() {
        return Locale.ENGLISH;
    }

    @Override
    public @Unmodifiable Dictionary getDictionary() {
        throw new UnsupportedOperationException("I don`t need a dictionary, just ctrl-c & v.");
    }

    @Override
    public String translate(String string) {
        return string;
    }
}
