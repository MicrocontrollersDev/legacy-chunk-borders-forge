package dev.tildejustin.chunkborders;

import dev.tildejustin.chunkborders.config.ChunkBorderConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = LegacyChunkBorders.MODID, name = LegacyChunkBorders.NAME, version = LegacyChunkBorders.VERSION)
public class LegacyChunkBorders {
    // change in `gradle.properties`
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    public static ChunkBorderConfig config;

    // register the config
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new ChunkBorderConfig();
    }
}
