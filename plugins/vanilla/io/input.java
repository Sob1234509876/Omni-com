package vanilla.io;

public class input {

    public static String read() {
        return vanilla.main.Main.in.getText();
    }

    public static void clear() {
        vanilla.main.Main.in.setText(null);
    }

}
