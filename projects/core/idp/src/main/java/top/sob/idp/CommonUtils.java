package top.sob.idp;

import org.gradle.api.Project;
import org.gradle.api.artifacts.dsl.RepositoryHandler;

public final class CommonUtils {

    private CommonUtils() {
    }

    public static void setMaven(Project p, String uri) {
        p.getRepositories().maven(r -> r.setUrl(p.uri(uri)));
    }

    public static void setMaven(Project p, RepositoryHandler r, String uri) {
        r.maven(r2 -> r2.setUrl(p.uri(uri)));
    }

}
