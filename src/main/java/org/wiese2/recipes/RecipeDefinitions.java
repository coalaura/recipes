package org.wiese2.recipes;

import org.bukkit.Material;

public class RecipeDefinitions {
	private final RecipeManager manager;

	public RecipeDefinitions(RecipeManager manager) {
		this.manager = manager;
	}

	public void registerAll() {
		registerMetalRecycling();
		registerWoodRecycling();
		registerStoneRecycling();
		registerLeatherRecycling();
		registerBlockUncrafting();
		registerBleaching();
		registerBulkSmelting();
		registerMisc();
	}

	private void registerMetalRecycling() {
		// @formatter:off
		Object[][] metalRecycling = {
			// Gold Armor
			{Material.GOLDEN_CHESTPLATE, Material.GOLD_INGOT, 4},
			{Material.GOLDEN_LEGGINGS, Material.GOLD_INGOT, 3},
			{Material.GOLDEN_HELMET, Material.GOLD_INGOT, 2},
			{Material.GOLDEN_BOOTS, Material.GOLD_INGOT, 2},
			{Material.GOLDEN_HORSE_ARMOR, Material.GOLD_INGOT, 3},

			// Gold Tools
			{Material.GOLDEN_PICKAXE, Material.GOLD_INGOT, 1},
			{Material.GOLDEN_AXE, Material.GOLD_INGOT, 1},
			{Material.GOLDEN_SWORD, Material.GOLD_INGOT, 1},
			{Material.GOLDEN_HOE, Material.GOLD_INGOT, 1},
			{Material.GOLDEN_SHOVEL, Material.GOLD_NUGGET, 5},

			// Gold Items/Blocks
            {Material.CLOCK, Material.GOLD_INGOT, 2},
            {Material.LIGHT_WEIGHTED_PRESSURE_PLATE, Material.GOLD_INGOT, 1},

			// Iron Armor
            {Material.IRON_CHESTPLATE, Material.IRON_INGOT, 4},
            {Material.IRON_LEGGINGS, Material.IRON_INGOT, 3},
            {Material.IRON_HELMET, Material.IRON_INGOT, 2},
            {Material.IRON_BOOTS, Material.IRON_INGOT, 2},
            {Material.IRON_HORSE_ARMOR, Material.IRON_INGOT, 3},

            // Iron Tools
            {Material.IRON_PICKAXE, Material.IRON_INGOT, 1},
            {Material.IRON_AXE, Material.IRON_INGOT, 1},
            {Material.IRON_SWORD, Material.IRON_INGOT, 1},
            {Material.IRON_HOE, Material.IRON_INGOT, 1},
            {Material.IRON_SHOVEL, Material.IRON_NUGGET, 5},
			{Material.SHEARS, Material.IRON_INGOT, 1},

			// Iron Items/Blocks
            {Material.IRON_DOOR, Material.IRON_INGOT, 1},
            {Material.IRON_TRAPDOOR, Material.IRON_INGOT, 2},
            {Material.IRON_BARS, Material.IRON_NUGGET, 2},
			{Material.MINECART, Material.IRON_INGOT, 2},
            {Material.BUCKET, Material.IRON_INGOT, 1},
            {Material.CAULDRON, Material.IRON_INGOT, 3},
            {Material.ANVIL, Material.IRON_INGOT, 15},
            {Material.COMPASS, Material.IRON_INGOT, 2},
            {Material.HEAVY_WEIGHTED_PRESSURE_PLATE, Material.IRON_INGOT, 1},
            {Material.LANTERN, Material.IRON_NUGGET, 4},
            {Material.SOUL_LANTERN, Material.IRON_NUGGET, 4},

            // Chainmail Armor
            {Material.CHAINMAIL_CHESTPLATE, Material.IRON_NUGGET, 12},
            {Material.CHAINMAIL_LEGGINGS, Material.IRON_NUGGET, 9},
            {Material.CHAINMAIL_HELMET, Material.IRON_NUGGET, 6},
            {Material.CHAINMAIL_BOOTS, Material.IRON_NUGGET, 5},

			// Copper Armor
			{Material.COPPER_CHESTPLATE, Material.COPPER_INGOT, 4},
            {Material.COPPER_LEGGINGS, Material.COPPER_INGOT, 3},
            {Material.COPPER_HELMET, Material.COPPER_INGOT, 2},
            {Material.COPPER_BOOTS, Material.COPPER_INGOT, 2},

            // Copper Tools
            {Material.COPPER_PICKAXE, Material.COPPER_INGOT, 1},
            {Material.COPPER_AXE, Material.COPPER_INGOT, 1},
            {Material.COPPER_SWORD, Material.COPPER_INGOT, 1},
            {Material.COPPER_HOE, Material.COPPER_INGOT, 1},
            {Material.COPPER_SHOVEL, Material.COPPER_NUGGET, 5},

			// Copper Chest
			{Material.COPPER_CHEST, Material.COPPER_INGOT, 4},
            {Material.EXPOSED_COPPER_CHEST, Material.COPPER_INGOT, 4},
            {Material.WEATHERED_COPPER_CHEST, Material.COPPER_INGOT, 4},
            {Material.OXIDIZED_COPPER_CHEST, Material.COPPER_INGOT, 4},
            {Material.WAXED_COPPER_CHEST, Material.COPPER_INGOT, 4},
            {Material.WAXED_EXPOSED_COPPER_CHEST, Material.COPPER_INGOT, 4},
            {Material.WAXED_WEATHERED_COPPER_CHEST, Material.COPPER_INGOT, 4},
            {Material.WAXED_OXIDIZED_COPPER_CHEST, Material.COPPER_INGOT, 4},

            // Lightning Rods
            {Material.LIGHTNING_ROD, Material.COPPER_INGOT, 1},
            {Material.EXPOSED_LIGHTNING_ROD, Material.COPPER_INGOT, 1},
            {Material.WEATHERED_LIGHTNING_ROD, Material.COPPER_INGOT, 1},
            {Material.OXIDIZED_LIGHTNING_ROD, Material.COPPER_INGOT, 1},
            {Material.WAXED_LIGHTNING_ROD, Material.COPPER_INGOT, 1},
            {Material.WAXED_EXPOSED_LIGHTNING_ROD, Material.COPPER_INGOT, 1},
            {Material.WAXED_WEATHERED_LIGHTNING_ROD, Material.COPPER_INGOT, 1},
            {Material.WAXED_OXIDIZED_LIGHTNING_ROD, Material.COPPER_INGOT, 1},

            // Copper Bars
            {Material.COPPER_BARS, Material.COPPER_NUGGET, 2},
            {Material.EXPOSED_COPPER_BARS, Material.COPPER_NUGGET, 2},
            {Material.WEATHERED_COPPER_BARS, Material.COPPER_NUGGET, 2},
            {Material.OXIDIZED_COPPER_BARS, Material.COPPER_NUGGET, 2},
            {Material.WAXED_COPPER_BARS, Material.COPPER_NUGGET, 2},
            {Material.WAXED_EXPOSED_COPPER_BARS, Material.COPPER_NUGGET, 2},
            {Material.WAXED_WEATHERED_COPPER_BARS, Material.COPPER_NUGGET, 2},
            {Material.WAXED_OXIDIZED_COPPER_BARS, Material.COPPER_NUGGET, 2},

            // Copper Chains
            {Material.COPPER_CHAIN, Material.COPPER_NUGGET, 5},
            {Material.EXPOSED_COPPER_CHAIN, Material.COPPER_NUGGET, 5},
            {Material.WEATHERED_COPPER_CHAIN, Material.COPPER_NUGGET, 5},
            {Material.OXIDIZED_COPPER_CHAIN, Material.COPPER_NUGGET, 5},
            {Material.WAXED_COPPER_CHAIN, Material.COPPER_NUGGET, 5},
            {Material.WAXED_EXPOSED_COPPER_CHAIN, Material.COPPER_NUGGET, 5},
            {Material.WAXED_WEATHERED_COPPER_CHAIN, Material.COPPER_NUGGET, 5},
            {Material.WAXED_OXIDIZED_COPPER_CHAIN, Material.COPPER_NUGGET, 5},

			// Copper Door
			{Material.COPPER_DOOR, Material.COPPER_INGOT, 1},
            {Material.EXPOSED_COPPER_DOOR, Material.COPPER_INGOT, 1},
            {Material.WEATHERED_COPPER_DOOR, Material.COPPER_INGOT, 1},
            {Material.OXIDIZED_COPPER_DOOR, Material.COPPER_INGOT, 1},
            {Material.WAXED_COPPER_DOOR, Material.COPPER_INGOT, 1},
            {Material.WAXED_EXPOSED_COPPER_DOOR, Material.COPPER_INGOT, 1},
            {Material.WAXED_WEATHERED_COPPER_DOOR, Material.COPPER_INGOT, 1},
            {Material.WAXED_OXIDIZED_COPPER_DOOR, Material.COPPER_INGOT, 1},

			// Copper Trapdoor
			{Material.COPPER_TRAPDOOR, Material.COPPER_INGOT, 2},
            {Material.EXPOSED_COPPER_TRAPDOOR, Material.COPPER_INGOT, 2},
            {Material.WEATHERED_COPPER_TRAPDOOR, Material.COPPER_INGOT, 2},
            {Material.OXIDIZED_COPPER_TRAPDOOR, Material.COPPER_INGOT, 2},
            {Material.WAXED_COPPER_TRAPDOOR, Material.COPPER_INGOT, 2},
            {Material.WAXED_EXPOSED_COPPER_TRAPDOOR, Material.COPPER_INGOT, 2},
            {Material.WAXED_WEATHERED_COPPER_TRAPDOOR, Material.COPPER_INGOT, 2},
            {Material.WAXED_OXIDIZED_COPPER_TRAPDOOR, Material.COPPER_INGOT, 2},

			// Chiseled Copper
			{Material.CHISELED_COPPER, Material.COPPER_INGOT, 4},
            {Material.EXPOSED_CHISELED_COPPER, Material.COPPER_INGOT, 4},
            {Material.WEATHERED_CHISELED_COPPER, Material.COPPER_INGOT, 4},
            {Material.OXIDIZED_CHISELED_COPPER, Material.COPPER_INGOT, 4},
            {Material.WAXED_CHISELED_COPPER, Material.COPPER_INGOT, 4},
            {Material.WAXED_EXPOSED_CHISELED_COPPER, Material.COPPER_INGOT, 4},
            {Material.WAXED_WEATHERED_CHISELED_COPPER, Material.COPPER_INGOT, 4},
            {Material.WAXED_OXIDIZED_CHISELED_COPPER, Material.COPPER_INGOT, 4},

			// Copper Grate
            {Material.COPPER_GRATE, Material.COPPER_INGOT, 4},
            {Material.EXPOSED_COPPER_GRATE, Material.COPPER_INGOT, 4},
            {Material.WEATHERED_COPPER_GRATE, Material.COPPER_INGOT, 4},
            {Material.OXIDIZED_COPPER_GRATE, Material.COPPER_INGOT, 4},
            {Material.WAXED_COPPER_GRATE, Material.COPPER_INGOT, 4},
            {Material.WAXED_EXPOSED_COPPER_GRATE, Material.COPPER_INGOT, 4},
            {Material.WAXED_WEATHERED_COPPER_GRATE, Material.COPPER_INGOT, 4},
            {Material.WAXED_OXIDIZED_COPPER_GRATE, Material.COPPER_INGOT, 4},

			// Copper Bulb
            {Material.COPPER_BULB, Material.COPPER_INGOT, 3},
            {Material.EXPOSED_COPPER_BULB, Material.COPPER_INGOT, 3},
            {Material.WEATHERED_COPPER_BULB, Material.COPPER_INGOT, 3},
            {Material.OXIDIZED_COPPER_BULB, Material.COPPER_INGOT, 3},
            {Material.WAXED_COPPER_BULB, Material.COPPER_INGOT, 3},
            {Material.WAXED_EXPOSED_COPPER_BULB, Material.COPPER_INGOT, 3},
            {Material.WAXED_WEATHERED_COPPER_BULB, Material.COPPER_INGOT, 3},
            {Material.WAXED_OXIDIZED_COPPER_BULB, Material.COPPER_INGOT, 3}
		};
		// @formatter:on

		for (Object[] recipe : metalRecycling) {
			Material input = (Material) recipe[0];
			Material output = (Material) recipe[1];

			int amount = (int) recipe[2];

			manager.addSmeltingAndBlasting(input.name().toLowerCase() + "_recycling", input, output, amount, 0.5f, 200, 100);
		}
	}

