package top.sob.idp;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

public class Main implements Plugin<Project> {

    @Override
    public void apply(@NotNull Project target) {
        Initializations.initPlugins(target);
        Initializations.initRepositories(target);
        Initializations.initDependencies(target);
    }

}
