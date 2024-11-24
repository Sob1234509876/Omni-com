package top.sob.vanilla.api.game.trans;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OperationTemplateImpl extends OperationTemplate {

    private final Map<String, Parameter> PARS = new HashMap<>();

    @SuppressWarnings("unused")
    public OperationTemplateImpl(Parameter[] parameters) {
        Arrays.stream(parameters).forEach(parameter -> PARS.put(parameter.getName(), parameter));
    }

    @Override
    public Parameter forName(String name) {
        return PARS.get(name);
    }

    @Override
    public Parameter[] getParameters() {
        return PARS.values().toArray(new Parameter[0]);
    }
}