	private void registerWoodRecycling() {
		// @formatter:off
		Material[][] woodTypes = {
			{ Material.ACACIA_SLAB, Material.ACACIA_STAIRS, Material.ACACIA_PLANKS },
			{ Material.BAMBOO_MOSAIC_SLAB, Material.BAMBOO_MOSAIC_STAIRS, Material.BAMBOO_MOSAIC },
			{ Material.BAMBOO_SLAB, Material.BAMBOO_STAIRS, Material.BAMBOO_PLANKS },
			{ Material.BIRCH_SLAB, Material.BIRCH_STAIRS, Material.BIRCH_PLANKS },
			{ Material.CHERRY_SLAB, Material.CHERRY_STAIRS, Material.CHERRY_PLANKS },
			{ Material.CRIMSON_SLAB, Material.CRIMSON_STAIRS, Material.CRIMSON_PLANKS },
			{ Material.DARK_OAK_SLAB, Material.DARK_OAK_STAIRS, Material.DARK_OAK_PLANKS },
			{ Material.JUNGLE_SLAB, Material.JUNGLE_STAIRS, Material.JUNGLE_PLANKS },
			{ Material.MANGROVE_SLAB, Material.MANGROVE_STAIRS, Material.MANGROVE_PLANKS },
			{ Material.OAK_SLAB, Material.OAK_STAIRS, Material.OAK_PLANKS },
			{ Material.SPRUCE_SLAB, Material.SPRUCE_STAIRS, Material.SPRUCE_PLANKS },
			{ Material.WARPED_SLAB, Material.WARPED_STAIRS, Material.WARPED_PLANKS },
		};
		// @formatter:on

		for (Material[] wood : woodTypes) {
			String baseName = wood[2].name().toLowerCase();

			// 2 Slabs -> 1 Plank
			manager.addShapeless(baseName + "_from_slabs", wood[2], 1, wood[0], wood[0]);

			// 4 Stairs -> 3 Planks
			manager.addShapeless(baseName + "_from_stairs", wood[2], 3, wood[1], wood[1], wood[1], wood[1]);
		}
	}

