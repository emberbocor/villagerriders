package io.github.emberbocor.villagerriders.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.emberbocor.villagerriders.VillagerRiders;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;

@Mixin(Villager.class)
public abstract class VillagerMixin {
    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    private void villagerriders$dismount(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        Villager villager = (Villager) (Object) this;
        if (player.isSecondaryUseActive() && VillagerRiders.isRiding(villager)) {
            if (!villager.level().isClientSide()) {
                villager.stopRiding();
            }
            cir.setReturnValue(InteractionResult.SUCCESS);
        }
    }
}
