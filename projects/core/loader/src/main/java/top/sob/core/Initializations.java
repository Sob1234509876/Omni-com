package top.sob.core;

import java.io.IOException;
import java.io.File;

import java.nio.file.Paths;
import java.util.Locale;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.FileAppender;

import top.sob.proof.Static;

import top.sob.core.api.Plugins;
import top.sob.core.utils.misc.Wrapper;

import top.sob.core.loading.CoreLoader;
import top.sob.core.utils.models.transform.Transformer;

import top.sob.core.utils.ArrayUtils;
import top.sob.core.utils.CommonUtils;

import top.sob.core.api.Meta;

@Static
final class Initializations {

    private Initializations() {
    }

    static void initDirs() {

        var saves = Paths.get(Meta.getSavesUri());
        var conf = Paths.get(Meta.getConfigsUri());
        var repos = Paths.get(Meta.getReportsUri());
        // Some folder files

        saves.toFile().mkdirs();
        conf.toFile().mkdirs();
        repos.toFile().mkdirs();

        for (var uri : Meta.getPluginsUri()) {
            if (uri.getScheme().equals("file")) {
                Paths.get(uri).toFile().mkdirs();
            }
        }

        // Make folder

    }

    static void initLogger() throws IOException {

        if (new File(Meta.getReportsUri()).createNewFile()) {
            Main.LOGGER.info("Report file created");
        }

        Main.LOGGER.addAppender(
                new FileAppender(
                        CommonUtils.DefLayout.getInstance(),
                        Meta.getReportUri().getPath())); // Add appender

    }

    static void initReflect() {

        var urls = ArrayUtils.Specific
                .castArray(Meta.getPluginsUri());

        var tUrls = Transformer.getDefault().transform(urls);

        @SuppressWarnings("resource")
        var loader = new CoreLoader(tUrls);
        var ids = loader.getAllFoundedID();
        var wrapper = (Wrapper<Class<?>>) null;

        for (String id : ids) {
            wrapper = loader.loadWrappedClass(id);
            Plugins.register(wrapper);
        }

    }

    static void initUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Long names

    }

    static void initMeta() {

        System.getProperties().put(Meta.CORE_CLASS_LOADER_KEY, Main.class.getClassLoader());
        System.getProperties().put(Meta.LANG_KEY, new Locale(Main.getOptSet().valueOf("").toString())); //TODO
    }

}
