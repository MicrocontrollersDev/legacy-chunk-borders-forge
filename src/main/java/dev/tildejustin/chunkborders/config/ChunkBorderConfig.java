package dev.tildejustin.chunkborders.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Color;
import cc.polyfrost.oneconfig.config.annotations.Info;
import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.config.data.InfoType;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import dev.tildejustin.chunkborders.LegacyChunkBorders;

public class ChunkBorderConfig extends Config {
    @Info(
            text = "Press F3+G in a world to display the chunk overlay.",
            type = InfoType.INFO,
            size=2
    )
    private boolean info = false;

    @Color(
            name = "Current Chunk",
            description = "Default color: Yellow #FFFF00"
    )
    public static OneColor currentChunk = new OneColor(255, 255, 0, 100);

    @Color(
            name = "Sub Chunks",
            description = "Default color: Blue #3F3FFF"
    )
    public static OneColor subChunks = new OneColor(63, 63, 255, 255);

    @Color(
            name = "Adjacent Chunks",
            description = "Default color: Red #FF000080"
    )
    public static OneColor adjacentChunks = new OneColor(255, 0, 0, 127);

    public ChunkBorderConfig() {
        super(new Mod(LegacyChunkBorders.NAME, ModType.UTIL_QOL, "/icon.png"), LegacyChunkBorders.MODID + ".json");
        initialize();
    }
}
