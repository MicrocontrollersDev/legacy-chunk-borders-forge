package dev.tildejustin.chunkborders;

import dev.tildejustin.chunkborders.config.ChunkBorderConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = LegacyChunkBorders.MODID, name = LegacyChunkBorders.NAME, version = LegacyChunkBorders.VERSION)
public class LegacyChunkBorders {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    @Mod.Instance(MODID)
    public static LegacyChunkBorders INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static ChunkBorderConfig config;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new ChunkBorderConfig();
    }
}
