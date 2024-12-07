package top.sob.core.models.translation;

import java.util.Locale;
import java.util.Map;

public interface Dictionary extends Map<String, String> {

    Locale getLocale();

}
