package top.sob.core.models.translation.zhCn;

import org.jetbrains.annotations.Unmodifiable;
import top.sob.core.models.translation.Dictionary;
import top.sob.core.models.translation.Translator;

import java.util.Locale;
import java.util.Set;

public class ZhCnTranslator implements Translator {

    private static final Set<Locale> INPUTS = Set.of(Locale.ENGLISH);
    private static final ZhCnTranslator INSTANCE = new ZhCnTranslator();

    private ZhCnTranslator() {
    }

    public static ZhCnTranslator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean supportSyntaxCheck() {
        return false;
    }

    @Override
    public boolean supportIsLangCheck() {
        return true;
    }

    @Override
    public @Unmodifiable Set<Throwable> syntaxCheck(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isLang(String s) {
        return false;
    }

    @Override
    public @Unmodifiable Set<Character> strictLanguageWords() {
        return null;
    }

    @Override
    public @Unmodifiable Set<Locale> allowedInputLanguage() {
        return INPUTS;
    }

    @Override
    public @Unmodifiable Locale getLanguage() {
        return Locale.SIMPLIFIED_CHINESE;
    }

    @Override
    public @Unmodifiable Dictionary getDictionary() {
        return ZhCnDictionary.getInstance();
    }

    @Override
    public String translate(String string) {
        return getDictionary().get(string);
    }
}
