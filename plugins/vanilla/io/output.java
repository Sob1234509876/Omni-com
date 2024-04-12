package vanilla.io;

public class output {

    public static void write(Object x) {
        vanilla.main.Main.OutTextArea.setText(x.toString());
    }

    public static void write() {
        vanilla.main.Main.OutTextArea.setText(null);
    }

}