	private void registerStoneRecycling() {
		// @formatter:off
		Material[][] stoneTypes = {
			// Basic
			{ Material.COBBLESTONE_SLAB, Material.COBBLESTONE_STAIRS, Material.COBBLESTONE },
			{ Material.STONE_BRICK_SLAB, Material.STONE_BRICK_STAIRS, Material.STONE_BRICKS },
			{ Material.ANDESITE_SLAB, Material.ANDESITE_STAIRS, Material.ANDESITE },
			{ Material.POLISHED_ANDESITE_SLAB, Material.POLISHED_ANDESITE_STAIRS, Material.POLISHED_ANDESITE },
			{ Material.DIORITE_SLAB, Material.DIORITE_STAIRS, Material.DIORITE },
			{ Material.POLISHED_DIORITE_SLAB, Material.POLISHED_DIORITE_STAIRS, Material.POLISHED_DIORITE },
			{ Material.GRANITE_SLAB, Material.GRANITE_STAIRS, Material.GRANITE },
			{ Material.POLISHED_GRANITE_SLAB, Material.POLISHED_GRANITE_STAIRS, Material.POLISHED_GRANITE },

			// Deepslate
			{ Material.COBBLED_DEEPSLATE_SLAB, Material.COBBLED_DEEPSLATE_STAIRS, Material.COBBLED_DEEPSLATE },
			{ Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_STAIRS, Material.POLISHED_DEEPSLATE },
			{ Material.DEEPSLATE_BRICK_SLAB, Material.DEEPSLATE_BRICK_STAIRS, Material.DEEPSLATE_BRICKS },
			{ Material.DEEPSLATE_TILE_SLAB, Material.DEEPSLATE_TILE_STAIRS, Material.DEEPSLATE_TILES },

			// Nether
			{ Material.BLACKSTONE_SLAB, Material.BLACKSTONE_STAIRS, Material.BLACKSTONE },
			{ Material.POLISHED_BLACKSTONE_SLAB, Material.POLISHED_BLACKSTONE_STAIRS, Material.POLISHED_BLACKSTONE },
			{ Material.POLISHED_BLACKSTONE_BRICK_SLAB, Material.POLISHED_BLACKSTONE_BRICK_STAIRS, Material.POLISHED_BLACKSTONE_BRICKS },
			{ Material.NETHER_BRICK_SLAB, Material.NETHER_BRICK_STAIRS, Material.NETHER_BRICKS },
			{ Material.RED_NETHER_BRICK_SLAB, Material.RED_NETHER_BRICK_STAIRS, Material.RED_NETHER_BRICKS },

			// End
			{ Material.END_STONE_BRICK_SLAB, Material.END_STONE_BRICK_STAIRS, Material.END_STONE_BRICKS },
			{ Material.PURPUR_SLAB, Material.PURPUR_STAIRS, Material.PURPUR_BLOCK },

			// Tuff
			{ Material.TUFF_SLAB, Material.TUFF_STAIRS, Material.TUFF },
			{ Material.POLISHED_TUFF_SLAB, Material.POLISHED_TUFF_STAIRS, Material.POLISHED_TUFF },
			{ Material.TUFF_BRICK_SLAB, Material.TUFF_BRICK_STAIRS, Material.TUFF_BRICKS },

			// Misc
			{ Material.PRISMARINE_SLAB, Material.PRISMARINE_STAIRS, Material.PRISMARINE },
			{ Material.PRISMARINE_BRICK_SLAB, Material.PRISMARINE_BRICK_STAIRS, Material.PRISMARINE_BRICKS },
			{ Material.DARK_PRISMARINE_SLAB, Material.DARK_PRISMARINE_STAIRS, Material.DARK_PRISMARINE },
			{ Material.SANDSTONE_SLAB, Material.SANDSTONE_STAIRS, Material.SANDSTONE },
			{ Material.SMOOTH_SANDSTONE_SLAB, Material.SMOOTH_SANDSTONE_STAIRS, Material.SMOOTH_SANDSTONE },
			{ Material.RED_SANDSTONE_SLAB, Material.RED_SANDSTONE_STAIRS, Material.RED_SANDSTONE },
			{ Material.SMOOTH_RED_SANDSTONE_SLAB, Material.SMOOTH_RED_SANDSTONE_STAIRS, Material.SMOOTH_RED_SANDSTONE },
			{ Material.QUARTZ_SLAB, Material.QUARTZ_STAIRS, Material.QUARTZ_BLOCK },
			{ Material.SMOOTH_QUARTZ_SLAB, Material.SMOOTH_QUARTZ_STAIRS, Material.SMOOTH_QUARTZ },
			{ Material.MUD_BRICK_SLAB, Material.MUD_BRICK_STAIRS, Material.MUD_BRICKS }
		};
		// @formatter:on

		for (Material[] stone : stoneTypes) {
			String baseName = stone[2].name().toLowerCase();

			// 2 Slabs -> 1 Block
			manager.addShapeless(baseName + "_from_slabs", stone[2], 1, stone[0], stone[0]);

			// 4 Stairs -> 3 Blocks
			manager.addShapeless(baseName + "_from_stairs", stone[2], 3, stone[1], stone[1], stone[1], stone[1]);
		}

		// Stonecutter Crushing
		manager.addStonecutting("crush_cobble_to_gravel", Material.COBBLESTONE, Material.GRAVEL, 1);
		manager.addStonecutting("crush_gravel_to_sand", Material.GRAVEL, Material.SAND, 1);
	}

