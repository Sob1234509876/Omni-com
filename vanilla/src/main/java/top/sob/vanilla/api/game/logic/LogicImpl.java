package top.sob.vanilla.api.game.logic;

import top.sob.vanilla.api.game.trans.OperationElement;

import java.util.Date;

public class LogicImpl implements Logic {

    public static final LogicImpl INSTANCE = new LogicImpl();

    private LogicImpl() {
    }

    @Override
    public Object actToOperation(OperationElement[] elements) {

        if (elements.length < 1)
            throw new ArrayStoreException("Array length lesser than 1.");

        switch (CMD.valueOf(elements[0].getName())) {
            case TEST -> {
                return "Oh, hi!";
            }

            case TIME -> {
                return new Date(System.currentTimeMillis());
            }
        }

        return "";
    }

    @SuppressWarnings("unused")
    public enum CMD {
        TIME, TEST
    }

}
