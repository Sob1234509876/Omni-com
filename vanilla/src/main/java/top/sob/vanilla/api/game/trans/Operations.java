package top.sob.vanilla.api.game.trans;

public final class Operations {

    private Operations() {
    }

    @SuppressWarnings("unused")
    public static OperationTemplate createTemplate(Parameter[] parameters) {
        return new OperationTemplateImpl(parameters);
    }

}
