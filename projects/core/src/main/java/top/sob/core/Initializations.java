package top.sob.core;

import java.io.IOException;
import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.FileAppender;

import top.sob.core.proof.Static;

import top.sob.core.api.Plugins;
import top.sob.core.utils.misc.Wrapper;

import top.sob.core.loading.CoreLoader;
import top.sob.core.models.transform.Transformer;

import top.sob.core.utils.ArrayUtils;
import top.sob.core.utils.CommonUtils;

@SuppressWarnings("ResultOfMethodCallIgnored")
@Static
final class Initializations {

    private Initializations() {
    }

    static void run0() {

        var saves = Paths.get(Meta.getSavesUri());
        var plugs = new Path[Meta.getPluginsUri().length];
        var conf = Paths.get(Meta.getConfigsUri());
        var repos = Paths.get(Meta.getReportsUri());
        // Some folder files

        var coreCfg = Paths.get(conf.toString(), "core.cfg");

        saves.toFile().mkdirs();

        for (int i = 0; i < plugs.length; i++) {
            plugs[i] = Paths.get(Meta.getPluginsUri()[i]);
        }

        for (var p : plugs)
            p.toFile().mkdirs();

        conf.toFile().mkdirs();
        repos.toFile().mkdirs();
        // Make folder

    }

    static void run1() throws IOException {

        Main.LOGGER.debug(new File(Meta.getReportsUri()));

        if (new File(Meta.getReportsUri()).createNewFile()) {
            Main.LOGGER.info("Report file created");
        }

        Main.LOGGER.addAppender(
                new FileAppender(
                        CommonUtils.DefLayout.getInstance(),
                        Meta.getReportUri().getPath())); // Add appender

    }

    static void run2() {

        var urls = ArrayUtils.Specific
                .castArray(Meta.getPluginsUri());

        var tUrls = Transformer.getProvided().transform(urls);

        @SuppressWarnings("resource")
        var loader = new CoreLoader(tUrls);
        var ids = loader.getAllFoundedID();
        var wrapper = (Wrapper<Class<?>>) null;

        for (String id : ids) {
            wrapper = loader.loadWrappedClass(id);
            Plugins.register(wrapper);
        }

    }

    static void run3() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Long names

    }

}
