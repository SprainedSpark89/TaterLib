package dev.neuralnexus.taterapi.fabric.mixin.listeners.entity;

import dev.neuralnexus.taterapi.fabric.events.entity.FabricEntitySpawnEvent;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Listens for entity spawn and emits an event.
 */
@Mixin(ServerWorld.class)
class FabricEntitySpawnListener {
    /**
     * Called when an entity is spawned.
     * @param entity The entity.
     * @param cir The callback info.
     */
    @Inject(method = "spawnEntity", at = @At("HEAD"))
    private void onEntitySpawn(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity == null) return;
        FabricEntitySpawnEvent.EVENT.invoker().onEntitySpawn(entity);
    }
}
