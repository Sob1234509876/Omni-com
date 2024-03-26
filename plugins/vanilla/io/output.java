package vanilla.io;

public class output {

    public static void write(Object x) {
        vanilla.main.Main.out.setText(x.toString());
    }

    public static void write() {
        vanilla.main.Main.out.setText(null);
    }

}
