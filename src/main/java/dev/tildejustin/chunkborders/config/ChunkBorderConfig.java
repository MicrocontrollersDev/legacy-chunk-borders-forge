package dev.tildejustin.chunkborders.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.config.data.InfoType;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import dev.tildejustin.chunkborders.LegacyChunkBorders;

public class ChunkBorderConfig extends Config {
    @Info(
            type = InfoType.INFO,
            text = "Press F3+G in a world to display the chunk overlay.",
            size = 2
    )
    private boolean info = false;

    @Switch(
            name = "Allow Opacity",
            description = "Allows for opacity on lines. Due to blending, this will cause some colors to mix."
    )
    public static boolean opacity = false;

    @Switch(
            name = "Remove Depth",
            description = "Makes the chunk borders render through walls."
    )
    public static boolean depth = true;

    @Switch(
            name = "Current Chunk",
            description = "Toggle the current chunk lines."
    )
    public static boolean currentChunk = true;

    @Color(
            name = "Current Chunk Color",
            description = "Default: Yellow #FFFF00"
    )
    public static OneColor currentChunkColor = new OneColor(255, 255, 0, 100);

    @Slider(
            name = "Current Chunk Line Width",
            description = "Default: 1.0",
            min = 0.1F, max = 10F
    )
    public static float currentChunkWidth = 1.0F;

    @Switch(
            name = "Sub Chunk",
            description = "Toggle the sub chunk lines."
    )
    public static boolean subChunk = true;

    @Color(
            name = "Sub Chunk Color",
            description = "Default: Blue #3F3FFF"
    )
    public static OneColor subChunkColor = new OneColor(63, 63, 255, 255);

    @Slider(
            name = "Sub Chunk Line Width",
            description = "Default: 2.0",
            min = 0.1F, max = 10F
    )
    public static float subChunkWidth = 2.0F;

    @Switch(
            name = "Ajacent Chunk",
            description = "Toggle the current chunk lines."
    )
    public static boolean adjacentChunk = true;

    @Color(
            name = "Adjacent Chunk Color",
            description = "Default: Red #FF000080"
    )
    public static OneColor adjacentChunkColor = new OneColor(255, 0, 0, 127);

    @Slider(
            name = "Adjacent Chunk Line Width",
            description = "Default: 1.0",
            min = 0.1F, max = 10F
    )
    public static float adjacentChunkWidth = 1.0F;

    @Info(
            type = InfoType.ERROR,
            text = "Currently, several lines are drawn multiple times leading to overlapping lines which may cause issues with opacity and differing line widths.",
            size = 2
    )
    private boolean error = false;

    public ChunkBorderConfig() {
        super(new Mod(LegacyChunkBorders.NAME, ModType.UTIL_QOL, "/icon.png"), LegacyChunkBorders.MODID + ".json");
        initialize();
    }

}
