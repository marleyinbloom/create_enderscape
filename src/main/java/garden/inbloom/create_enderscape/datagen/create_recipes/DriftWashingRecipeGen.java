package garden.inbloom.create_enderscape.datagen.create_recipes;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.simibubi.create.api.data.recipe.WashingRecipeGen;

import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.register.DriftItems;
import net.bunten.enderscape.registry.EnderscapeItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public class DriftWashingRecipeGen extends WashingRecipeGen {
	
	GeneratedRecipe CRUSHED_SHADOLINE = crushedOre(DriftItems.CRUSHED_RAW_SHADOLINE.get(), () -> DriftItems.SHADOLINE_NUGGET.get(),
			() -> EnderscapeItems.RUBBLE_CHITIN.get(), .125f);

	public DriftWashingRecipeGen(PackOutput output, CompletableFuture<Provider> registries, String defaultNamespace) {
		super(output, registries, defaultNamespace);
	}
	
	public GeneratedRecipe crushedOre(Item crushed, Supplier<ItemLike> nugget, Supplier<ItemLike> secondary,
			float secondaryChance) {
		return create(Drift.ID, () -> crushed, b -> b.output(nugget.get(), 9)
			.output(secondaryChance, secondary.get(), 1));
	}
}
