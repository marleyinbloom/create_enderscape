package garden.inbloom.create_enderscape.datagen.create_recipes;

import java.util.concurrent.CompletableFuture;

import com.simibubi.create.api.data.recipe.ItemApplicationRecipeGen;

import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftTags.DriftItemTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;

public class DriftItemApplicationRecipeGen extends ItemApplicationRecipeGen {

	GeneratedRecipe DUSK_CASING = woodCasingTag("dusk", () -> DriftItemTags.INGOTS_DUSK.tag,
		() -> DriftBlocks.DUSK_CASING.get().asItem());
	
	public DriftItemApplicationRecipeGen(PackOutput output, CompletableFuture<Provider> registries,
			String defaultNamespace) {
		super(output, registries, defaultNamespace);
	}

}
