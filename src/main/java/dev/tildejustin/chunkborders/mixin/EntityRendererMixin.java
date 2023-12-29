package dev.tildejustin.chunkborders.mixin;

import dev.tildejustin.chunkborders.renderer.DebugRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
    @Inject(method = "renderWorldPass", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/EntityRenderer;debugView:Z", ordinal = 0), slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=destroyProgress")), require = 0)
    private void runDebugRenderer(int anaglyphFilter, float tickDelta, long limitTime, CallbackInfo ci) {
        if (DebugRenderer.instance.isEnabled()) {
            DebugRenderer.instance.render(tickDelta, limitTime);
        }
    }
}
