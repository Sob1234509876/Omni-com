package top.sob.idp;

import org.gradle.api.Project;
import org.gradle.api.artifacts.dsl.RepositoryHandler;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.javadoc.Javadoc;
import org.gradle.jvm.toolchain.JavaLanguageVersion;
import org.jetbrains.annotations.NotNull;
import top.sob.idp.mirrors.Mirror;
import top.sob.idp.mirrors.ZhCnMirror;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public final class Initializations {

    private Initializations() {
    }

    public static void initRepositories(Project p) {
        addMirrorsToRepo(p, ZhCnMirror.getInstance());

        p.getRepositories().mavenLocal();
    }

    public static void initPlugins(Project p) {

        p.getPlugins().apply("java");
        p.getPlugins().apply("java-library");
        p.getPlugins().apply("maven-publish");

        initJava(p);
        initJavadoc(p);
    }

    public static void initDependencies(@NotNull Project p) {

        Objects.requireNonNull(p);

        if (!Boolean.parseBoolean(System.getProperty("test"))) {
            p.getDependencies().add("implementation", p.project(":projects:core:proof"));
            p.getDependencies().add("implementation", p.project(":projects:core:api"));
        }
    }

    public static void initJavadoc(@NotNull Project p) {

        Objects.requireNonNull(p);

        var javadoc = p.getTasks().findByName("javadoc");

        if (javadoc instanceof Javadoc) {
            var opts = ((Javadoc) javadoc).getOptions();

            opts.encoding(StandardCharsets.UTF_8.name());
            opts.verbose();
        }

    }

    public static void initJava(@NotNull Project p) {

        Objects.requireNonNull(p);

        var j = (JavaPluginExtension) p.getExtensions().findByName("java");

        if (j != null) j.toolchain(t -> t.getLanguageVersion().set(JavaLanguageVersion.of(17)));
    }

    public static void addMirrorsToRepo(@NotNull Project p, @NotNull Mirror m) {
        addMirrorsToRepo(p, p.getRepositories(), m);
    }

    public static void addMirrorsToRepo(@NotNull Project p, @NotNull RepositoryHandler rh, @NotNull Mirror m) {

        Objects.requireNonNull(p);
        Objects.requireNonNull(rh);
        Objects.requireNonNull(m);

        m.forEach(s -> CommonUtils.setMaven(p, rh, s));
    }


}
