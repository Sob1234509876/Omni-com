package top.sob.vanilla.utils;

import top.sob.core.exceptions.ResourceException;
import top.sob.core.models.translation.Translator;
import top.sob.core.models.translation.zhCn.ZhCnDictionary;
import top.sob.vanilla.Meta;

import java.io.IOException;
import java.util.Objects;

public final class TranslationUtils {

    private TranslationUtils() {
    }

    static {
        try {
            ZhCnDictionary.getInstance()
                    .load(
                            Objects.requireNonNull(
                                    Meta.THIS_CLASS_LOADER
                                            .getResource("assets/lang/zh_cn.lang")));
        } catch (IOException e) {
            throw new ResourceException(e);
        }
    }

    public static final String PICTURE_NAME = Translator.getDefTranslator().translate("Omni com | Image");
    public static final String HELP = Translator.getDefTranslator().translate("Help");
    public static final String HELP_CONTENT = Translator.getDefTranslator().translate("Not sure yet.");
    public static final String ASK_SAVE = Translator.getDefTranslator().translate("Enter the name of your save.");
    public static final String ASK_MODE = Translator.getDefTranslator().translate("Which mode are you playing? S for single-player and M for multi-player.");
    public static final String ASK_HOST = Translator.getDefTranslator().translate("Please enter the host name.");
    public static final String ASK_PORT = Translator.getDefTranslator().translate("Please enter the port(Default: %d).");
    public static final String UNKNOWN_CMD = Translator.getDefTranslator().translate("Unknown_command");

    public static final String BUY_CMD_NAME = Translator.getDefTranslator().translate("Buy");
    public static final String SELL_CMD_NAME = Translator.getDefTranslator().translate("Sell");
    public static final String USE_CMD_NAME = Translator.getDefTranslator().translate("Use");
    public static final String INFO_CMD_NAME = Translator.getDefTranslator().translate("Info");
    public static final String CHAT_CMD_NAME = Translator.getDefTranslator().translate("Chat");
}

