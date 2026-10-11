package org.wiese2.recipes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

import io.papermc.paper.event.server.ServerResourcesReloadedEvent;

public class RecipeRegistryListener implements Listener {

	private final RecipeManager manager;

	public RecipeRegistryListener(RecipeManager manager) {
		this.manager = manager;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onServerLoad(ServerLoadEvent event) {
		manager.verifyRecipes("server load (" + event.getType() + ")");
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onResourcesReloaded(ServerResourcesReloadedEvent event) {
		manager.verifyRecipes("resource reload (" + event.getCause() + ")");
	}
}
