package dev.tildejustin.chunkborders.renderer;

import dev.tildejustin.chunkborders.config.ChunkBorderConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class ChunkBorderDebugRenderer implements DebugRenderer.DebugRenderable {
    private final Minecraft client;

    public ChunkBorderDebugRenderer(Minecraft minecraftClient) {
        this.client = minecraftClient;
    }

    @Override
    public void render(float tickDelta, long limitTime) {
        EntityPlayer playerEntity = this.client.thePlayer;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        double d = playerEntity.prevPosX + (playerEntity.posX - playerEntity.prevPosX) * (double) tickDelta;
        double e = playerEntity.prevPosY + (playerEntity.posY - playerEntity.prevPosY) * (double) tickDelta;
        double f = playerEntity.prevPosZ + (playerEntity.posZ - playerEntity.prevPosZ) * (double) tickDelta;
        double g = 0.0 - e;
        double h = 256.0 - e;
        GlStateManager.disableTexture2D();
        GlStateManager.disableBlend();
        double i = (double) (playerEntity.chunkCoordX << 4) - d;
        double j = (double) (playerEntity.chunkCoordZ << 4) - f;
        GL11.glLineWidth(1.0F);
        worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);

        float getR = ChunkBorderConfig.adjacentChunks.getRed() / 255F;
        float getG = ChunkBorderConfig.adjacentChunks.getGreen() / 255F;
        float getB = ChunkBorderConfig.adjacentChunks.getBlue() / 255F;
        float getA = ChunkBorderConfig.adjacentChunks.getAlpha() / 255F;

        for (int k = -16; k <= 32; k += 16) {
            for (int l = -16; l <= 32; l += 16) {
                worldRenderer.pos(i + (double) k, g, j + (double) l).color(getR, getG, getB, 0.0F).endVertex();
                worldRenderer.pos(i + (double) k, g, j + (double) l).color(getR, getG, getB, getA).endVertex();
                worldRenderer.pos(i + (double) k, h, j + (double) l).color(getR, getG, getB, getA).endVertex();
                worldRenderer.pos(i + (double) k, h, j + (double) l).color(getR, getG, getB, 0.0F).endVertex();
            }
        }

        getR = ChunkBorderConfig.currentChunk.getRed() / 255F;
        getG = ChunkBorderConfig.currentChunk.getGreen() / 255F;
        getB = ChunkBorderConfig.currentChunk.getBlue() / 255F;
        getA = ChunkBorderConfig.currentChunk.getAlpha() / 255F;

        for (int k = 2; k < 16; k += 2) {
            worldRenderer.pos(i + (double) k, g, j).color(getR, getG, getB, 0.0F).endVertex();
            worldRenderer.pos(i + (double) k, g, j).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + (double) k, h, j).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + (double) k, h, j).color(getR, getG, getB, 0.0F).endVertex();
            worldRenderer.pos(i + (double) k, g, j + 16.0).color(getR, getG, getB, 0.0F).endVertex();
            worldRenderer.pos(i + (double) k, g, j + 16.0).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + (double) k, h, j + 16.0).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + (double) k, h, j + 16.0).color(getR, getG, getB, 0.0F).endVertex();
        }

        for (int k = 2; k < 16; k += 2) {
            worldRenderer.pos(i, g, j + (double) k).color(getR, getG, getB, 0.0F).endVertex();
            worldRenderer.pos(i, g, j + (double) k).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i, h, j + (double) k).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i, h, j + (double) k).color(getR, getG, getB, 0.0F).endVertex();
            worldRenderer.pos(i + 16.0, g, j + (double) k).color(getR, getG, getB, 0.0F).endVertex();
            worldRenderer.pos(i + 16.0, g, j + (double) k).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + 16.0, h, j + (double) k).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + 16.0, h, j + (double) k).color(getR, getG, getB, 0.0F).endVertex();
        }

        for (int k = 0; k <= 256; k += 2) {
            double m = (double) k - e;
            worldRenderer.pos(i, m, j).color(getR, getG, getB, 0.0F).endVertex();
            worldRenderer.pos(i, m, j).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i, m, j + 16.0).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + 16.0, m, j + 16.0).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + 16.0, m, j).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i, m, j).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i, m, j).color(getR, getG, getB, 0.0F).endVertex();
        }

        tessellator.draw();
        GL11.glLineWidth(2.0F);
        worldRenderer.begin(3, DefaultVertexFormats.POSITION_COLOR);

        getR = ChunkBorderConfig.subChunks.getRed() / 255F;
        getG = ChunkBorderConfig.subChunks.getGreen() / 255F;
        getB = ChunkBorderConfig.subChunks.getBlue() / 255F;
        getA = ChunkBorderConfig.subChunks.getAlpha() / 255F;

        for (int k = 0; k <= 16; k += 16) {
            for (int l = 0; l <= 16; l += 16) {
                worldRenderer.pos(i + (double) k, g, j + (double) l).color(getR, getG, getB, 0.0F).endVertex();
                worldRenderer.pos(i + (double) k, g, j + (double) l).color(getR, getG, getB, getA).endVertex();
                worldRenderer.pos(i + (double) k, h, j + (double) l).color(getR, getG, getB, getA).endVertex();
                worldRenderer.pos(i + (double) k, h, j + (double) l).color(getR, getG, getB, 0.0F).endVertex();
            }
        }

        for (int k = 0; k <= 256; k += 16) {
            double m = (double) k - e;
            worldRenderer.pos(i, m, j).color(getR, getG, getB, 0.0F).endVertex();
            worldRenderer.pos(i, m, j).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i, m, j + 16.0).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + 16.0, m, j + 16.0).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i + 16.0, m, j).color(getR, getG, getB, 1.0F).endVertex();
            worldRenderer.pos(i, m, j).color(getR, getG, getB, getA).endVertex();
            worldRenderer.pos(i, m, j).color(getR, getG, getB, 0.0F).endVertex();
        }

        tessellator.draw();
        GL11.glLineWidth(1.0F);
        GlStateManager.enableBlend();
        GlStateManager.enableTexture2D();
    }
}
