package vanilla.io;

public class input {

    public static String read() {
        return vanilla.main.Main.InTextArea.getText();
    }

    public static void clear() {
        vanilla.main.Main.InTextArea.setText(null);
    }

}
