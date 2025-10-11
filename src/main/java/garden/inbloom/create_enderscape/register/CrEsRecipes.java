package garden.inbloom.create_enderscape.register;

import java.util.concurrent.CompletableFuture;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;

import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.EnderscapeItems;
import net.bunten.enderscape.registry.tag.EnderscapeItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;

public class CrEsRecipes extends RecipeProvider {

	public CrEsRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        buildShapedRecipes(output);
        
        /*
        ShapelessRecipeBuilder.shapeless(Items.GOLD_NUGGET)
            .requires(MyItems.SHADOLINE_NUGGET.get())
            .unlockedBy("has_shadoline_nugget", has(MyItems.SHADOLINE_NUGGET.get()))
            .save(output); // Use 'output' here
    	*/
    }
	
	private void buildShapedRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CrEsBlocks.ALLURING_MAGNIA_COUPLER, 1)
	        .pattern("A").pattern("C").pattern("S")
	        .define('A', EnderscapeBlocks.ALLURING_MAGNIA_SPROUT.get())
	        .define('C', AllBlocks.ANDESITE_CASING.get())
	        .define('S', AllBlocks.SHAFT.get())
	        .unlockedBy("has_alluring_magnia", has(EnderscapeBlocks.ALLURING_MAGNIA_SPROUT.get()))
	        .save(output);
    
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CrEsBlocks.REPULSIVE_MAGNIA_COUPLER, 1)
	        .pattern("R").pattern("C").pattern("S")
	        .define('R', EnderscapeBlocks.REPULSIVE_MAGNIA_SPROUT.get())
	        .define('C', AllBlocks.ANDESITE_CASING.get())
	        .define('S', AllBlocks.SHAFT.get())
	        .unlockedBy("has_repulsive_magnia", has(EnderscapeBlocks.REPULSIVE_MAGNIA_SPROUT.get()))
	        .save(output);
    
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CrEsItems.MAGNIA_CONTROL_UNIT, 1)
	        .pattern(" E ").pattern("ABR").pattern(" S ")
	        .define('E', AllItems.ELECTRON_TUBE.get())
	        .define('A', EnderscapeBlocks.ALLURING_MAGNIA_SPROUT.get())
	        .define('B', Blocks.CALCITE)
	        .define('R', EnderscapeBlocks.REPULSIVE_MAGNIA_SPROUT.get())
	        .define('S', EnderscapeItems.SHADOLINE_INGOT.get())
	        .unlockedBy("has_magnia_sprout", has(EnderscapeItemTags.MAGNIA_SPROUTS))
	        .save(output);
        
        nineBlockStorageRecipes(output, RecipeCategory.MISC, CrEsItems.SHADOLINE_NUGGET.get(), RecipeCategory.MISC, EnderscapeItems.SHADOLINE_INGOT.get());
        twoByTwoPacker(output, RecipeCategory.MISC, EnderscapeBlocks.DUSK_PURPUR_BLOCK.get(), CrEsItems.DUSK_INGOT.get());
	}
}
