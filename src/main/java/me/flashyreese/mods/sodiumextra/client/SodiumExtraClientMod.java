package me.flashyreese.mods.sodiumextra.client;

import me.flashyreese.mods.sodiumextra.client.gui.SodiumExtraGameOptions;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod("sodiumextra")
@OnlyIn(Dist.CLIENT)
public class SodiumExtraClientMod {

    private static final ClientTickHandler clientTickHandler = new ClientTickHandler();
    private static SodiumExtraGameOptions CONFIG;
    private static Logger LOGGER;

    public static Logger logger() {
        if (LOGGER == null) {
            LOGGER = LogManager.getLogger("Sodium Extra");
        }

        return LOGGER;
    }

    public static SodiumExtraGameOptions options() {
        if (CONFIG == null) {
            CONFIG = loadConfig();
        }

        return CONFIG;
    }

    public static ClientTickHandler getClientTickHandler() {
        return clientTickHandler;
    }

    private static SodiumExtraGameOptions loadConfig() {
        return SodiumExtraGameOptions.load(FMLPaths.CONFIGDIR.get().resolve("sodium-extra-options.json").toFile());
    }

    public SodiumExtraClientMod() {
        getClientTickHandler().onClientInitialize();
    }
}
