# Recipes

A lightweight Paper plugin (supports 1.20.x - 26.x) that expands the vanilla crafting system with balanced recycling and Quality of Life (QoL) recipes. The goal is to allow players to reclaim materials and simplify certain tasks without breaking the vanilla feel of the game.

## Features

### Recycling
* **Metal Smelting:** Smelt or blast gold, iron, chainmail and copper armor, tools and items back into ingots or nuggets based on their crafting cost. Supports all oxidized and waxed copper variants. Also works for horse armor, bells, hoppers and iron chains (5 iron nuggets each).
* **Wood & Stone Reclaiming:** Convert 2 slabs back into 1 full block or 2 stairs into 2 full blocks. Works with all vanilla wood types and stone variants.
* **Leather Cutting:** Break down leather armor back into leather using the stonecutter.

### Block Uncrafting
* **Crafting Grid:** Break down assembled blocks (Quartz, Clay, Amethyst, Glowstone, Magma, Honeycomb, Snow, Bricks, Melon, Nether Wart) back into their base materials.
* **Melting:** Smelt Blue Ice into Packed Ice and Packed Ice into regular Ice.

### Washing & Bleaching
* Clean dyed items (Wool, Carpets, Glass (& Panes), Beds, Terracotta, Concrete, Candles) back to their default white or uncolored states by right-clicking a Water Cauldron.
* Consumes one water level from the cauldron per use, allowing you to efficiently bleach entire stacks in your hand at once.

### Quality of Life
* **Bulk Smelting:** Smelt Raw Iron, Gold and Copper blocks directly into their respective solid blocks.
* **Blast Furnace Stone Processing:** Blast Cobblestone into Stone, Stone into Smooth Stone, Cobbled Deepslate into Deepslate, Deepslate Bricks and Tiles into their cracked variants, Sandstone and Red Sandstone into their smooth variants, Basalt into Smooth Basalt, Nether Bricks and Polished Blackstone Bricks into their cracked variants and Quartz Blocks into Smooth Quartz. Copies the existing furnace recipes with the same inputs, outputs and XP at twice the speed.
* **Stonecutter Additions:** Crush Cobblestone into Gravel, Gravel into Sand, cut Glass blocks into Glass Panes and reclaim materials from blocks (Furnace, Dropper, Dispenser, etc).
* **Smoker & Furnace:** Cook Rotten Flesh into Leather, Gravel into Flint and Poisonous Potatoes into Green Dye.
* **New Recipes:** Craftable Name Tags, Saddles, Black Dye (from Coal or Charcoal) and Honey (Honeycomb + Glass Bottle).

1. Download the latest `.jar` file from the [Releases page](https://github.com/coalaura/recipes/releases/latest).
2. Place it into your server's `plugins` directory.
3. Restart your server.

Recipes are automatically unlocked for players when they join, including returning players. Turn off the recipe book's craftable-only filter to see recipes whose ingredients you do not currently have.

### Troubleshooting missing recipes

Check the plugin's `Recipes ready! Registered ...` message for the number of successfully registered crafting, cooking and stonecutting recipes. Registration failures are logged with the affected recipe key. Minecraft's earlier `Loaded ... recipes` message counts datapack recipes before this plugin enables.

The plugin also checks its registered keys after all plugins have enabled and after server resources are reloaded. The `Recipe registry check after ...` message reports how many recipes are still present, including the first missing key if recipes were removed. If registration succeeds but this later check fails, a registry reset or removal happened after registration; unlocking the recipe book cannot restore those recipes. When reporting this issue, include both the registration message and the later registry-check messages from a full restart with the updated JAR.

To check a specific recipe, run `/minecraft:recipe give @s recipes:dye_from_coal` as an operator in-game, then place one coal in a crafting slot; it should produce two black dye. An unknown-recipe error means the recipe is absent from the server registry, whereas a successful unlock (or an already-known response) confirms it is registered. Brewing mixes and cauldron washing are separate mechanics and do not appear in the crafting recipe book.
