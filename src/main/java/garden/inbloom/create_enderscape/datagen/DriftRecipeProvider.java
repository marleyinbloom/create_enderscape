package garden.inbloom.create_enderscape.datagen;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.ProcessingRecipeGen;
import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.datagen.create_recipes.DriftCrushingRecipeGen;
import garden.inbloom.create_enderscape.datagen.create_recipes.DriftItemApplicationRecipeGen;
import garden.inbloom.create_enderscape.datagen.create_recipes.DriftPressingRecipeGen;
import garden.inbloom.create_enderscape.datagen.create_recipes.DriftWashingRecipeGen;
import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import garden.inbloom.create_enderscape.register.DriftItems;
import garden.inbloom.create_enderscape.register.DriftTags.DriftItemTags;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.EnderscapeItems;
import net.bunten.enderscape.registry.tag.EnderscapeItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DriftRecipeProvider extends RecipeProvider {
	static final List<ProcessingRecipeGen<?, ?, ?>> GENERATORS = new ArrayList<>();

	public DriftRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
    	shapelessRecipes(output);
        shapedRecipes(output);
        stonecutterRecipes(output);
    }
    
    private void shapelessRecipes(RecipeOutput output) {
    	ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DriftItems.DUSK_INGOT.get(), 2)
    	.requires(DriftItemTags.INGOTS_SHADOLINE.tag)
    	.requires(Items.POPPED_CHORUS_FRUIT)
        .unlockedBy("has_shadoline_ingot", has(DriftItemTags.INGOTS_SHADOLINE.tag))
        .save(output);
    }
	
	private void shapedRecipes(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, DriftBlocks.ALLURING_MAGNIA_COUPLER, 1)
	        .pattern("A").pattern("C").pattern("S")
	        .define('A', EnderscapeBlocks.ALLURING_MAGNIA_SPROUT.get())
	        .define('C', AllBlocks.ANDESITE_CASING.get())
	        .define('S', AllBlocks.SHAFT.get())
	        .unlockedBy("has_alluring_magnia", has(EnderscapeBlocks.ALLURING_MAGNIA_SPROUT.get()))
	        .save(output);
    
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, DriftBlocks.REPULSIVE_MAGNIA_COUPLER, 1)
	        .pattern("R").pattern("C").pattern("S")
	        .define('R', EnderscapeBlocks.REPULSIVE_MAGNIA_SPROUT.get())
	        .define('C', AllBlocks.ANDESITE_CASING.get())
	        .define('S', AllBlocks.SHAFT.get())
	        .unlockedBy("has_repulsive_magnia", has(EnderscapeBlocks.REPULSIVE_MAGNIA_SPROUT.get()))
	        .save(output);
    
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DriftItems.MAGNIA_CONTROL_UNIT, 1)
	        .define('E', AllItems.ELECTRON_TUBE.get())
	        .define('A', EnderscapeBlocks.ALLURING_MAGNIA_SPROUT.get())
	        .define('B', Blocks.CALCITE) //TODO: Replace calcite with blistered magnia
	        .define('R', EnderscapeBlocks.REPULSIVE_MAGNIA_SPROUT.get())
	        .define('S', DriftItemTags.INGOTS_SHADOLINE.tag)
	        .pattern(" E ")
	        .pattern("ABR")
	        .pattern(" S ")
	        .unlockedBy("has_magnia_sprout", has(EnderscapeItemTags.MAGNIA_SPROUTS))
	        .save(output);
        
        nineBlockStorageRecipesFromTags(output, RecipeCategory.MISC, DriftItems.SHADOLINE_NUGGET.get(), DriftItemTags.NUGGETS_SHADOLINE.tag, 
        		RecipeCategory.MISC, EnderscapeItems.SHADOLINE_INGOT.get(), DriftItemTags.INGOTS_SHADOLINE.tag);
        
        stairBuilder(DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS, Ingredient.of(DriftBlocksDeco.SHADOLINE_SHINGLES))
    	.unlockedBy("has_shadoline_shingles", has(DriftBlocksDeco.SHADOLINE_SHINGLES)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB, DriftBlocksDeco.SHADOLINE_SHINGLES);
        
        stairBuilder(DriftBlocksDeco.SHADOLINE_TILE_STAIRS, Ingredient.of(DriftBlocksDeco.SHADOLINE_TILES))
        	.unlockedBy("has_shadoline_tiles", has(DriftBlocksDeco.SHADOLINE_TILES)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, DriftBlocksDeco.SHADOLINE_TILE_SLAB, DriftBlocksDeco.SHADOLINE_TILES);
        
        createWindowBlock(output, DriftBlocksDeco.CELESTIAL_WINDOW.get(), EnderscapeBlocks.CELESTIAL_PLANKS.get());
        stainedGlassPaneFromStainedGlass(output, DriftBlocksDeco.CELESTIAL_WINDOW_PANE.get(), DriftBlocksDeco.CELESTIAL_WINDOW.get());
        createWindowBlock(output, DriftBlocksDeco.MURUBLIGHT_WINDOW.get(), EnderscapeBlocks.MURUBLIGHT_PLANKS.get());
        stainedGlassPaneFromStainedGlass(output, DriftBlocksDeco.MURUBLIGHT_WINDOW_PANE.get(), DriftBlocksDeco.MURUBLIGHT_WINDOW.get());
        createWindowBlock(output, DriftBlocksDeco.VEILED_WINDOW.get(), EnderscapeBlocks.VEILED_PLANKS.get());
        stainedGlassPaneFromStainedGlass(output, DriftBlocksDeco.VEILED_WINDOW_PANE.get(), DriftBlocksDeco.VEILED_WINDOW.get());
        
        cut(output, RecipeCategory.MISC, EnderscapeBlocks.DUSK_PURPUR_BLOCK.get(), DriftItemTags.INGOTS_DUSK.tag);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EnderscapeBlocks.PURPUR_TILES.get(), 4)
	        .define('D', DriftItemTags.INGOTS_DUSK.tag)
	        .define('C', Items.POPPED_CHORUS_FRUIT)
	        .pattern("DC")
	        .pattern("CD")
	        .unlockedBy("has_dusk_ingot", has(DriftItemTags.INGOTS_DUSK.tag))
	        .save(output, Drift.asResource(getConversionRecipeName(EnderscapeBlocks.PURPUR_TILES.get(), DriftItems.DUSK_INGOT.get())));
	}
	
	//private void blastingRecipes(RecipeOutput output) {}
	
	private void stonecutterRecipes(RecipeOutput output) {
		stonecutterResultFromBase(output, DriftBlocksDeco.SHADOLINE_SHINGLES, DriftItemTags.INGOTS_SHADOLINE.tag, 2);
		stonecutterResultFromBase(output, DriftBlocksDeco.SHADOLINE_TILES, DriftItemTags.INGOTS_SHADOLINE.tag, 2);
        stonecutterResultFromBase(output, DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS, DriftBlocksDeco.SHADOLINE_SHINGLES.asItem(), 1);
        stonecutterResultFromBase(output, DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB, DriftBlocksDeco.SHADOLINE_SHINGLES.asItem(), 2);
        stonecutterResultFromBase(output, DriftBlocksDeco.SHADOLINE_TILE_STAIRS, DriftBlocksDeco.SHADOLINE_TILES.asItem(), 1);
        stonecutterResultFromBase(output, DriftBlocksDeco.SHADOLINE_TILE_SLAB, DriftBlocksDeco.SHADOLINE_TILES.asItem(), 2);
	}
	
	public static void registerAllProcessing(DataGenerator gen, PackOutput output,
			CompletableFuture<HolderLookup.Provider> registries, String modid) {
		GENERATORS.add(new DriftPressingRecipeGen(output, registries, modid));
		GENERATORS.add(new DriftCrushingRecipeGen(output, registries, modid));
		GENERATORS.add(new DriftWashingRecipeGen(output, registries, modid));
		GENERATORS.add(new DriftItemApplicationRecipeGen(output, registries, modid));

		gen.addProvider(true, new DataProvider() {

			@Override
			public @NotNull String getName() {
				return "Catch My Drift's Processing Recipes";
			}

			@Override
			public @NotNull CompletableFuture<?> run(@NotNull CachedOutput dc) {
				return CompletableFuture.allOf(GENERATORS.stream()
					.map(gen -> gen.run(dc))
					.toArray(CompletableFuture[]::new));
			}
		});
	}
	
	//region Helper methods
	protected static void stonecutterResultFromBase(RecipeOutput recipeOutput, ItemLike result, TagKey<Item> material, int resultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), RecipeCategory.BUILDING_BLOCKS, result, resultCount)
            .unlockedBy(getHasName(material), has(material))
            .save(recipeOutput, Drift.asResource(getConversionRecipeName(result, material) + "_stonecutting"));
    }

    protected static void stonecutterResultFromBase(RecipeOutput recipeOutput, ItemLike result, ItemLike material, int resultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), RecipeCategory.BUILDING_BLOCKS, result, resultCount)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput, Drift.asResource(getConversionRecipeName(result, material) + "_stonecutting"));
    }
    
    protected static void nineBlockStorageRecipesFromTags(RecipeOutput recipeOutput,
            RecipeCategory unpackedCategory, ItemLike unpacked, TagKey<Item> unpackedTag,
            RecipeCategory packedCategory, ItemLike packed, TagKey<Item> packedTag) {
    	nineBlockStorageRecipesFromTags(
            recipeOutput, unpackedCategory, unpacked, unpackedTag, packedCategory, packed, packedTag, getSimpleRecipeName(packed), null, getSimpleRecipeName(unpacked), null
        );
    }
    
    protected static void cut(RecipeOutput recipeOutput, RecipeCategory category, ItemLike cutResult, TagKey<Item> material) {
        cutBuilder(category, cutResult, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(recipeOutput);
    }
    
    protected static void nineBlockStorageRecipesFromTags(RecipeOutput recipeOutput, 
    		RecipeCategory unpackedCategory, ItemLike unpacked, TagKey<Item> unpackedTag,
            RecipeCategory packedCategory, ItemLike packed, TagKey<Item> packedTag,
            String packedName, @Nullable String packedGroup,
            String unpackedName, @Nullable String unpackedGroup) {
        ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 9)
            .requires(packedTag)
            .group(unpackedGroup)
            .unlockedBy(getHasName(packed), has(packedTag))
            .save(recipeOutput, Drift.asResource(unpackedName));
        ShapedRecipeBuilder.shaped(packedCategory, packed)
            .define('#', unpackedTag)
            .pattern("###").pattern("###").pattern("###")
            .group(packedGroup)
            .unlockedBy(getHasName(unpacked), has(unpackedTag))
            .save(recipeOutput, Drift.asResource(packedName));
    }
	
	protected static void createWindowBlock(RecipeOutput recipeOutput, ItemLike result, ItemLike material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 2)
            .define('#', DriftItemTags.GLASS_BLOCKS_COLORLESS.tag)
            .define('M', material)
            .pattern(" M ")
            .pattern("M#M")
            .unlockedBy(getHasName(material), has(material))
            .save(recipeOutput);
    }

    protected static String getConversionRecipeName(ItemLike result, TagKey<Item> itemTag) {
        return getItemName(result) + "_from_" + itemTag.location().getPath().replace('/', '_');
    }
    
    protected static String getHasName(TagKey<Item> itemTag) {
        return "has_" + itemTag.location().getPath().replace('/', '_');
    }
	//endregion
}
