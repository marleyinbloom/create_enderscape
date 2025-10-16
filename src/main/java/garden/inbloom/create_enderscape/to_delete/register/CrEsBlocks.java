package garden.inbloom.create_enderscape.to_delete.register;

import com.simibubi.create.content.decoration.MetalLadderBlock;
import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.block.connected.HorizontalCTBehaviour;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;

import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.block.connected.DriftSpriteShifts;
import garden.inbloom.create_enderscape.block.connected.behaviors.ShadolineRoofCTBehavior;
import garden.inbloom.create_enderscape.register.DriftItems;
import garden.inbloom.create_enderscape.register.DriftTags;
import garden.inbloom.create_enderscape.to_delete.block.CrEsBuilderTransformers;
import garden.inbloom.create_enderscape.to_delete.block.CasingDecoGen.CasingBarsGen;
import net.bunten.enderscape.Enderscape;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.EnderscapeSoundTypes;
import net.bunten.enderscape.registry.tag.EnderscapeBlockTags;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class CrEsBlocks {
	public static final CreateRegistrate REGISTRATE = Drift.REGISTRATE;
	
	public static final BlockEntry<Block> SHADOLINE_SHINGLES = REGISTRATE.block("shadoline_shingles", 
		    properties -> new Block(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.CUT_SHADOLINE.get())))
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeColumn("shadoline_shingles", 
					Drift.asResource("block/shadoline_shingles"), Drift.asResource("block/shadoline_roof_top"))))
			.onRegister(CreateRegistrate.connectedTextures(() -> new ShadolineRoofCTBehavior(DriftSpriteShifts.SHADOLINE_SHINGLES)))
			.tag(DriftTags.DriftBlockTags.ROOF_BLOCKS.tag).tag(DriftTags.DriftBlockTags.ROOF_BLOCKS_SHADOLINE.tag)
				.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
				.tag(BlockTags.NEEDS_STONE_TOOL).tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.tag(EnderscapeBlockTags.SHADOLINE_BLOCKS)
			.lang("Shadoline Shingles")
		    .item().build().register();
	
	public static final BlockEntry<Block> SHADOLINE_TILES = REGISTRATE.block("shadoline_tiles", 
		    properties -> new Block(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.CUT_SHADOLINE.get())))
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeColumn("shadoline_tiles", 
					Drift.asResource("block/shadoline_tiles"), Drift.asResource("block/shadoline_roof_top"))))
			.onRegister(CreateRegistrate.connectedTextures(() -> new ShadolineRoofCTBehavior(DriftSpriteShifts.SHADOLINE_TILES)))
			.tag(DriftTags.DriftBlockTags.ROOF_BLOCKS.tag).tag(DriftTags.DriftBlockTags.ROOF_BLOCKS_SHADOLINE.tag)
				.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
				.tag(BlockTags.NEEDS_STONE_TOOL).tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.tag(EnderscapeBlockTags.SHADOLINE_BLOCKS)
			.lang("Shadoline Tiles")
		    .item().build().register();
	
	public static final BlockEntry<CasingBlock> DUSK_CASING = REGISTRATE.block("dusk_casing",
		    properties -> new CasingBlock(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.DUSK_PURPUR_BLOCK.get())
		    		.sound(EnderscapeSoundTypes.PURPUR)))
		    .transform(BuilderTransformers.casing(() -> DriftSpriteShifts.DUSK_CASING))
			.lang("Dusk Casing")
		    .register();
	
	public static final BlockEntry<Block> ALLURING_MAGNIA_COUPLER = REGISTRATE.block("alluring_magnia_coupler", 
		    properties -> new Block(BlockBehaviour.Properties.of()
		    		.requiresCorrectToolForDrops().noOcclusion()))
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().getExistingFile(Drift.asResource("block/alluring_magnia_coupler"))))
			.tag(BlockTags.MINEABLE_WITH_AXE).tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.lang("Alluring Magnia Coupler")
		    .item().build().register();
	
	public static final BlockEntry<Block> REPULSIVE_MAGNIA_COUPLER = REGISTRATE.block("repulsive_magnia_coupler", 
		    properties -> new Block(BlockBehaviour.Properties.of()
		    		.requiresCorrectToolForDrops().noOcclusion()))
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().getExistingFile(Drift.asResource("block/repulsive_magnia_coupler"))))
			.tag(BlockTags.MINEABLE_WITH_AXE).tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.lang("Repulsive Magnia Coupler")
		    .item().build().register();
	
	public static final BlockEntry<IronBarsBlock> DUSK_BARS = CasingBarsGen.createBars("dusk", true,
			() -> DataIngredient.items(DriftItems.DUSK_INGOT.get()), MapColor.COLOR_BLACK, EnderscapeSoundTypes.PURPUR);
	
	public static final BlockEntry<MetalScaffoldingBlock> DUSK_SCAFFOLDING = REGISTRATE.block("dusk_scaffolding", MetalScaffoldingBlock::new)
			.transform(CrEsBuilderTransformers.scaffold("dusk", () -> DataIngredient.items(DriftItems.DUSK_INGOT.get()),
				MapColor.COLOR_BLACK, EnderscapeSoundTypes.PURPUR, DriftSpriteShifts.DUSK_SCAFFOLD,
				DriftSpriteShifts.DUSK_SCAFFOLD_INSIDE, DriftSpriteShifts.DUSK_CASING))
			.register();
	
	public static final BlockEntry<MetalLadderBlock> DUSK_LADDER = REGISTRATE.block("dusk_ladder", MetalLadderBlock::new)
			.transform(CrEsBuilderTransformers.ladder("dusk", () -> DataIngredient.items(DriftItems.DUSK_INGOT.get()),
				MapColor.COLOR_BLACK, EnderscapeSoundTypes.PURPUR))
			.register();
	
	public static final BlockEntry<Block> CELESTIAL_WINDOW = REGISTRATE.block("celestial_window", 
		    properties -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)))
			.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeColumn("celestial_window", 
					Drift.asResource("block/windows/celestial_window"), Enderscape.id("block/celestial_planks"))))
			.onRegister(CreateRegistrate.connectedTextures(() -> new HorizontalCTBehaviour(DriftSpriteShifts.getWoodenWindow(EnderscapeBlocks.CELESTIAL_WOOD_TYPE))))
			.addLayer(() -> RenderType::cutoutMipped)
			.lang("Celestial Window")
		    .item().build().register();	
	
	
	public static void register() {
		Drift.LOGGER.info("Registering Blocks!");
	}
}
