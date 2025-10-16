package garden.inbloom.create_enderscape.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.block.CopperBlockSet;
import com.tterrag.registrate.util.entry.BlockEntry;

import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import garden.inbloom.create_enderscape.register.DriftTags.DriftBlockTags;
import garden.inbloom.create_enderscape.to_delete.register.CrEsBlocks;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.tag.EnderscapeBlockTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DriftTagProvider {
	
	public class DriftBlockTagProvider extends BlockTagsProvider {

		public DriftBlockTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, String modId,
				@Nullable ExistingFileHelper existingFileHelper) {
			super(output, lookupProvider, modId, existingFileHelper);
		}

		@Override
		protected void addTags(Provider provider) {
			roofBlockHell();
		    
			commonBlockTags();
			vanillaBlockTags();
			enderscapeBlockTags();
		}
		
		private void commonBlockTags() {
			tag(DriftBlockTags.STORAGE_BLOCKS_SHADOLINE.tag).add(EnderscapeBlocks.SHADOLINE_BLOCK.get());
			tag(DriftBlockTags.STORAGE_BLOCKS_RAW_SHADOLINE.tag).add(EnderscapeBlocks.RAW_SHADOLINE_BLOCK.get());
			tag(DriftBlockTags.STORAGE_BLOCKS.tag).add(
				EnderscapeBlocks.SHADOLINE_BLOCK.get(), EnderscapeBlocks.RAW_SHADOLINE_BLOCK.get());
			
			tag(DriftBlockTags.STRIPPED_LOGS.tag).add(
				EnderscapeBlocks.STRIPPED_CELESTIAL_STEM.get(), EnderscapeBlocks.STRIPPED_MURUBLIGHT_STEM.get(),
				EnderscapeBlocks.STRIPPED_VEILED_LOG.get());
			tag(DriftBlockTags.STRIPPED_WOOD.tag).add(
					EnderscapeBlocks.STRIPPED_CELESTIAL_HYPHAE.get(), EnderscapeBlocks.STRIPPED_MURUBLIGHT_HYPHAE.get(),
					EnderscapeBlocks.STRIPPED_VEILED_WOOD.get());
		}
		
		private void vanillaBlockTags() {
		    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
		    	DriftBlocks.DUSK_CASING.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get());
		    tag(BlockTags.MINEABLE_WITH_AXE).add(
		    	DriftBlocks.DUSK_CASING.get());
		    tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).add(
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get());
		    tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).add(
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get());
		    tag(BlockTags.NEEDS_STONE_TOOL).add(
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get());
		    
		    tag(BlockTags.DRAGON_IMMUNE).add(
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get());
		}
		
		private void enderscapeBlockTags() {
		    tag(EnderscapeBlockTags.SHADOLINE_BLOCKS).add(
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get());
		}
		
		private void roofBlockHell() {	
			//region Copper hell
			List<Block> connectsToCopperRoof = List.of(
				Blocks.COPPER_BLOCK, Blocks.EXPOSED_COPPER,
				Blocks.WEATHERED_COPPER, Blocks.OXIDIZED_COPPER,
				Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_EXPOSED_COPPER,
				Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_OXIDIZED_COPPER,
				Blocks.CHISELED_COPPER, Blocks.EXPOSED_CHISELED_COPPER,
				Blocks.WEATHERED_CHISELED_COPPER, Blocks.OXIDIZED_CHISELED_COPPER,
				Blocks.WAXED_CHISELED_COPPER, Blocks.WAXED_EXPOSED_CHISELED_COPPER,
				Blocks.WAXED_WEATHERED_CHISELED_COPPER, Blocks.WAXED_OXIDIZED_CHISELED_COPPER,
				Blocks.COPPER_BULB, Blocks.EXPOSED_COPPER_BULB,
				Blocks.WEATHERED_COPPER_BULB, Blocks.OXIDIZED_COPPER_BULB,
				Blocks.WAXED_COPPER_BULB, Blocks.WAXED_EXPOSED_COPPER_BULB,
				Blocks.WAXED_WEATHERED_COPPER_BULB, Blocks.WAXED_OXIDIZED_COPPER_BULB,
				Blocks.COPPER_GRATE, Blocks.EXPOSED_COPPER_GRATE,
				Blocks.WEATHERED_COPPER_GRATE, Blocks.OXIDIZED_COPPER_GRATE,
				Blocks.WAXED_COPPER_GRATE, Blocks.WAXED_EXPOSED_COPPER_GRATE,
				Blocks.WAXED_WEATHERED_COPPER_GRATE, Blocks.WAXED_OXIDIZED_COPPER_GRATE,
				Blocks.COPPER_TRAPDOOR, Blocks.EXPOSED_COPPER_TRAPDOOR,
				Blocks.WEATHERED_COPPER_TRAPDOOR, Blocks.OXIDIZED_COPPER_TRAPDOOR,
				Blocks.WAXED_COPPER_TRAPDOOR, Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
				Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR, Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,
				Blocks.CUT_COPPER, Blocks.EXPOSED_CUT_COPPER,
				Blocks.WEATHERED_CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER,
				Blocks.WAXED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER,
				Blocks.WAXED_WEATHERED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER,
				Blocks.CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_SLAB,
				Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER_SLAB,
				Blocks.WAXED_CUT_COPPER_SLAB, Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB,
				Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,
				Blocks.CUT_COPPER_STAIRS, Blocks.EXPOSED_CUT_COPPER_STAIRS,
				Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.OXIDIZED_CUT_COPPER_STAIRS,
				Blocks.WAXED_CUT_COPPER_STAIRS, Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS,
				Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS,
				AllBlocks.COPPER_CASING.get(), AllBlocks.COPPER_SCAFFOLD.get());
			//endregion
			for (Block block : connectsToCopperRoof) {
				tag(DriftBlockTags.CONNECTS_TO_ROOF_BLOCKS.tag).add(block);
				tag(DriftBlockTags.CONNECTS_TO_ROOF_BLOCKS_COPPER.tag).add(block);
			}
			
			//region Shadoline lesser hell
			List<Block> connectsToShadolineRoof = List.of(
				EnderscapeBlocks.SHADOLINE_BLOCK.get(), EnderscapeBlocks.SHADOLINE_BLOCK_SLAB.get(),
				EnderscapeBlocks.SHADOLINE_BLOCK_STAIRS.get(), EnderscapeBlocks.SHADOLINE_PILLAR.get(),
				EnderscapeBlocks.CUT_SHADOLINE.get(), EnderscapeBlocks.CUT_SHADOLINE_SLAB.get(),
				EnderscapeBlocks.CUT_SHADOLINE_STAIRS.get(), EnderscapeBlocks.CHISELED_SHADOLINE.get());
			//endregion
			for (Block block : connectsToShadolineRoof) {
				tag(DriftBlockTags.CONNECTS_TO_ROOF_BLOCKS.tag).add(block);
				tag(DriftBlockTags.CONNECTS_TO_ROOF_BLOCKS_SHADOLINE.tag).add(block);
			}
			
			tag(DriftBlockTags.ROOF_BLOCKS.tag).add(CrEsBlocks.SHADOLINE_SHINGLES.get(), CrEsBlocks.SHADOLINE_TILES.get());
			CopperBlockSet shingles = AllBlocks.COPPER_SHINGLES;
		    for (CopperBlockSet.Variant<?> variant : shingles.getVariants()) {
		        for (boolean waxed : new boolean[]{false, true}) {
		            for (WeatherState state : WeatherState.values()) {
		                BlockEntry<?> entry = shingles.get(variant, state, waxed);
		                if (entry != null) {
		                    tag(DriftBlockTags.ROOF_BLOCKS.tag).add(entry.get());
		                    tag(DriftBlockTags.ROOF_BLOCKS_COPPER.tag).add(entry.get());
		                }
		            }
		        }
		    }
			CopperBlockSet tiles = AllBlocks.COPPER_TILES;
		    for (CopperBlockSet.Variant<?> variant : tiles.getVariants()) {
		        for (boolean waxed : new boolean[]{false, true}) {
		            for (WeatherState state : WeatherState.values()) {
		                BlockEntry<?> entry = tiles.get(variant, state, waxed);
		                if (entry != null) {
		                    tag(DriftBlockTags.ROOF_BLOCKS.tag).add(entry.get());
		                    tag(DriftBlockTags.ROOF_BLOCKS_COPPER.tag).add(entry.get());
		                }
		            }
		        }
		    }
		}
	}
}
