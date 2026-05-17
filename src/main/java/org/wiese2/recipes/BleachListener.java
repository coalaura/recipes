package org.wiese2.recipes;

import java.util.EnumMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class BleachListener implements Listener {

	private final RecipeManager manager;

	private final Map<Material, Material> bleachMap = new EnumMap<>(Material.class);

	public BleachListener(RecipeManager manager) {
		this.manager = manager;

		// Wool
		registerGroup(Material.WHITE_WOOL, Material.BLACK_WOOL, Material.BLUE_WOOL, Material.BROWN_WOOL, Material.CYAN_WOOL, Material.GRAY_WOOL, Material.GREEN_WOOL, Material.LIGHT_BLUE_WOOL, Material.LIGHT_GRAY_WOOL,
				Material.LIME_WOOL, Material.MAGENTA_WOOL, Material.ORANGE_WOOL, Material.PINK_WOOL, Material.PURPLE_WOOL, Material.RED_WOOL, Material.YELLOW_WOOL);

		// Carpets
		registerGroup(Material.WHITE_CARPET, Material.BLACK_CARPET, Material.BLUE_CARPET, Material.BROWN_CARPET, Material.CYAN_CARPET, Material.GRAY_CARPET, Material.GREEN_CARPET, Material.LIGHT_BLUE_CARPET,
				Material.LIGHT_GRAY_CARPET, Material.LIME_CARPET, Material.MAGENTA_CARPET, Material.ORANGE_CARPET, Material.PINK_CARPET, Material.PURPLE_CARPET, Material.RED_CARPET, Material.YELLOW_CARPET);

		// Glass
		registerGroup(Material.GLASS, Material.BLACK_STAINED_GLASS, Material.BLUE_STAINED_GLASS, Material.BROWN_STAINED_GLASS, Material.CYAN_STAINED_GLASS, Material.GRAY_STAINED_GLASS, Material.GREEN_STAINED_GLASS,
				Material.LIGHT_BLUE_STAINED_GLASS, Material.LIGHT_GRAY_STAINED_GLASS, Material.LIME_STAINED_GLASS, Material.MAGENTA_STAINED_GLASS, Material.ORANGE_STAINED_GLASS, Material.PINK_STAINED_GLASS,
				Material.PURPLE_STAINED_GLASS, Material.RED_STAINED_GLASS, Material.YELLOW_STAINED_GLASS);

		// Beds
		registerGroup(Material.WHITE_BED, Material.BLACK_BED, Material.BLUE_BED, Material.BROWN_BED, Material.CYAN_BED, Material.GRAY_BED, Material.GREEN_BED, Material.LIGHT_BLUE_BED, Material.LIGHT_GRAY_BED,
				Material.LIME_BED, Material.MAGENTA_BED, Material.ORANGE_BED, Material.PINK_BED, Material.PURPLE_BED, Material.RED_BED, Material.YELLOW_BED);

		// Terracotta
		registerGroup(Material.TERRACOTTA, Material.BLACK_TERRACOTTA, Material.BLUE_TERRACOTTA, Material.BROWN_TERRACOTTA, Material.CYAN_TERRACOTTA, Material.GRAY_TERRACOTTA, Material.GREEN_TERRACOTTA,
				Material.LIGHT_BLUE_TERRACOTTA, Material.LIGHT_GRAY_TERRACOTTA, Material.LIME_TERRACOTTA, Material.MAGENTA_TERRACOTTA, Material.ORANGE_TERRACOTTA, Material.PINK_TERRACOTTA, Material.PURPLE_TERRACOTTA,
				Material.RED_TERRACOTTA, Material.YELLOW_TERRACOTTA);

		// Concrete
		registerGroup(Material.WHITE_CONCRETE, Material.BLACK_CONCRETE, Material.BLUE_CONCRETE, Material.BROWN_CONCRETE, Material.CYAN_CONCRETE, Material.GRAY_CONCRETE, Material.GREEN_CONCRETE,
				Material.LIGHT_BLUE_CONCRETE, Material.LIGHT_GRAY_CONCRETE, Material.LIME_CONCRETE, Material.MAGENTA_CONCRETE, Material.ORANGE_CONCRETE, Material.PINK_CONCRETE, Material.PURPLE_CONCRETE,
				Material.RED_CONCRETE, Material.YELLOW_CONCRETE);

		// Glass Panes
		registerGroup(Material.GLASS_PANE, Material.BLACK_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE,
				Material.GREEN_STAINED_GLASS_PANE, Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.LIGHT_GRAY_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE, Material.MAGENTA_STAINED_GLASS_PANE,
				Material.ORANGE_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.RED_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS_PANE);

		// Candles
		registerGroup(Material.CANDLE, Material.WHITE_CANDLE, Material.ORANGE_CANDLE, Material.MAGENTA_CANDLE, Material.LIGHT_BLUE_CANDLE, Material.YELLOW_CANDLE, Material.LIME_CANDLE, Material.PINK_CANDLE,
				Material.GRAY_CANDLE, Material.LIGHT_GRAY_CANDLE, Material.CYAN_CANDLE, Material.PURPLE_CANDLE, Material.BLUE_CANDLE, Material.BROWN_CANDLE, Material.GREEN_CANDLE, Material.RED_CANDLE,
				Material.BLACK_CANDLE);
	}

	private void registerGroup(Material output, Material... inputs) {
		for (Material input : inputs) {
			bleachMap.put(input, output);
		}
	}

	@EventHandler
	public void onCauldronWash(PlayerInteractEvent event) {
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}

		if (event.getHand() != EquipmentSlot.HAND) {
			return;
		}

		Block block = event.getClickedBlock();

		if (block == null || block.getType() != Material.WATER_CAULDRON) {
			return;
		}

		Player player = event.getPlayer();

		if (player.isSneaking()) {
			return;
		}

		ItemStack item = event.getItem();

		if (item == null || !bleachMap.containsKey(item.getType())) {
			return;
		}

		event.setCancelled(true);

		Material cleanMaterial = bleachMap.get(item.getType());

		player.getInventory().setItemInMainHand(manager.stackWithType(item, cleanMaterial));
		player.updateInventory();

		Levelled cauldronData = (Levelled) block.getBlockData();

		if (cauldronData.getLevel() > 1) {
			cauldronData.setLevel(cauldronData.getLevel() - 1);

			block.setBlockData(cauldronData);
		} else {
			block.setType(Material.CAULDRON);
		}
	}
}
