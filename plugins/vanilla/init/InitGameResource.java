package vanilla.init;

import java.io.*;

import game.api.*;
import game.gts.*;
import game.utils.templates.*;

/**
 * Inits the resource of plugin {@code vanilla}.
 * 
 * @since game:1.2.5a vanilla:2.0.2a
 */
public class InitGameResource {

    /**No instance constructing */
    private InitGameResource() {}

    /**
     * Inits. items.
     * @throws IOException {@link LoadSave#Load()}
     */
    public static void Load() throws IOException {
        ItemTemplate TEST = new ItemTemplate()
                .setName("TEST");
                
        data.Items.add(Item.valueOf(TEST));

        LoadSave.Load();
    }
}
