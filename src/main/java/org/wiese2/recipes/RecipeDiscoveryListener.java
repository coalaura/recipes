package org.wiese2.recipes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class RecipeDiscoveryListener implements Listener {

	private final RecipeManager manager;

	public RecipeDiscoveryListener(RecipeManager manager) {
		this.manager = manager;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		manager.discoverRecipes(event.getPlayer());
	}
}
