package org.wiese2.recipes;

import org.bukkit.plugin.java.JavaPlugin;

public class Recipes extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Recipes started...");

        RecipeManager recipeManager = new RecipeManager(this);

        RecipeDefinitions definitions = new RecipeDefinitions(recipeManager);

        definitions.registerAll();

        getLogger().info("Recipes ready!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Recipes shutting down...");
    }
}
