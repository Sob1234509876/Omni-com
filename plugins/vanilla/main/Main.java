package vanilla.main;

import src.utils.factories.*;

public class Main {

    public static void run() {

        Integer i = new itemFactory()
                .setName("TEST!!!")
                .register();

        System.out.println(src.main.Main.Items.get(i).name);

    }

}