	private void registerLeatherRecycling() {
		// Leather Armor Recycling
		// @formatter:off
		Object[][] leatherRecycling = {
			{ Material.LEATHER_CHESTPLATE, Material.LEATHER, 4 },
			{ Material.LEATHER_LEGGINGS, Material.LEATHER, 3 },
			{ Material.LEATHER_HELMET, Material.LEATHER, 2 },
			{ Material.LEATHER_BOOTS, Material.LEATHER, 2 },
			{ Material.LEATHER_HORSE_ARMOR, Material.LEATHER, 3 },
		};
		// @formatter:on

		for (Object[] recipe : leatherRecycling) {
			Material input = (Material) recipe[0];
			Material output = (Material) recipe[1];

			int amount = (int) recipe[2];

			manager.addStonecutting(input.name().toLowerCase() + "_recycling", input, output, amount);
		}
	}

	private void registerBleaching() {
		// Bleach colored items back to white
		// @formatter:off
		Object[][] washableItems = {
			{ Material.BLACK_WOOL, Material.WHITE_WOOL },
			{ Material.BLUE_WOOL, Material.WHITE_WOOL },
			{ Material.BROWN_WOOL, Material.WHITE_WOOL },
			{ Material.CYAN_WOOL, Material.WHITE_WOOL },
			{ Material.GRAY_WOOL, Material.WHITE_WOOL },
			{ Material.GREEN_WOOL, Material.WHITE_WOOL },
			{ Material.LIGHT_BLUE_WOOL, Material.WHITE_WOOL },
			{ Material.LIGHT_GRAY_WOOL, Material.WHITE_WOOL },
			{ Material.LIME_WOOL, Material.WHITE_WOOL },
			{ Material.MAGENTA_WOOL, Material.WHITE_WOOL },
			{ Material.ORANGE_WOOL, Material.WHITE_WOOL },
			{ Material.PINK_WOOL, Material.WHITE_WOOL },
			{ Material.PURPLE_WOOL, Material.WHITE_WOOL },
			{ Material.RED_WOOL, Material.WHITE_WOOL },
			{ Material.YELLOW_WOOL, Material.WHITE_WOOL },

			// Carpets
			{ Material.BLACK_CARPET, Material.WHITE_CARPET },
			{ Material.BLUE_CARPET, Material.WHITE_CARPET },
			{ Material.BROWN_CARPET, Material.WHITE_CARPET },
			{ Material.CYAN_CARPET, Material.WHITE_CARPET },
			{ Material.GRAY_CARPET, Material.WHITE_CARPET },
			{ Material.GREEN_CARPET, Material.WHITE_CARPET },
			{ Material.LIGHT_BLUE_CARPET, Material.WHITE_CARPET },
			{ Material.LIGHT_GRAY_CARPET, Material.WHITE_CARPET },
			{ Material.LIME_CARPET, Material.WHITE_CARPET },
			{ Material.MAGENTA_CARPET, Material.WHITE_CARPET },
			{ Material.ORANGE_CARPET, Material.WHITE_CARPET },
			{ Material.PINK_CARPET, Material.WHITE_CARPET },
			{ Material.PURPLE_CARPET, Material.WHITE_CARPET },
			{ Material.RED_CARPET, Material.WHITE_CARPET },
			{ Material.YELLOW_CARPET, Material.WHITE_CARPET },

			// Glass
			{ Material.BLACK_STAINED_GLASS, Material.GLASS },
			{ Material.BLUE_STAINED_GLASS, Material.GLASS },
			{ Material.BROWN_STAINED_GLASS, Material.GLASS },
			{ Material.CYAN_STAINED_GLASS, Material.GLASS },
			{ Material.GRAY_STAINED_GLASS, Material.GLASS },
			{ Material.GREEN_STAINED_GLASS, Material.GLASS },
			{ Material.LIGHT_BLUE_STAINED_GLASS, Material.GLASS },
			{ Material.LIGHT_GRAY_STAINED_GLASS, Material.GLASS },
			{ Material.LIME_STAINED_GLASS, Material.GLASS },
			{ Material.MAGENTA_STAINED_GLASS, Material.GLASS },
			{ Material.ORANGE_STAINED_GLASS, Material.GLASS },
			{ Material.PINK_STAINED_GLASS, Material.GLASS },
			{ Material.PURPLE_STAINED_GLASS, Material.GLASS },
			{ Material.RED_STAINED_GLASS, Material.GLASS },
			{ Material.YELLOW_STAINED_GLASS, Material.GLASS },

			// Beds
			{ Material.BLACK_BED, Material.WHITE_BED },
			{ Material.BLUE_BED, Material.WHITE_BED },
			{ Material.BROWN_BED, Material.WHITE_BED },
			{ Material.CYAN_BED, Material.WHITE_BED },
			{ Material.GRAY_BED, Material.WHITE_BED },
			{ Material.GREEN_BED, Material.WHITE_BED },
			{ Material.LIGHT_BLUE_BED, Material.WHITE_BED },
			{ Material.LIGHT_GRAY_BED, Material.WHITE_BED },
			{ Material.LIME_BED, Material.WHITE_BED },
			{ Material.MAGENTA_BED, Material.WHITE_BED },
			{ Material.ORANGE_BED, Material.WHITE_BED },
			{ Material.PINK_BED, Material.WHITE_BED },
			{ Material.PURPLE_BED, Material.WHITE_BED },
			{ Material.RED_BED, Material.WHITE_BED },
			{ Material.YELLOW_BED, Material.WHITE_BED },

			// Terracotta
			{ Material.BLACK_TERRACOTTA, Material.TERRACOTTA },
			{ Material.BLUE_TERRACOTTA, Material.TERRACOTTA },
			{ Material.BROWN_TERRACOTTA, Material.TERRACOTTA },
			{ Material.CYAN_TERRACOTTA, Material.TERRACOTTA },
			{ Material.GRAY_TERRACOTTA, Material.TERRACOTTA },
			{ Material.GREEN_TERRACOTTA, Material.TERRACOTTA },
			{ Material.LIGHT_BLUE_TERRACOTTA, Material.TERRACOTTA },
			{ Material.LIGHT_GRAY_TERRACOTTA, Material.TERRACOTTA },
			{ Material.LIME_TERRACOTTA, Material.TERRACOTTA },
			{ Material.MAGENTA_TERRACOTTA, Material.TERRACOTTA },
			{ Material.ORANGE_TERRACOTTA, Material.TERRACOTTA },
			{ Material.PINK_TERRACOTTA, Material.TERRACOTTA },
			{ Material.PURPLE_TERRACOTTA, Material.TERRACOTTA },
			{ Material.RED_TERRACOTTA, Material.TERRACOTTA },
			{ Material.YELLOW_TERRACOTTA, Material.TERRACOTTA },

			// Concrete
			{ Material.BLACK_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.BLUE_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.BROWN_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.CYAN_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.GRAY_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.GREEN_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.LIGHT_BLUE_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.LIGHT_GRAY_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.LIME_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.MAGENTA_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.ORANGE_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.PINK_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.PURPLE_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.RED_CONCRETE, Material.WHITE_CONCRETE },
			{ Material.YELLOW_CONCRETE, Material.WHITE_CONCRETE }
		};
		// @formatter:on

		for (Object[] washItem : washableItems) {
			Material input = (Material) washItem[0];
			Material output = (Material) washItem[1];

			// 1 Item + 1 Water Bucket -> 1 Clean Item
			manager.addShapeless("wash_" + input.name().toLowerCase(), output, 1, input, Material.WATER_BUCKET);

			// 8 Items + 1 Water Bucket -> 8 Clean Items
			manager.addShapeless("wash_bulk_" + input.name().toLowerCase(), output, 8, input, input, input, input, input, input, input, input, Material.WATER_BUCKET);
		}
	}

