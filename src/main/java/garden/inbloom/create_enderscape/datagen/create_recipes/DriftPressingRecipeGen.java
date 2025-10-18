package garden.inbloom.create_enderscape.datagen.create_recipes;

import java.util.concurrent.CompletableFuture;

import com.simibubi.create.api.data.recipe.PressingRecipeGen;

import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.register.DriftItems;
import net.bunten.enderscape.registry.EnderscapeItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;

public class DriftPressingRecipeGen extends PressingRecipeGen {
	
	GeneratedRecipe 
		CRACKED_MIRROR = create(Drift.ID, () -> EnderscapeItems.MIRROR.get(), b -> b.output(EnderscapeItems.CRACKED_MIRROR.get())),
		
		SHADOLINE_SHEET = create(Drift.ID, () -> EnderscapeItems.SHADOLINE_INGOT.get(), b -> b.output(DriftItems.SHADOLINE_SHEET.get()));;

	public DriftPressingRecipeGen(PackOutput output, CompletableFuture<Provider> registries, String defaultNamespace) {
		super(output, registries, defaultNamespace);
	}

}
