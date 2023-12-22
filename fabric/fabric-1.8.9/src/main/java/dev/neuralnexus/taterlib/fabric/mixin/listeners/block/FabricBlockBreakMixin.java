package dev.neuralnexus.taterlib.fabric.mixin.listeners.block;

import dev.neuralnexus.taterlib.fabric.event.api.FabricBlockEvents;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Mixin for the block break listener. */
@Mixin(Block.class)
public class FabricBlockBreakMixin {
    /**
     * Called when a block is broken.
     *
     * @param world The world.
     * @param pos The position of the block.
     * @param ci The callback info.
     */
    @Inject(method = "harvest", at = @At("HEAD"), cancellable = true)
    private static void onBlockBreak(
            World world,
            PlayerEntity player,
            BlockPos pos,
            BlockState state,
            BlockEntity be,
            CallbackInfo ci) {
        FabricBlockEvents.BLOCK_BREAK
                .invoker()
                .onBlockBreak(world, player, pos, state, be, ci);
    }
}