	private void registerBlockUncrafting() {
		// Break down 1 assembled block back into 4 base materials
		manager.addShapeless("uncraft_quartz_block", Material.QUARTZ, 4, Material.QUARTZ_BLOCK);
		manager.addShapeless("uncraft_clay_block", Material.CLAY_BALL, 4, Material.CLAY);
		manager.addShapeless("uncraft_amethyst_block", Material.AMETHYST_SHARD, 4, Material.AMETHYST_BLOCK);
		manager.addShapeless("uncraft_glowstone", Material.GLOWSTONE_DUST, 4, Material.GLOWSTONE);
		manager.addShapeless("uncraft_magma_block", Material.MAGMA_CREAM, 4, Material.MAGMA_BLOCK);
		manager.addShapeless("uncraft_honeycomb_block", Material.HONEYCOMB, 4, Material.HONEYCOMB_BLOCK);
		manager.addShapeless("uncraft_snow_block", Material.SNOWBALL, 4, Material.SNOW_BLOCK);
		manager.addShapeless("uncraft_brick_block", Material.BRICK, 4, Material.BRICKS);
		manager.addShapeless("uncraft_nether_brick_block", Material.NETHER_BRICK, 4, Material.NETHER_BRICKS);

		// Ice Uncrafting
		manager.addSmeltingAndBlasting("uncraft_blue_ice", Material.BLUE_ICE, Material.PACKED_ICE, 9, 0.1f, 100, 50);
		manager.addSmeltingAndBlasting("uncraft_packed_ice", Material.PACKED_ICE, Material.ICE, 9, 0.1f, 100, 50);

		// 1 Block to 9 items
		manager.addShapeless("uncraft_melon", Material.MELON_SLICE, 9, Material.MELON);
		manager.addShapeless("uncraft_nether_wart_block", Material.NETHER_WART, 9, Material.NETHER_WART_BLOCK);
	}

