package game.ui;

import game.main.*;
import game.ui.listeners.KeyDetect;


import game.utils.*;

//GUI
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LoadUI {
    
    /**
     * Graphics init. (That`s all)
     */

     public static void Load() throws Exception {

        // Loads icon, settings and langs

        Main.GameFrame.add(Main.InTextArea);
        Main.GameFrame.add(Main.OutTextArea);

        final Integer GUI_X = Integer.parseInt(Main.SETTINGS.getProperty("GUI.size").split("x")[0]);
        final Integer GUI_Y = Integer.parseInt(Main.SETTINGS.getProperty("GUI.size").split("x")[1]);
        final Integer SIZ = Integer.parseInt(Main.SETTINGS.getProperty("GUI.font_siz"));
        final Integer BGCOLOR = Integer.parseInt(Main.SETTINGS.getProperty("GUI.BGColor"));
        final Integer FGCOLOR = Integer.parseInt(Main.SETTINGS.getProperty("GUI.FGColor"));
        final Font FONT = new Font(Main.SETTINGS.getProperty("GUI.font"), Font.PLAIN, SIZ);
        final Border BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(FGCOLOR, false));

        Main.GameFrame.setTitle(String.format(Main.LANG.getProperty("title"), Main.__VERSION__));
        Main.GameFrame.setVisible(true);
        Main.GameFrame.setIconImage(Main.ICON);
        Main.GameFrame.setLayout(null);
        Main.GameFrame.setSize(GUI_X + 12, GUI_Y + 35);
        Main.GameFrame.setResizable(false);
        Main.GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main.OutTextArea.setBounds(0,
                0,
                GUI_X,
                GUI_Y - SIZ);
        Main.OutTextArea.setEditable(false);
        Main.OutTextArea.setFont(FONT);
        Main.OutTextArea.setBackground(new Color(BGCOLOR, false));
        Main.OutTextArea.setForeground(new Color(FGCOLOR, false));
        Main.OutTextArea.setBorder(BORDER);
        Main.OutTextArea.setLineWrap(true);
        Main.OutTextArea.setText(Main.LANG.getProperty("default"));

        Main.InTextArea.setBounds(0,
                GUI_Y - SIZ,
                GUI_X,
                SIZ);
        Main.InTextArea.setFont(FONT);
        Main.InTextArea.setBackground(new Color(BGCOLOR, false));
        Main.InTextArea.setForeground(new Color(FGCOLOR, false));
        Main.InTextArea.setBorder(BORDER);
        Main.InTextArea.setEditable(true);
        Main.InTextArea.addKeyListener(new KeyDetect());

        new ShowData().start();

    }
}
