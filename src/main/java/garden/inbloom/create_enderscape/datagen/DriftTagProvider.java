package garden.inbloom.create_enderscape.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import garden.inbloom.create_enderscape.register.DriftItems;
import garden.inbloom.create_enderscape.register.DriftTags.DriftBlockTags;
import garden.inbloom.create_enderscape.register.DriftTags.DriftItemTags;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.block.CopperBlockSet;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.EnderscapeItems;
import net.bunten.enderscape.registry.tag.EnderscapeBlockTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DriftTagProvider {
	public static class DriftBlockTagProvider extends BlockTagsProvider {

		public DriftBlockTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, String modId,
				@Nullable ExistingFileHelper existingFileHelper) {
			super(output, lookupProvider, modId, existingFileHelper);
		}

		@Override
		protected void addTags(@NotNull Provider provider) {
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
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get(), DriftBlocksDeco.SHADOLINE_TILE_SLAB.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS.get(), DriftBlocksDeco.SHADOLINE_TILE_STAIRS.get());
		    tag(BlockTags.MINEABLE_WITH_AXE).add(
		    	DriftBlocks.DUSK_CASING.get());
		    tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).add(
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get(), DriftBlocksDeco.SHADOLINE_TILE_SLAB.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS.get(), DriftBlocksDeco.SHADOLINE_TILE_STAIRS.get());
		    tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).add(
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get(), DriftBlocksDeco.SHADOLINE_TILE_SLAB.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS.get(), DriftBlocksDeco.SHADOLINE_TILE_STAIRS.get());
		    tag(BlockTags.NEEDS_STONE_TOOL).add(
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get(), DriftBlocksDeco.SHADOLINE_TILE_SLAB.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS.get(), DriftBlocksDeco.SHADOLINE_TILE_STAIRS.get());
		    
		    tag(BlockTags.DRAGON_IMMUNE).add(
		    	DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get(), DriftBlocksDeco.SHADOLINE_TILE_SLAB.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS.get(), DriftBlocksDeco.SHADOLINE_TILE_STAIRS.get());
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
				AllBlocks.COPPER_CASING.get(), AllBlocks.COPPER_SCAFFOLD.get(), AllBlocks.FLUID_TANK.get());
			//endregion
			for (Block block : connectsToCopperRoof) {
				tag(DriftBlockTags.ROOFS_CONNECT_TO.tag).add(block);
				tag(DriftBlockTags.ROOFS_CONNECT_TO_COPPER.tag).add(block);
			}
			
			//region Shadoline lesser hell
			List<Block> connectsToShadolineRoof = List.of(
				EnderscapeBlocks.SHADOLINE_BLOCK.get(), EnderscapeBlocks.SHADOLINE_BLOCK_SLAB.get(),
				EnderscapeBlocks.SHADOLINE_BLOCK_STAIRS.get(), EnderscapeBlocks.SHADOLINE_PILLAR.get(),
				EnderscapeBlocks.CUT_SHADOLINE.get(), EnderscapeBlocks.CUT_SHADOLINE_SLAB.get(),
				EnderscapeBlocks.CUT_SHADOLINE_STAIRS.get(), EnderscapeBlocks.CHISELED_SHADOLINE.get());
			//endregion
			for (Block block : connectsToShadolineRoof) {
				tag(DriftBlockTags.ROOFS_CONNECT_TO.tag).add(block);
				tag(DriftBlockTags.ROOFS_CONNECT_TO_SHADOLINE.tag).add(block);
			}
			
			tag(DriftBlockTags.ROOF_BLOCKS.tag).add(
				DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get(), DriftBlocksDeco.SHADOLINE_TILE_SLAB.get(),
		    	DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS.get(), DriftBlocksDeco.SHADOLINE_TILE_STAIRS.get());
			tag(DriftBlockTags.ROOF_BLOCKS_SHADOLINE.tag).add(
				DriftBlocksDeco.SHADOLINE_SHINGLES.get(), DriftBlocksDeco.SHADOLINE_TILES.get(),
			    DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get(), DriftBlocksDeco.SHADOLINE_TILE_SLAB.get(),
			    DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS.get(), DriftBlocksDeco.SHADOLINE_TILE_STAIRS.get());

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
	
	public static class DriftItemTagProvider extends ItemTagsProvider {
		public DriftItemTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
				CompletableFuture<TagLookup<Block>> blockTags, String modid, ExistingFileHelper existingFileHelper) {
			super(output, lookupProvider, blockTags, modid, existingFileHelper);
		}

		@Override
		protected void addTags(@NotNull Provider provider) {
			commonItemTags();
		}
		
		private void commonItemTags() {
			tag(DriftItemTags.INGOTS_DUSK.tag).add(DriftItems.DUSK_INGOT.get());
			tag(DriftItemTags.INGOTS_SHADOLINE.tag).add(EnderscapeItems.SHADOLINE_INGOT.get());
			tag(DriftItemTags.INGOTS.tag).add(
					DriftItems.DUSK_INGOT.get(), EnderscapeItems.SHADOLINE_INGOT.get());
			tag(DriftItemTags.NUGGETS_SHADOLINE.tag).add(DriftItems.SHADOLINE_NUGGET.get());
			tag(DriftItemTags.NUGGETS.tag).add(DriftItems.SHADOLINE_NUGGET.get());
			tag(DriftItemTags.RAW_MATERIALS_SHADOLINE.tag).add(EnderscapeItems.RAW_SHADOLINE.get());
			tag(DriftItemTags.RAW_MATERIALS.tag).add(EnderscapeItems.RAW_SHADOLINE.get());
			
			tag(DriftItemTags.STORAGE_BLOCKS_SHADOLINE.tag).add(EnderscapeBlocks.SHADOLINE_BLOCK.get().asItem());
			tag(DriftItemTags.STORAGE_BLOCKS_RAW_SHADOLINE.tag).add(EnderscapeBlocks.RAW_SHADOLINE_BLOCK.get().asItem());
			tag(DriftItemTags.STORAGE_BLOCKS.tag).add(
				EnderscapeBlocks.SHADOLINE_BLOCK.get().asItem(), EnderscapeBlocks.RAW_SHADOLINE_BLOCK.get().asItem());
			
			tag(DriftItemTags.STRIPPED_LOGS.tag).add(
				EnderscapeBlocks.STRIPPED_CELESTIAL_STEM.get().asItem(), EnderscapeBlocks.STRIPPED_MURUBLIGHT_STEM.get().asItem(),
				EnderscapeBlocks.STRIPPED_VEILED_LOG.get().asItem());
			tag(DriftItemTags.STRIPPED_WOOD.tag).add(
				EnderscapeBlocks.STRIPPED_CELESTIAL_HYPHAE.get().asItem(), EnderscapeBlocks.STRIPPED_MURUBLIGHT_HYPHAE.get().asItem(),
				EnderscapeBlocks.STRIPPED_VEILED_WOOD.get().asItem());
		}
	}
}
