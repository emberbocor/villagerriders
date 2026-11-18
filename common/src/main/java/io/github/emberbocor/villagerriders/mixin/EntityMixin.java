package io.github.emberbocor.villagerriders.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.emberbocor.villagerriders.VillagerRiders;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(method = "canControlVehicle", at = @At("HEAD"), cancellable = true)
    private void villagerriders$neverSteerMount(CallbackInfoReturnable<Boolean> cir) {
        if ((Object) this instanceof Villager villager && VillagerRiders.isRiding(villager)) {
            cir.setReturnValue(false);
        }
    }
}