	private void registerBulkSmelting() {
		// Smelt raw ore blocks into blocks
		// @formatter:off
		Object[][] bulkSmelting = {
			{ Material.RAW_IRON_BLOCK, Material.IRON_BLOCK },
			{ Material.RAW_GOLD_BLOCK, Material.GOLD_BLOCK },
			{ Material.RAW_COPPER_BLOCK, Material.COPPER_BLOCK },
		};
		// @formatter:on

		for (Object[] recipe : bulkSmelting) {
			Material input = (Material) recipe[0];
			Material output = (Material) recipe[1];

			manager.addSmeltingAndBlasting(input.name().toLowerCase() + "_bulk", input, output, 1, 6.3f, 1800, 900);
		}
	}

	private void registerMisc() {
		// Rotten Flesh to Leather
		manager.addSmoking("flesh_to_leather", Material.ROTTEN_FLESH, Material.LEATHER, 1, 0.1f, 150);

		// Gravel to Flint
		manager.addSmeltingAndBlasting("gravel_to_flint", Material.GRAVEL, Material.FLINT, 1, 0.1f, 200, 100);

		// Honeycomb to Honey
		manager.addShapeless("honey_from_comb", Material.HONEY_BOTTLE, 1, Material.HONEYCOMB, Material.GLASS_BOTTLE);

		// Poisonous Potato to Green Dye
		manager.addSmeltingAndBlasting("dye_from_potato", Material.POISONOUS_POTATO, Material.GREEN_DYE, 1, 0.1f, 200, 100);

		// Coal to Black Dye
		manager.addShapeless("dye_from_coal", Material.BLACK_DYE, 2, Material.COAL);
		manager.addShapeless("dye_from_charcoal", Material.BLACK_DYE, 2, Material.CHARCOAL);

		// Name Tags and Saddles
		manager.addShapeless("craft_nametag", Material.NAME_TAG, 1, Material.STRING, Material.PAPER, Material.IRON_NUGGET);
		manager.addShapeless("craft_saddle", Material.SADDLE, 1, Material.LEATHER, Material.LEATHER, Material.LEATHER, Material.LEATHER, Material.LEATHER, Material.IRON_INGOT, Material.IRON_INGOT,
				Material.TRIPWIRE_HOOK);

		// Glasscutting
		manager.addStonecutting("cut_glass_to_panes", Material.GLASS, Material.GLASS_PANE, 2);
	}
}
