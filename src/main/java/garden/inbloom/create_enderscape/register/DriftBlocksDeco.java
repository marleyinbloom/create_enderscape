package garden.inbloom.create_enderscape.register;

import com.google.common.base.Supplier;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;

import garden.inbloom.create_enderscape.Drift;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.EnderscapeSoundTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DriftBlocksDeco{

	public static final DeferredBlock<Block> SHADOLINE_SHINGLES = registerBlock("shadoline_shingles", 
		() -> new Block(Block.Properties.ofFullCopy(EnderscapeBlocks.CUT_SHADOLINE.get())
		.mapColor(MapColor.TERRACOTTA_GREEN).sound(EnderscapeSoundTypes.CUT_SHADOLINE)));
	public static final DeferredBlock<StairBlock> SHADOLINE_SHINGLE_STAIRS = registerBlock("shadoline_shingle_stairs", 
		() -> new StairBlock(SHADOLINE_SHINGLES.get().defaultBlockState(), 
		BlockBehaviour.Properties.ofFullCopy(SHADOLINE_SHINGLES.get())));
	public static final DeferredBlock<SlabBlock> SHADOLINE_SHINGLE_SLAB = registerBlock("shadoline_shingle_slab", 
		() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SHADOLINE_SHINGLES.get())));
	
	public static final DeferredBlock<Block> SHADOLINE_TILES = registerBlock("shadoline_tiles", 
		() -> new Block(Block.Properties.ofFullCopy(SHADOLINE_SHINGLES.get())));
	public static final DeferredBlock<StairBlock> SHADOLINE_TILE_STAIRS = registerBlock("shadoline_tile_stairs", 
		() -> new StairBlock(SHADOLINE_TILES.get().defaultBlockState(), 
		BlockBehaviour.Properties.ofFullCopy(SHADOLINE_TILES.get())));
	public static final DeferredBlock<SlabBlock> SHADOLINE_TILE_SLAB = registerBlock("shadoline_tile_slab", 
		() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SHADOLINE_TILES.get())));
	
	public static final DeferredBlock<TransparentBlock> CELESTIAL_WINDOW = registerBlock("celestial_window", 
		() -> new TransparentBlock(Block.Properties.ofFullCopy(Blocks.GLASS)
		.mapColor(MapColor.COLOR_ORANGE)));
	public static final DeferredBlock<ConnectedGlassPaneBlock> CELESTIAL_WINDOW_PANE = registerBlock("celestial_window_pane",
		() -> new ConnectedGlassPaneBlock(Block.Properties.ofFullCopy(CELESTIAL_WINDOW.get())));
	public static final DeferredBlock<TransparentBlock> MURUBLIGHT_WINDOW = registerBlock("murublight_window", 
		() -> new TransparentBlock(Block.Properties.ofFullCopy(Blocks.GLASS)
		.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)));
	public static final DeferredBlock<ConnectedGlassPaneBlock> MURUBLIGHT_WINDOW_PANE = registerBlock("murublight_window_pane",
			() -> new ConnectedGlassPaneBlock(Block.Properties.ofFullCopy(MURUBLIGHT_WINDOW.get())));
	public static final DeferredBlock<TransparentBlock> VEILED_WINDOW = registerBlock("veiled_window", 
		() -> new TransparentBlock(Block.Properties.ofFullCopy(Blocks.GLASS)
		.mapColor(MapColor.TERRACOTTA_BLUE)));
	public static final DeferredBlock<ConnectedGlassPaneBlock> VEILED_WINDOW_PANE = registerBlock("veiled_window_pane",
			() -> new ConnectedGlassPaneBlock(Block.Properties.ofFullCopy(VEILED_WINDOW.get())));
	
	//region Registration methods
	protected static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        return DriftBlocks.registerBlock(name, block, true);
    }
	//endregion
	
	public static void register() {
		Drift.LOGGER.info("Registering Deco Blocks!");
	}
}
