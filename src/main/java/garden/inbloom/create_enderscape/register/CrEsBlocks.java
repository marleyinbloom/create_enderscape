package garden.inbloom.create_enderscape.register;

import com.simibubi.create.content.decoration.MetalLadderBlock;
import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;

import garden.inbloom.create_enderscape.CreateEnderscape;
import garden.inbloom.create_enderscape.block.CasingDecoGen.CasingBarsGen;
import garden.inbloom.create_enderscape.block.CrEsBuilderTransformers;
import garden.inbloom.create_enderscape.block.connected.CrEsSpriteShifts;
import garden.inbloom.create_enderscape.block.connected.behaviors.ShadolineRoofCTBehavior;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.EnderscapeSoundTypes;
import net.bunten.enderscape.registry.tag.EnderscapeBlockTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class CrEsBlocks {
	public static final CreateRegistrate REGISTRATE = CreateEnderscape.REGISTRATE;
	
	public static final BlockEntry<Block> SHADOLINE_SHINGLES = REGISTRATE.block("shadoline_shingles", 
		    properties -> new Block(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.CUT_SHADOLINE.get())))
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeColumn("shadoline_shingles", 
					CreateEnderscape.asResource("block/shadoline_shingles"), CreateEnderscape.asResource("block/shadoline_roof_top"))))
			.onRegister(CreateRegistrate.connectedTextures(() -> new ShadolineRoofCTBehavior(CrEsSpriteShifts.SHADOLINE_SHINGLES)))
			.tag(CrEsTags.CrEsBlockTags.ROOF_BLOCKS.tag).tag(CrEsTags.CrEsBlockTags.ROOF_BLOCKS_SHADOLINE.tag)
				.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
				.tag(BlockTags.NEEDS_STONE_TOOL).tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.tag(EnderscapeBlockTags.SHADOLINE_BLOCKS)
			.lang("Shadoline Shingles")
		    .item().build().register();
	
	public static final BlockEntry<Block> SHADOLINE_TILES = REGISTRATE.block("shadoline_tiles", 
		    properties -> new Block(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.CUT_SHADOLINE.get())))
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeColumn("shadoline_tiles", 
					CreateEnderscape.asResource("block/shadoline_tiles"), CreateEnderscape.asResource("block/shadoline_roof_top"))))
			.onRegister(CreateRegistrate.connectedTextures(() -> new ShadolineRoofCTBehavior(CrEsSpriteShifts.SHADOLINE_TILES)))
			.tag(CrEsTags.CrEsBlockTags.ROOF_BLOCKS.tag).tag(CrEsTags.CrEsBlockTags.ROOF_BLOCKS_SHADOLINE.tag)
				.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
				.tag(BlockTags.NEEDS_STONE_TOOL).tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.tag(EnderscapeBlockTags.SHADOLINE_BLOCKS)
			.lang("Shadoline Tiles")
		    .item().build().register();
	
	public static final BlockEntry<CasingBlock> DUSK_CASING = REGISTRATE.block("dusk_casing",
		    properties -> new CasingBlock(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.DUSK_PURPUR_BLOCK.get())
		    		.sound(EnderscapeSoundTypes.PURPUR)))
		    .transform(BuilderTransformers.casing(() -> CrEsSpriteShifts.DUSK_CASING))
			.lang("Dusk Casing")
		    .register();
	
	public static final BlockEntry<Block> ALLURING_MAGNIA_COUPLER = REGISTRATE.block("alluring_magnia_coupler", 
		    properties -> new Block(BlockBehaviour.Properties.of()
		    		.requiresCorrectToolForDrops().noOcclusion()))
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().getExistingFile(CreateEnderscape.asResource("block/alluring_magnia_coupler"))))
			.tag(BlockTags.MINEABLE_WITH_AXE).tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.lang("Alluring Magnia Coupler")
		    .item().build().register();
	
	public static final BlockEntry<Block> REPULSIVE_MAGNIA_COUPLER = REGISTRATE.block("repulsive_magnia_coupler", 
		    properties -> new Block(BlockBehaviour.Properties.of()
		    		.requiresCorrectToolForDrops().noOcclusion()))
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().getExistingFile(CreateEnderscape.asResource("block/repulsive_magnia_coupler"))))
			.tag(BlockTags.MINEABLE_WITH_AXE).tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.lang("Repulsive Magnia Coupler")
		    .item().build().register();
	
	public static final BlockEntry<IronBarsBlock> DUSK_BARS = CasingBarsGen.createBars("dusk", true,
			() -> DataIngredient.items(CrEsItems.DUSK_INGOT.get()), MapColor.COLOR_BLACK, EnderscapeSoundTypes.PURPUR);
	
	public static final BlockEntry<MetalScaffoldingBlock> DUSK_SCAFFOLDING = REGISTRATE.block("dusk_scaffolding", MetalScaffoldingBlock::new)
			.transform(CrEsBuilderTransformers.scaffold("dusk", () -> DataIngredient.items(CrEsItems.DUSK_INGOT.get()),
				MapColor.COLOR_BLACK, EnderscapeSoundTypes.PURPUR, CrEsSpriteShifts.DUSK_SCAFFOLD,
				CrEsSpriteShifts.DUSK_SCAFFOLD_INSIDE, CrEsSpriteShifts.DUSK_CASING))
			.register();
	
	public static final BlockEntry<MetalLadderBlock> ANDESITE_LADDER = REGISTRATE.block("dusk_ladder", MetalLadderBlock::new)
			.transform(CrEsBuilderTransformers.ladder("dusk", () -> DataIngredient.items(CrEsItems.DUSK_INGOT.get()),
				MapColor.COLOR_BLACK, EnderscapeSoundTypes.PURPUR))
			.register();
	
	
	public static void register() {
		CreateEnderscape.LOGGER.info("Registering Blocks!");
	}
}
