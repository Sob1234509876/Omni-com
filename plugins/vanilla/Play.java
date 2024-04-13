package vanilla;

import java.nio.file.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

import game.gui.listeners.*;
import vanilla.main.Main;

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

        Main.GameFrame.setTitle                 (String.format(Main.langSettings.getProperty("title"), Main.__VERSION__));
        Main.GameFrame.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        Main.GameFrame.setLayout                (null);
        Main.GameFrame.setIconImage             (game.main.Main.ICON);
        Main.GameFrame.setSize                  (GUI_WIDTH, GUI_HEIGHT + 35);
        Main.GameFrame.setResizable             (false);
        Main.GameFrame.setLocationRelativeTo    (null);
        Main.GameFrame.setVisible               (true);

        // Init. game JFrame

        Main.OutTextArea.setText       ("");
        Main.OutTextArea.setEditable   (false);
        Main.OutTextArea.setFont       (FONT);
        Main.OutTextArea.setBounds     (
                                   0,
                                   0,
                                   GUI_WIDTH,
                                   GUI_HEIGHT - SIZ);
        Main.OutTextArea.setBackground (BGCOLOR);
        Main.OutTextArea.setForeground (FGCOLOR);
        Main.OutTextArea.setBorder     (BORDER);
        Main.OutTextArea.setLineWrap   (true);

        // Init. output JTextPanel

        Main.InTextArea.setText        ("");
        Main.InTextArea.setFont        (FONT);
        Main.InTextArea.setBounds      (
                                   0,
                                   GUI_HEIGHT - SIZ,
                                   GUI_WIDTH,
                                   SIZ);
        Main.InTextArea.setBackground  (BGCOLOR);
        Main.InTextArea.setForeground  (FGCOLOR);
        Main.InTextArea.setBorder      (BORDER);
        Main.InTextArea.addKeyListener (new KeyDetect()); // Runs createGame when you type
    
        //Init. input JTextArea
    }
}
