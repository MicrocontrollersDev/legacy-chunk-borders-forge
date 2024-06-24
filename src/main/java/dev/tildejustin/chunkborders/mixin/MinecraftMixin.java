package dev.tildejustin.chunkborders.mixin;

import dev.tildejustin.chunkborders.config.ChunkBorderConfig;
import dev.tildejustin.chunkborders.renderer.DebugRenderer;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "runTick", at = @At(value = "FIELD", target = "Lnet/minecraft/client/settings/GameSettings;keyBindTogglePerspective:Lnet/minecraft/client/settings/KeyBinding;"))
    private void handleChunkBordersKey(CallbackInfo ci) {
        if (ChunkBorderConfig.chunkBorderKeybind.isActive()) {
            DebugRenderer.instance.toggleChunkBorders();
        }
    }
}
