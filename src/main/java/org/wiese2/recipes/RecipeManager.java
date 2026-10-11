package org.wiese2.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
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
	private final List<NamespacedKey> recipeKeys = new ArrayList<>();

	public RecipeManager(Plugin plugin) {
		this.plugin = plugin;
	}

	public int getRecipeCount() {
		return recipeKeys.size();
	}

	public void discoverRecipes(Player player) {
		player.discoverRecipes(recipeKeys);
	}

	public void verifyRecipes(String phase) {
		int missingCount = 0;

		NamespacedKey firstMissing = null;

		for (NamespacedKey key : recipeKeys) {
			if (Bukkit.getRecipe(key) != null) {
				continue;
			}

			missingCount++;

			if (firstMissing == null) {
				firstMissing = key;
			}
		}

		int availableCount = recipeKeys.size() - missingCount;

		String message = "Recipe registry check after " + phase + ": " + availableCount + "/" + recipeKeys.size() + " recipes available.";

		if (missingCount > 0) {
			plugin.getLogger().severe(message + " Previously registered recipes have been removed. First missing recipe: " + firstMissing);
		} else {
			plugin.getLogger().info(message);
		}
	}

	public Material resolveMaterial(Object input) {
		if (input instanceof Material material) {
			return material;
		} else if (input instanceof String string) {
			return Material.matchMaterial(string);
		}

		return null;
	}

	public ItemStack stackWithType(ItemStack input, Material type) {
		ItemStack stack = new ItemStack(type, input.getAmount());

		if (input.hasItemMeta()) {
			stack.setItemMeta(input.getItemMeta());
		}

		return stack;
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

		registerRecipe(furnaceRecipe);

		// Blast Furnace (usually twice as fast)
		NamespacedKey blastKey = new NamespacedKey(plugin, id + "_blasting");
		BlastingRecipe blastingRecipe = new BlastingRecipe(blastKey, result, input, exp, blastTime);

		registerRecipe(blastingRecipe);
	}

	/**
	 * Copies an existing vanilla furnace recipe to the blast furnace at twice the
	 * speed.
	 */
	public void addBlastingFromSmelting(String furnaceRecipeId) {
		NamespacedKey furnaceKey = NamespacedKey.minecraft(furnaceRecipeId);
		Recipe source = Bukkit.getRecipe(furnaceKey);

		if (!(source instanceof FurnaceRecipe furnaceRecipe)) {
			plugin.getLogger().warning("Cannot create blast furnace recipe: " + furnaceKey + " is missing or is not a furnace recipe.");

			return;
		}

		NamespacedKey blastKey = new NamespacedKey(plugin, furnaceRecipeId + "_blasting");

		int blastTime = Math.max(1, furnaceRecipe.getCookingTime() / 2);

		BlastingRecipe blastingRecipe = new BlastingRecipe(blastKey, furnaceRecipe.getResult(), furnaceRecipe.getInputChoice(), furnaceRecipe.getExperience(), blastTime);

		blastingRecipe.setGroup(furnaceRecipe.getGroup());
		blastingRecipe.setCategory(furnaceRecipe.getCategory());

		registerRecipe(blastingRecipe);
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

		registerRecipe(recipe);
	}

	/**
	 * Registers a Stonecutter recipe.
	 */
	public void addStonecutting(String id, Material input, Material output, int amount) {
		NamespacedKey key = new NamespacedKey(plugin, id + "_stonecutting");
		ItemStack result = new ItemStack(output, amount);

		StonecuttingRecipe recipe = new StonecuttingRecipe(key, result, input);

		registerRecipe(recipe);
	}

	/**
	 * Registers a Smoker recipe.
	 */
	public void addSmoking(String id, Material input, Material output, int amount, float exp, int cookTime) {
		NamespacedKey key = new NamespacedKey(plugin, id + "_smoking");
		ItemStack result = new ItemStack(output, amount);

		SmokingRecipe recipe = new SmokingRecipe(key, result, input, exp, cookTime);

		registerRecipe(recipe);
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

	private <T extends Recipe & Keyed> void registerRecipe(T recipe) {
		if (!Bukkit.addRecipe(recipe)) {
			plugin.getLogger().warning("Failed to register recipe " + recipe.getKey());

			return;
		}

		if (Bukkit.getRecipe(recipe.getKey()) == null) {
			plugin.getLogger().severe("Server accepted recipe " + recipe.getKey() + " but it is missing from the recipe registry.");

			return;
		}

		recipeKeys.add(recipe.getKey());
	}
}
