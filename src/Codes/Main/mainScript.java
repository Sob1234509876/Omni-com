package Codes.Main;

//Tools
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;

import Codes.Listeners.CloseWindow;
import Codes.Listeners.KeyDetect;
import Codes.Utils.Output;
import Codes.GameTypes.element;
import Codes.GameTypes.fluid;
import Codes.GameTypes.item;
import Codes.GameTypes.machine;
import Codes.GameTypes.material;
import Codes.GameTypes.recipe;

//Paths
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;

//GUI
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

import java.awt.Font;
import java.awt.Color;

public class mainScript {

    public volatile static Map<Integer, item> Items = new HashMap<Integer, item>();
    public volatile static Map<Integer, fluid> Fluids = new HashMap<Integer, fluid>();
    public volatile static Map<Integer, material> Materials = new HashMap<Integer, material>();
    public volatile static Map<Integer, element> Elements = new HashMap<Integer, element>();
    public volatile static Map<Integer, recipe> Recipe = new HashMap<Integer, recipe>();
    public volatile static Map<Integer, machine> Machine = new HashMap<Integer, machine>();

    public volatile static Properties settings = new Properties();
    public volatile static Properties langSettings = new Properties();

    public static void main(String[] args) throws IOException {

        Path gamePath = Paths.get("").toAbsolutePath();
        Output.log(String.format("Founded gamePath : %s", gamePath));

        Path srcPath = Paths.get(gamePath.toString(), "src");
        Output.log(String.format("Founded srcPath : %s", srcPath));

        Path codesPath = Paths.get(srcPath.toString(), "Codes");
        Output.log(String.format("Founded codesPath : %s", codesPath));

        Path configsPath = Paths.get(srcPath.toString(), "Configs");
        Output.log(String.format("Founded configsPath : %s", configsPath));

        Path pluginsPath = Paths.get(srcPath.toString(), "Plugins");
        Output.log(String.format("Founded pluginsPath : %s", pluginsPath));

        Path resourcePath = Paths.get(srcPath.toString(), "Resource");
        Output.log(String.format("Founded resourcePath : %s", resourcePath));

        Path savesPath = Paths.get(srcPath.toString(), "Saves");
        Output.log(String.format("Founded savePath : %s", savesPath));

        // Path Init

        settings.load(new FileReader(Paths.get(configsPath.toString(), "Settings.properties").toString()));
        Output.log("Settings loaded");

        String langauge = settings.getProperty("lang");
        String debug = settings.getProperty("debug");
        Output.log(String.format("Settings : \ndebug = %s\nlang = %s\n", debug, langauge));

        langSettings.load(new FileReader(Paths.get(resourcePath.toString(), langauge + ".lang").toString()));
        Output.log("Language settings loaded");

        // Setting init

        Frame frame = new Frame(langSettings.getProperty("frameTitle"));
        frame.setSize(1000, 800);
        frame.setBackground(new Color(128, 128, 128));
        frame.setLayout(null);
        frame.setFocusable(true);
        frame.addWindowListener(new CloseWindow());

        Output.log("Created Frame");

        // Frame Init

        Panel panel = new Panel();
        panel.setBounds(50, 50, 900, 700);
        panel.setBackground(new Color(100, 100, 100));

        Output.log("Created Panel");

        // Panel Init

        TextField txt = new TextField(langSettings.getProperty("frameText"));
        txt.setFont(new Font("宋体", Font.PLAIN, 80));
        txt.setEditable(false);
        txt.addKeyListener(new KeyDetect());

        Output.log("Created TextField");

        // Text Init

        panel.add(txt);
        frame.add(panel);

        Output.log("Added components to input frame");

        // Throw everything together.

        frame.setVisible(true);
        Output.log("Frame visible");

        // Use plugins

        File[] plugins = pluginsPath.toFile().listFiles();

        // Filter plugins

        for (File plugin : plugins) {
            if (plugin.toPath().toString().split(".")[0] == "jar") {
                Process cmd = Runtime.getRuntime().exec("java -jar \"" + plugin.toPath().toString() + "\"");
                try {
                    cmd.waitFor();
                    cmd.destroy();
                    // Run jar
                } catch (Exception e) {
                    Output.log("Plugin " + plugin + " : " + e.toString());
                }
            }
        }

    }

}
