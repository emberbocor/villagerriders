package io.github.emberbocor.villagerriders;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.camel.CamelHusk;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.entity.animal.equine.Llama;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;

public final class VillagerRiders {
    public static final String MODID = "villagerriders";
    private static final int CARAVAN_LIMIT = 8;

    private VillagerRiders() {
    }

    public static boolean isMount(Entity entity) {
        return (entity instanceof Camel && !(entity instanceof CamelHusk)) || entity instanceof Llama;
    }

    public static boolean isRiding(Villager villager) {
        return isMount(villager.getVehicle());
    }

    // An untamed llama throws off a rider that does not steer it (and a led one any rider), so it takes no villager and a villager put on it steers as in vanilla.
    public static boolean isPassiveRider(Villager villager) {
        return villager.getVehicle() instanceof AbstractHorse mount && isMount(mount) && mount.isTamed();
    }

    public static boolean canPickUp(Entity mount, Villager villager) {
        if (villager.isPassenger() || !isMount(mount)) {
            return false;
        }
        if (mount instanceof Camel camel) {
            return camel.getFirstPassenger() instanceof Player && !camel.isBaby() && camel.getPassengers().size() < 2;
        }
        return mount instanceof Llama llama && llama.isTamed() && !llama.isVehicle() && llama.isWearingBodyArmor() && isLedByPlayer(llama);
    }

    private static boolean isLedByPlayer(Llama llama) {
        Llama current = llama;
        for (int i = 0; i <= CARAVAN_LIMIT; i++) {
            if (current.isLeashed()) {
                return current.getLeashHolder() instanceof Player;
            }
            if (!current.inCaravan()) {
                return false;
            }
            current = current.getCaravanHead();
        }
        return false;
    }
}
