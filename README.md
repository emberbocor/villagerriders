# Villager Riders

Take villagers with you: they hop onto your camel or your llama and ride along.

Villager Riders lets villagers board camels and llamas the way mobs board a boat. Ride a camel into a villager and it climbs onto the back seat. Lead a llama wearing a carpet into a villager and it sits on the llama. Sneak and right-click a seated villager to let it off again.

The mod runs on the server only. Players join with a plain vanilla client and see the villagers riding as normal passengers.

Available for NeoForge, Forge and Fabric.

## Features

- **Camels carry a passenger.** While you ride a camel, any villager the camel touches climbs onto the back seat. You keep the front seat and keep steering.
- **Llamas carry a villager.** A llama that wears a carpet and is on your lead picks up a villager it touches. A llama in a caravan does the same, as long as the front llama of the caravan is on your lead.
- **Let them off when you want.** Sneak and right-click a seated villager to make it get off. A normal right-click still opens the trading screen.
- **They stay seated.** A villager stays on the camel when you get off, and on the llama when you let go of the lead. It does not walk the camel or llama around by itself.
- **Adults and babies.** Every villager can ride, including nitwits, unemployed villagers and baby villagers.

## How it works

- **Camel.** The camel must have a player in its front seat. A villager boards only while the back seat is free: an adult camel has two seats, so it takes one villager. A baby camel has no seat to spare. When the back seat is taken, the camel pushes other villagers aside as usual.
- **Llama.** The llama must wear a carpet and have no passenger yet, and it carries one villager. It must be on a lead held by a player, or be part of a caravan whose front llama is on a lead held by a player. A llama tied to a fence, or a trader llama led by a wandering trader, never picks up villagers.
- **Getting back on.** If you get off a camel with a villager on it, the villager moves to the front seat. When you get back on, you take the front seat again, the villager moves to the back, and you can steer as before.
- **Getting off.** Sneak + right-click works on any villager sitting on a camel or llama. It does not open the trading screen. Like any mob leaving a vehicle, the villager needs about three seconds before it can board again, so a villager that stays next to your camel or llama climbs back on after that.
- **Seated villagers don't steer.** While seated, a villager does not steer the camel or llama. The camel or llama follows its own AI, its lead and its caravan.
- **Who can ride.** Only villagers. Wandering traders and zombie villagers never board.
- **Which mounts.** Only camels, llamas and trader llamas. Horses, donkeys, mules, boats and minecarts are not changed.
- **Saving.** Riding villagers are saved by the game itself and are still seated after the world is reloaded.

### Limits

- **You can't reach the villager behind you.** While you sit in the camel's front seat, the game does not let you aim at a passenger on the same camel. This is how the vanilla client works, and a server-only mod cannot change it. Get off the camel first, then sneak + right-click the villager.
- **Seated villagers don't sleep or work.** A villager on a camel or llama stays awake at night and does not go to its job site until it gets off. Vanilla also makes it get off when the camel or llama goes under water.
- **Turning into a zombie villager.** If a seated villager is killed by a zombie and turns into a zombie villager, the game keeps it seated, and sneak + right-click does not let it off. A seated villager struck by lightning turns into a witch that is not seated.

## Requirements

| | NeoForge | Forge | Fabric |
|---|---|---|---|
| Minecraft | 1.21.1 | 1.21.1 | 1.21 or 1.21.1 |
| Loader | NeoForge 21.1.1 or newer | Forge 52.0.0 or newer | Fabric Loader 0.15.10 or newer |
| Jar | `villagerriders-neoforge-1.21.1-<version>.jar` | `villagerriders-forge-1.21.1-<version>.jar` | `villagerriders-fabric-1.21-1.21.1-<version>.jar` |

On Minecraft 1.21.1, NeoForge and Forge are separate loaders that do not run each other's mods, so each has its own jar. Pick the jar that matches your server's loader.

The Fabric version does not need Fabric API.

### Client and server

Install the mod on the server only, on every loader. It adds no items, blocks, entities, network messages or registries. Riding passengers are sent to the client by the game itself:

- **NeoForge:** vanilla clients and NeoForge clients without the mod can join.
- **Forge:** vanilla clients and Forge clients without the mod can join. The mod is marked as server-only, so a Forge client without it still shows the server as compatible in the server list.
- **Fabric:** vanilla clients and Fabric clients without the mod can join.

Installing it on a client as well does no harm.

In singleplayer, install it in your own game; the built-in server runs it.

## Configuration

No configuration. There is no config file, and the mod adds no messages or sounds.

## Compatibility

- **Existing worlds:** works right away. Removing the mod is also safe. Villagers that are seated stay seated, because riding is saved by the game itself. Without the mod they only get off the vanilla way, for example when the camel or llama goes under water, or with the `/ride` command.
- **Mods that add villager professions:** villagers with those professions can ride like any other villager.
- **Mods that change camels, llamas or villagers:** the mod only adds the boarding check when a camel or llama bumps into a villager, the sneak + right-click on a seated villager, and the rule that a seated villager does not steer its mount. Everything else stays vanilla.

## Building from source

```
./gradlew build
```

The jars are written to `neoforge/build/libs/`, `forge/build/libs/` and `fabric/build/libs/`.

## License

MIT.
