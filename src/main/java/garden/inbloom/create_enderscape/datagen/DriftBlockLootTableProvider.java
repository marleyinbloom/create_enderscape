package garden.inbloom.create_enderscape.datagen;

import java.util.Set;

import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

public class DriftBlockLootTableProvider extends BlockLootSubProvider {

	protected DriftBlockLootTableProvider(Provider registries) {
		super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
	}

	@Override
	protected void generate() {
		dropSelf(DriftBlocks.DUSK_CASING.get());
		
		dropSelf(DriftBlocks.ALLURING_MAGNIA_COUPLER.get());
		dropSelf(DriftBlocks.REPULSIVE_MAGNIA_COUPLER.get());

		dropSelf(DriftBlocksDeco.DUSK_SCAFFOLDING.get());
		
		dropSelf(DriftBlocksDeco.SHADOLINE_SHINGLES.get());
		dropSelf(DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS.get());
		add(DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get(),
				block -> createSlabItemTable(DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get()));
		dropSelf(DriftBlocksDeco.SHADOLINE_TILES.get());
		dropSelf(DriftBlocksDeco.SHADOLINE_TILE_STAIRS.get());
		add(DriftBlocksDeco.SHADOLINE_TILE_SLAB.get(),
			block -> createSlabItemTable(DriftBlocksDeco.SHADOLINE_TILE_SLAB.get()));
		
		dropWhenSilkTouch(DriftBlocksDeco.CELESTIAL_WINDOW.get());
		dropWhenSilkTouch(DriftBlocksDeco.CELESTIAL_WINDOW_PANE.get());
		dropWhenSilkTouch(DriftBlocksDeco.MURUBLIGHT_WINDOW.get());
		dropWhenSilkTouch(DriftBlocksDeco.MURUBLIGHT_WINDOW_PANE.get());
		dropWhenSilkTouch(DriftBlocksDeco.VEILED_WINDOW.get());
		dropWhenSilkTouch(DriftBlocksDeco.VEILED_WINDOW_PANE.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		Drift.LOGGER.info(DriftBlocks.BLOCKS.getEntries().toString());
		return DriftBlocks.BLOCKS.getEntries()
			.stream()
			.map(e -> (Block) e.value())
			.toList();
	}
}
