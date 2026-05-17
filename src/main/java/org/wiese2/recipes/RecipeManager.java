package org.wiese2.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmokingRecipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import io.papermc.paper.potion.PotionMix;

public class RecipeManager {
	private final Plugin plugin;

	public RecipeManager(Plugin plugin) {
		this.plugin = plugin;
	}

	/**
	 * Registers both a furnace and blast furnace recipe at once.
	 */
	public void addSmeltingAndBlasting(String id, Material input, Material output, int amount, float exp, int smeltTime, int blastTime) {
		List<NamespacedKey> remove = new ArrayList<>();
		Iterator<Recipe> iterator = Bukkit.recipeIterator();

		while (iterator.hasNext()) {
			Recipe exists = iterator.next();

			if (exists instanceof FurnaceRecipe || exists instanceof BlastingRecipe) {
				CookingRecipe<?> recipe = (CookingRecipe<?>) exists;

				if (recipe.getInputChoice().test(new ItemStack(input))) {
					NamespacedKey key = ((org.bukkit.Keyed) exists).getKey();

					if (!key.getNamespace().equals(plugin.getName().toLowerCase())) {
						remove.add(key);
					}
				}
			}
		}

		for (NamespacedKey key : remove) {
			Bukkit.removeRecipe(key);
		}

		ItemStack result = new ItemStack(output, amount);

		// Standard Furnace
		NamespacedKey smeltKey = new NamespacedKey(plugin, id + "_smelting");
		FurnaceRecipe furnaceRecipe = new FurnaceRecipe(smeltKey, result, input, exp, smeltTime);

		Bukkit.addRecipe(furnaceRecipe);

		// Blast Furnace (usually twice as fast)
		NamespacedKey blastKey = new NamespacedKey(plugin, id + "_blasting");
		BlastingRecipe blastingRecipe = new BlastingRecipe(blastKey, result, input, exp, blastTime);

		Bukkit.addRecipe(blastingRecipe);
	}

	/**
	 * Registers a shapeless crafting recipe.
	 */
	public void addShapeless(String id, Material output, int amount, Material... ingredients) {
		NamespacedKey key = new NamespacedKey(plugin, id);
		ItemStack result = new ItemStack(output, amount);
		ShapelessRecipe recipe = new ShapelessRecipe(key, result);

		for (Material mat : ingredients) {
			recipe.addIngredient(mat);
		}

		Bukkit.addRecipe(recipe);
	}

	/**
	 * Registers a Stonecutter recipe.
	 */
	public void addStonecutting(String id, Material input, Material output, int amount) {
		NamespacedKey key = new NamespacedKey(plugin, id + "_stonecutting");
		ItemStack result = new ItemStack(output, amount);

		StonecuttingRecipe recipe = new StonecuttingRecipe(key, result, input);

		Bukkit.addRecipe(recipe);
	}

	/**
	 * Registers a Smoker recipe.
	 */
	public void addSmoking(String id, Material input, Material output, int amount, float exp, int cookTime) {
		NamespacedKey key = new NamespacedKey(plugin, id + "_smoking");
		ItemStack result = new ItemStack(output, amount);

		SmokingRecipe recipe = new SmokingRecipe(key, result, input, exp, cookTime);

		Bukkit.addRecipe(recipe);
	}

	/**
	 * Registers a Brewing Stand recipe.
	 */
	public void addBrewing(String id, Material ingredient, Material output, int amount) {
		NamespacedKey key = new NamespacedKey(plugin, id);
		ItemStack result = new ItemStack(output, amount);

		RecipeChoice inputChoice = new RecipeChoice.MaterialChoice(Material.GLASS_BOTTLE);
		RecipeChoice ingredientChoice = new RecipeChoice.MaterialChoice(ingredient);

		PotionMix mix = new PotionMix(key, result, inputChoice, ingredientChoice);

		Bukkit.getPotionBrewer().addPotionMix(mix);
	}
}
