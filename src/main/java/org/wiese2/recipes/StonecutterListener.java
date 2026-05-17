package org.wiese2.recipes;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.StonecutterInventory;

public class StonecutterListener implements Listener {

	@EventHandler
	public void onStonecutterClick(InventoryClickEvent event) {
		Inventory inventory = event.getInventory();

		if (!(inventory instanceof StonecutterInventory stonecutter)) {
			return;
		}

		if (event.getSlot() != 1) {
			return;
		}

		ItemStack input = stonecutter.getItem(0);

		if (input == null || input.getType() == Material.AIR) {
			return;
		}

		Material expected = switch (input.getType()) {
		case HOPPER_MINECART -> Material.HOPPER;
		case CHEST_MINECART -> Material.CHEST;
		case FURNACE_MINECART -> Material.FURNACE;
		default -> null;
		};

		ItemStack output = event.getCurrentItem();

		if (expected == null || output == null || output.getType() != expected) {
			return;
		}

		event.setCancelled(true);

		Player player = (Player) event.getWhoClicked();

		int amount = input.getAmount();

		if (amount == 1) {
			stonecutter.setItem(0, new ItemStack(Material.MINECART));
		} else {
			input.setAmount(amount - 1);

			stonecutter.setItem(0, input);

			HashMap<Integer, ItemStack> leftover = player.getInventory().addItem(new ItemStack(Material.MINECART));

			for (ItemStack drop : leftover.values()) {
				player.getWorld().dropItem(player.getLocation(), drop);
			}
		}

		ItemStack result = new ItemStack(expected);

		if (event.getClick().isShiftClick()) {
			HashMap<Integer, ItemStack> leftover = player.getInventory().addItem(result);

			for (ItemStack drop : leftover.values()) {
				player.getWorld().dropItem(player.getLocation(), drop);
			}
		} else {
			ItemStack cursor = event.getCursor();

			if (cursor == null || cursor.getType() == Material.AIR) {
				event.getView().setCursor(result);
			} else if (cursor.isSimilar(result) && cursor.getAmount() + result.getAmount() <= cursor.getMaxStackSize()) {
				cursor.setAmount(cursor.getAmount() + result.getAmount());

				event.getView().setCursor(cursor);
			} else {
				HashMap<Integer, ItemStack> leftover = player.getInventory().addItem(result);

				for (ItemStack drop : leftover.values()) {
					player.getWorld().dropItem(player.getLocation(), drop);
				}
			}
		}
	}
}
