package org.wiese2.recipes;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Recipes extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();

        getLogger().info("Recipes started...");

        RecipeManager recipeManager = new RecipeManager(this);

        RecipeDefinitions definitions = new RecipeDefinitions(recipeManager);

        definitions.registerAll();

        pluginManager.registerEvents(new BleachListener(recipeManager), this);
        pluginManager.registerEvents(new StonecutterListener(), this);

        getLogger().info("Recipes ready!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Recipes shutting down...");
    }
}
