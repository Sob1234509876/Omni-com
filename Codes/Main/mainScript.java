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

import javax.swing.*;
import java.awt.*;

public class mainScript {

    public static final String __VERSION__ = "0.1a";
    public static final Path gamePath = Paths.get("").toAbsolutePath();
    public static final Path srcPath = Paths.get(gamePath.toString(), "src");
    public static final Path codesPath = Paths.get(srcPath.toString(), "Codes");
    public static final Path configsPath = Paths.get(srcPath.toString(), "Configs");
    public static final Path pluginsPath = Paths.get(srcPath.toString(), "Plugins");
    public static final Path resourcePath = Paths.get(srcPath.toString(), "Resource");
    public static final Path savesPath = Paths.get(srcPath.toString(), "Saves");

    public static JFrame GUI = new JFrame("Omni com. co., Ltd.");
    public static JTextArea Out = new JTextArea();
    public static JTextField In = new JTextField();

    public volatile static Map<Integer, item> Items = new HashMap<Integer, item>();
    public volatile static Map<Integer, fluid> Fluids = new HashMap<Integer, fluid>();
    public volatile static Map<Integer, material> Materials = new HashMap<Integer, material>();
    public volatile static Map<Integer, element> Elements = new HashMap<Integer, element>();
    public volatile static Map<Integer, recipe> Recipe = new HashMap<Integer, recipe>();
    public volatile static Map<Integer, machine> Machine = new HashMap<Integer, machine>();

    public static Properties settings = new Properties();
    public static Properties langSettings = new Properties();

    public static void main(String[] args) throws IOException {

        // Path Init

        settings.load(
                new FileReader(
                        Paths.get(
                                configsPath.toString(),
                                "mainScript.cfg")
                                .toString()));

        langSettings.load(
                new FileReader(
                        Paths.get(
                                resourcePath.toString(),
                                settings.getProperty("lang")
                                        + ".lang")
                                .toString()));
        Output.log("Language settings loaded");

        // Setting init

        init();

    }

    private static void init() {

        String[] tmp = settings.getProperty("GUI.size").split("x");

        GUI.setIconImage(
                new ImageIcon(
                        Paths.get(
                                resourcePath.toString(),
                                "icon.png").toString())
                        .getImage());
        GUI.setSize(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        GUI.setResizable(false);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);
    }

}
