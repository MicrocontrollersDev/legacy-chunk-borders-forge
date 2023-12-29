package dev.tildejustin.chunkborders.renderer;

import net.minecraft.client.Minecraft;

public class DebugRenderer {
    public final DebugRenderer.DebugRenderable chunkBorders;
    private boolean renderChunkBorders;
    public static DebugRenderer instance;

    static {
        DebugRenderer.instance = new DebugRenderer(Minecraft.getMinecraft());
    }

    private DebugRenderer(Minecraft minecraftClient) {
        this.chunkBorders = new ChunkBorderDebugRenderer(minecraftClient);
    }

    public boolean isEnabled() {
        return this.renderChunkBorders;
    }

    public void toggleChunkBorders() {
        this.renderChunkBorders = !this.renderChunkBorders;
    }

    public void render(float tickDelta, long limitTime) {
        if (this.renderChunkBorders && !Minecraft.getMinecraft().thePlayer.hasReducedDebug()) {
            this.chunkBorders.render(tickDelta, limitTime);
        }
    }

    public interface DebugRenderable {
        void render(float tickDelta, long limitTime);
    }
}
