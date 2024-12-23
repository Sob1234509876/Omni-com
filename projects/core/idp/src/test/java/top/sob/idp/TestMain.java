package top.sob.idp;

import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestMain {

    static {
        System.getProperties().put("test", "true");
    }

    public static final String GUH_STR = System.getenv("GRADLE_USER_HOME");
    public static final File GUH_FILE = new File(GUH_STR);

    @Test
    public void test0() {

        var prj = ProjectBuilder.builder()
                .withName("test")
                .withGradleUserHomeDir(GUH_FILE).build();
        prj.getPlugins().apply(Main.class);

        Assertions.assertTrue(prj.getPlugins().hasPlugin("java"));
        Assertions.assertTrue(prj.getPlugins().hasPlugin("java-library"));
        Assertions.assertTrue(prj.getPlugins().hasPlugin("maven-publish"));
//        Assertions.assertTrue(prj.getPlugins().hasPlugin("org.jetbrains.kotlin.jvm"));

    }

}
