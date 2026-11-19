package io.github.emberbocor.villagerriders.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.npc.Villager;

@Mixin(Camel.class)
public abstract class CamelMixin {
    @Inject(method = "getControllingPassenger", at = @At("RETURN"), cancellable = true)
    private void villagerriders$neverSteerMount(CallbackInfoReturnable<LivingEntity> cir) {
        if (cir.getReturnValue() instanceof Villager) {
            cir.setReturnValue(null);
        }
    }
}
