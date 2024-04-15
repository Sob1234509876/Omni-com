package vanilla;

import java.nio.file.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

import game.gui.listeners.*;

import game.main.*;

public class Play {

    public static void Start(Integer Mode) throws Exception {
        InitGUI();
    }
    public static void Start(Files Game) throws Exception {
        InitGUI();
    }

    /**
     * The init. part of the game, GUI and etc.
     * 
     * @throws Exception
     */
    private static void InitGUI() throws Exception {

        Main.GameFrame.add(Main.InTextArea );
        Main.GameFrame.add(Main.OutTextArea);
        // Add the input and output JTextPanel

        final Integer SIZ        = Integer.parseInt(Main.settings.getProperty("GUI.font_siz"));
        final Font    FONT       = new Font(Main.settings.getProperty("GUI.font"),Font.PLAIN,SIZ);
        final Color   BGCOLOR    = new Color(Integer.parseInt(Main.settings.getProperty("GUI.BGColor")), false);
        final Color   FGCOLOR    = new Color(Integer.parseInt(Main.settings.getProperty("GUI.FGColor")), false);
        final Integer GUI_WIDTH  = Integer.parseInt(Main.settings.getProperty("GUI.size").split("x")[0]);
        final Integer GUI_HEIGHT = Integer.parseInt(Main.settings.getProperty("GUI.size").split("x")[1]);
        final Border  BORDER     = BorderFactory.createMatteBorder(1, 1, 1, 1, FGCOLOR);

        // For quick access to gui configurations.

        vanilla.main.Main.GameFrame.setTitle                 (String.format(Main.langSettings.getProperty("title"), Main.__VERSION__));
        vanilla.main.Main.GameFrame.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        vanilla.main.Main.GameFrame.setLayout                (null);
        vanilla.main.Main.GameFrame.setIconImage             (game.main.Main.ICON);
        vanilla.main.Main.GameFrame.setSize                  (GUI_WIDTH, GUI_HEIGHT + 35);
        vanilla.main.Main.GameFrame.setResizable             (false);
        vanilla.main.Main.GameFrame.setLocationRelativeTo    (null);
        vanilla.main.Main.GameFrame.setVisible               (true);

        // Init. game JFrame

        vanilla.main.Main.OutTextArea.setText       ("");
        vanilla.main.Main.OutTextArea.setEditable   (false);
        vanilla.main.Main.OutTextArea.setFont       (FONT);
        vanilla.main.Main.OutTextArea.setBounds     (
                                   0,
                                   0,
                                   GUI_WIDTH,
                                   GUI_HEIGHT - SIZ);
        vanilla.main.Main.OutTextArea.setBackground (BGCOLOR);
        vanilla.main.Main.OutTextArea.setForeground (FGCOLOR);
        vanilla.main.Main.OutTextArea.setBorder     (BORDER);
        vanilla.main.Main.OutTextArea.setLineWrap   (true);

        // Init. output JTextPanel

        vanilla.main.Main.InTextArea.setText        ("");
        vanilla.main.Main.InTextArea.setFont        (FONT);
        vanilla.main.Main.InTextArea.setBounds      (
                                   0,
                                   GUI_HEIGHT - SIZ,
                                   GUI_WIDTH,
                                   SIZ);
        vanilla.main.Main.InTextArea.setBackground  (BGCOLOR);
        vanilla.main.Main.InTextArea.setForeground  (FGCOLOR);
        vanilla.main.Main.InTextArea.setBorder      (BORDER);
        vanilla.main.Main.InTextArea.addKeyListener (new KeyDetect()); // Runs createGame when you type
    
        //Init. input JTextArea
    }
}
