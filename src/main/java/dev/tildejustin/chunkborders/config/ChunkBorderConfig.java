package dev.tildejustin.chunkborders.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.config.core.OneKeyBind;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.libs.universal.UKeyboard;
import dev.tildejustin.chunkborders.LegacyChunkBorders;

public class ChunkBorderConfig extends Config {
    @KeyBind(
            name = "Toggle Chunk Borders Keybind",
            description = "The default keybind is F3 + G",
            size = 2
    )
    public static OneKeyBind chunkBorderKeybind = new OneKeyBind(UKeyboard.KEY_F3, UKeyboard.KEY_G);

    @Switch(
            name = "Allow Opacity and Blending",
            description = "Allows for opacity and blending on lines. Will cause color mixing for overlapping lines regardless if color settings are opaque. Default: False"
    )
    public static boolean opacity = false;

    @Switch(
            name = "Remove Depth",
            description = "Makes the chunk borders render through walls. Default: False"
    )
    public static boolean depth = false;

    @Switch(
            name = "Current Chunk",
            description = "Toggle the current chunk lines."
    )
    public static boolean currentChunk = true;

    @Color(
            name = "Current Chunk Color",
            description = "Default: Yellow #FFFF00"
    )
    public static OneColor currentChunkColor = new OneColor(255, 255, 0, 255);

    @Slider(
            name = "Current Chunk Line Width",
            description = "Default: 1.0",
            min = 0.1F, max = 10F
    )
    public static float currentChunkWidth = 1.0F;

    @Dropdown(
            name = "Current Chunk Line Spacing",
            description = "Default: 2",
            options = {"1", "2", "4", "8"},
            size = 2
    )
    public static int currentChunkSpacing = 1;

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
            description = "Default: Red #FF000000"
    )
    public static OneColor adjacentChunkColor = new OneColor(255, 0, 0, 255);

    @Slider(
            name = "Adjacent Chunk Line Width",
            description = "Default: 1.0",
            min = 0.1F, max = 10F
    )
    public static float adjacentChunkWidth = 1.0F;

    public ChunkBorderConfig() {
        super(new Mod(LegacyChunkBorders.NAME, ModType.UTIL_QOL, "/icon.png"), LegacyChunkBorders.MODID + ".json");
        initialize();
    }

}
