package io.github.emberbocor.villagerriders.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.emberbocor.villagerriders.VillagerRiders;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "doPush", at = @At("HEAD"), cancellable = true)
    private void villagerriders$pickUpVillager(Entity entity, CallbackInfo ci) {
        LivingEntity mount = (LivingEntity) (Object) this;
        if (entity instanceof Villager villager && !mount.level().isClientSide()
                && VillagerRiders.canPickUp(mount, villager) && villager.startRiding(mount)) {
            ci.cancel();
        }
    }
}
