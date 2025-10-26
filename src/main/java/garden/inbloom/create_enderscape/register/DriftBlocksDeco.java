package garden.inbloom.create_enderscape.register;

import com.google.common.base.Supplier;
import com.simibubi.create.content.decoration.MetalLadderBlock;
import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import garden.inbloom.create_enderscape.Drift;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.EnderscapeSoundTypes;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DriftBlocksDeco {

	public static final DeferredBlock<MetalLadderBlock> DUSK_LADDER = registerDecoBlock("dusk_ladder",
		    () -> new MetalLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)
                    .mapColor(MapColor.COLOR_BLACK).sound(EnderscapeSoundTypes.PURPUR)));
    public static final DeferredBlock<IronBarsBlock> DUSK_BARS = registerDecoBlock("dusk_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS)
                    .mapColor(MapColor.COLOR_BLACK).sound(EnderscapeSoundTypes.PURPUR)));
    public static final DeferredBlock<MetalScaffoldingBlock> DUSK_SCAFFOLDING = registerMetalScaffold("dusk_scaffolding",
            () -> new MetalScaffoldingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SCAFFOLDING)
                    .mapColor(MapColor.COLOR_BLACK).sound(EnderscapeSoundTypes.PURPUR)));

	public static final DeferredBlock<Block> SHADOLINE_SHINGLES = registerDecoBlock("shadoline_shingles", 
		    () -> new Block(Block.Properties.ofFullCopy(EnderscapeBlocks.CUT_SHADOLINE.get())
                    .mapColor(MapColor.TERRACOTTA_GREEN).sound(EnderscapeSoundTypes.CUT_SHADOLINE)));
	public static final DeferredBlock<StairBlock> SHADOLINE_SHINGLE_STAIRS = registerDecoBlock("shadoline_shingle_stairs", 
		    () -> new StairBlock(SHADOLINE_SHINGLES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(SHADOLINE_SHINGLES.get())));
	public static final DeferredBlock<SlabBlock> SHADOLINE_SHINGLE_SLAB = registerDecoBlock("shadoline_shingle_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SHADOLINE_SHINGLES.get())));
	
	public static final DeferredBlock<Block> SHADOLINE_TILES = registerDecoBlock("shadoline_tiles",
            () -> new Block(Block.Properties.ofFullCopy(SHADOLINE_SHINGLES.get())));
	public static final DeferredBlock<StairBlock> SHADOLINE_TILE_STAIRS = registerDecoBlock("shadoline_tile_stairs",
            () -> new StairBlock(SHADOLINE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(SHADOLINE_TILES.get())));
	public static final DeferredBlock<SlabBlock> SHADOLINE_TILE_SLAB = registerDecoBlock("shadoline_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SHADOLINE_TILES.get())));

    public static final DeferredBlock<TransparentBlock> VEILED_WINDOW = registerDecoBlock("veiled_window",
            () -> new TransparentBlock(Block.Properties.ofFullCopy(Blocks.GLASS)
                    .mapColor(MapColor.TERRACOTTA_BLUE)));
	public static final DeferredBlock<TransparentBlock> CELESTIAL_WINDOW = registerDecoBlock("celestial_window",
            () -> new TransparentBlock(Block.Properties.ofFullCopy(Blocks.GLASS)
                    .mapColor(MapColor.COLOR_ORANGE)));
	public static final DeferredBlock<TransparentBlock> MURUBLIGHT_WINDOW = registerDecoBlock("murublight_window",
            () -> new TransparentBlock(Block.Properties.ofFullCopy(Blocks.GLASS)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)));
    public static final DeferredBlock<ConnectedGlassPaneBlock> VEILED_WINDOW_PANE = registerDecoBlock("veiled_window_pane",
            () -> new ConnectedGlassPaneBlock(Block.Properties.ofFullCopy(VEILED_WINDOW.get())));
    public static final DeferredBlock<ConnectedGlassPaneBlock> CELESTIAL_WINDOW_PANE = registerDecoBlock("celestial_window_pane",
            () -> new ConnectedGlassPaneBlock(Block.Properties.ofFullCopy(CELESTIAL_WINDOW.get())));
    public static final DeferredBlock<ConnectedGlassPaneBlock> MURUBLIGHT_WINDOW_PANE = registerDecoBlock("murublight_window_pane",
            () -> new ConnectedGlassPaneBlock(Block.Properties.ofFullCopy(MURUBLIGHT_WINDOW.get())));
	
	//region Registration methods
	protected static <T extends Block> DeferredBlock<T> registerDecoBlock(String name, Supplier<T> block) {
        return registerDecoBlock(name, block, true);
    }

    protected static <T extends Block> DeferredBlock<T> registerDecoBlock(String name, Supplier<T> block, boolean andItem) {
        return DriftBlocks.registerDecoBlock(name, block, andItem);
    }

    protected static <T extends Block> DeferredBlock<T> registerMetalScaffold(String name, Supplier<T> block) {
        return DriftBlocks.registerMetalScaffold(name, block);
    }
	//endregion
	
	public static void register() {
		Drift.LOGGER.info("Registering Deco Blocks!");
	}
}
