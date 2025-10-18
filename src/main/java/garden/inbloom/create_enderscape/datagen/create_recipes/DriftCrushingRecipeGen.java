package garden.inbloom.create_enderscape.datagen.create_recipes;

import java.util.concurrent.CompletableFuture;

import com.simibubi.create.api.data.recipe.CrushingRecipeGen;

import garden.inbloom.create_enderscape.register.DriftItems;
import garden.inbloom.create_enderscape.register.DriftTags.DriftItemTags;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.EnderscapeItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

public class DriftCrushingRecipeGen extends CrushingRecipeGen {

	GeneratedRecipe 
	SHADOLINE_ORE = endStoneOre(EnderscapeBlocks.SHADOLINE_ORE.get(), 
		DriftItems.CRUSHED_RAW_SHADOLINE, 2.75f, 250),
	MIRE_SHADOLINE_ORE = mirestoneOre(EnderscapeBlocks.MIRESTONE_SHADOLINE_ORE.get(), 
		DriftItems.CRUSHED_RAW_SHADOLINE, 4.25f, 350),
	RAW_SHADOLINE = rawOre("shadoline", () -> DriftItemTags.RAW_MATERIALS_SHADOLINE.tag,
		() -> DriftItems.CRUSHED_RAW_SHADOLINE, 1),
	RAW_SHADOLINE_BLOCK = rawOreBlock("shadoline", () -> DriftItemTags.STORAGE_BLOCKS_RAW_SHADOLINE.tag,
		() -> DriftItems.CRUSHED_RAW_SHADOLINE, 1),
	
	NEBULITE_ORE = endStoneOre(EnderscapeBlocks.NEBULITE_ORE.get(), 
		EnderscapeItems.NEBULITE_SHARDS.get(), 3.5f, 350),
	MIRE_NEBULITE_ORE = mirestoneOre(EnderscapeBlocks.MIRESTONE_NEBULITE_ORE.get(), 
		EnderscapeItems.NEBULITE_SHARDS.get(), 4.75f, 450);
	
	public DriftCrushingRecipeGen(PackOutput output, CompletableFuture<Provider> registries, String defaultNamespace) {
		super(output, registries, defaultNamespace);
	}

	protected GeneratedRecipe endStoneOre(ItemLike ore, ItemLike raw, float expectedAmount,
			int duration) {
		return ore(Blocks.END_STONE, ()->ore, ()->raw, expectedAmount, duration);
	}
		
	protected GeneratedRecipe mirestoneOre(ItemLike ore, ItemLike raw, float expectedAmount,
			int duration) {
		return ore(EnderscapeBlocks.MIRESTONE.get(), ()->ore, ()->raw, expectedAmount, duration);
	}
	
}
