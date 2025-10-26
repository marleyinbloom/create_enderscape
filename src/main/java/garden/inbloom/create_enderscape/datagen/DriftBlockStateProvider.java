package garden.inbloom.create_enderscape.datagen;

import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.MetalLadderBlock;
import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.block.MagniaCouplerBlock;
import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import net.bunten.enderscape.Enderscape;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriftBlockStateProvider extends BlockStateProvider {

	public DriftBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
		super(output, modid, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		cubeBlockWithItem(DriftBlocks.DUSK_CASING);
        magniaCouplerWithItem(DriftBlocks.ALLURING_MAGNIA_COUPLER.get());
        magniaCouplerWithItem(DriftBlocks.REPULSIVE_MAGNIA_COUPLER.get());

        metalLadder(DriftBlocksDeco.DUSK_LADDER.get(), "dusk");
        metalBars(DriftBlocksDeco.DUSK_BARS);
        metalScaffoldingWithItem(DriftBlocksDeco.DUSK_SCAFFOLDING.get(), "dusk");
		roofBlockWithItem(DriftBlocksDeco.SHADOLINE_SHINGLES, "shadoline");
		roofStairsWithItem(DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS, blockTexture(DriftBlocksDeco.SHADOLINE_SHINGLES.get()), "shadoline");
		roofSlabWithItem(DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB, blockTexture(DriftBlocksDeco.SHADOLINE_SHINGLES.get()), "shadoline");
		roofBlockWithItem(DriftBlocksDeco.SHADOLINE_TILES, "shadoline");
		roofStairsWithItem(DriftBlocksDeco.SHADOLINE_TILE_STAIRS, blockTexture(DriftBlocksDeco.SHADOLINE_TILES.get()), "shadoline");
		roofSlabWithItem(DriftBlocksDeco.SHADOLINE_TILE_SLAB, blockTexture(DriftBlocksDeco.SHADOLINE_TILES.get()), "shadoline");
		windowBlockWithItem(DriftBlocksDeco.CELESTIAL_WINDOW, EnderscapeBlocks.CELESTIAL_WOOD_TYPE);
		windowPane(DriftBlocksDeco.CELESTIAL_WINDOW_PANE, blockTexture(DriftBlocksDeco.CELESTIAL_WINDOW.get()),
			EnderscapeBlocks.CELESTIAL_WOOD_TYPE);
		windowBlockWithItem(DriftBlocksDeco.MURUBLIGHT_WINDOW, EnderscapeBlocks.MURUBLIGHT_WOOD_TYPE);
		windowPane(DriftBlocksDeco.MURUBLIGHT_WINDOW_PANE, blockTexture(DriftBlocksDeco.MURUBLIGHT_WINDOW.get()),
			EnderscapeBlocks.MURUBLIGHT_WOOD_TYPE);
		windowBlockWithItem(DriftBlocksDeco.VEILED_WINDOW, EnderscapeBlocks.VEILED_WOOD_TYPE);
		windowPane(DriftBlocksDeco.VEILED_WINDOW_PANE, blockTexture(DriftBlocksDeco.VEILED_WINDOW.get()),
			EnderscapeBlocks.VEILED_WOOD_TYPE);
	}

	private void cubeBlockWithItem(DeferredBlock<?> block) {
		simpleBlockWithItem(block.get(), cubeAll(block.get()));
	}

	private void columnBlockWithItem(DeferredBlock<?> block, ResourceLocation side, ResourceLocation top, RenderType renderType) {
		simpleBlockWithItem(block.get(), models().cubeColumn(block.getRegisteredName(), 
			side, top).renderType(renderType.name));
	}
	
	private void columnBlockWithItem(DeferredBlock<?> block, ResourceLocation side, ResourceLocation top) {
		columnBlockWithItem(block, side, top, RenderType.SOLID);
	}
	
	private void roofBlockWithItem(DeferredBlock<?> block, String madeOf) {
		columnBlockWithItem(block, blockTexture(block.get()),
			ResourceLocation.fromNamespaceAndPath(block.getId().getNamespace(), "block/" + madeOf + "_roof_top"));
	}
	
	private void roofStairsWithItem(DeferredBlock<StairBlock> block, ResourceLocation texture, String madeOf) {
		ResourceLocation roofTop = ResourceLocation.fromNamespaceAndPath(block.getId().getNamespace(),
			"block/" + madeOf + "_roof_top");
		stairsBlock(block.get(), texture, roofTop, roofTop);
		blockItem(block);
	}
	
	private void roofSlabWithItem(DeferredBlock<SlabBlock> block, ResourceLocation texture, String madeOf) {
		roofSlabWithItem(block, texture, texture, madeOf);
	}
	
	private void roofSlabWithItem(DeferredBlock<SlabBlock> block, ResourceLocation doubleSlab, ResourceLocation texture, String madeOf) {
		ResourceLocation roofTop = ResourceLocation.fromNamespaceAndPath(block.getId().getNamespace(),
			"block/" + madeOf + "_roof_top");
		slabBlock(block.get(), doubleSlab, texture, roofTop, roofTop);
		blockItem(block);
	}

    private void magniaCouplerWithItem(MagniaCouplerBlock block) {
        String magniaName = block.magniaType.getSerializedName();
        getVariantBuilder(block).forAllStates(state -> {
            String suffix = state.getValue(MagniaCouplerBlock.POWERED) ? "_powered" : "";
            String suffixSprout = state.getValue(MagniaCouplerBlock.POWERED) ? "" : "_powered";
            return ConfiguredModel.builder()
                    .modelFile(models()
                            .withExistingParent(magniaName + "_magnia_coupler" + suffix, Drift.asResource("block/magnia_coupler"))
                            .texture("magnia", Enderscape.id("block/" + magniaName + "_magnia_sprout" + suffixSprout))
                    )
                    .build();
        });

        simpleBlockItem(block, models().withExistingParent(magniaName + "_magnia_coupler",
                        Drift.asResource("block/magnia_coupler"))
                .texture("magnia", Enderscape.id("block/" + magniaName + "_magnia_sprout_powered")));
    }

    private void metalScaffoldingWithItem(MetalScaffoldingBlock block, String name) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            String suffix = state.getValue(ScaffoldingBlock.BOTTOM) ? "_horizontal" : "";
            return ConfiguredModel.builder().modelFile(models()
                    .withExistingParent(name + "_scaffolding" + suffix, Create.asResource("block/scaffold/block" + suffix))
                    .texture("top", Drift.asResource("block/funnel/" + name + "_funnel_frame"))
                    .texture("inside", Drift.asResource("block/scaffold/" + name + "_scaffold_inside"))
                    .texture("side", Drift.asResource("block/scaffold/" + name + "_scaffold"))
                    .texture("casing", Drift.asResource("block/" + name + "_casing"))
                    .texture("particle", Drift.asResource("block/scaffold/" + name + "_scaffold"))
                    .renderType(RenderType.CUTOUT_MIPPED.name)
            ).build();
        }, ScaffoldingBlock.DISTANCE, ScaffoldingBlock.WATERLOGGED);

        simpleBlockItem(block, models()
                .withExistingParent(name + "_scaffolding", Create.asResource("block/scaffold/block"))
                .texture("top", Drift.asResource("block/funnel/" + name + "_funnel_frame"))
                .texture("inside", Drift.asResource("block/scaffold/" + name + "_scaffold_inside"))
                .texture("side", Drift.asResource("block/scaffold/" + name + "_scaffold"))
        );
    }

    private void metalBars(DeferredBlock<IronBarsBlock> block) {
        String name = block.getId().getPath();
        List<String> parents = List.of("cap", "cap_alt", "post", "post_ends", "side", "side_alt");
        Map<String, ModelFile> bars = new HashMap<>();
        parents.forEach(s -> bars.put(s, models()
                .withExistingParent(name + "_" + s, Create.asResource("block/bars/" + s))
                .texture("bars", "block/bars/" + name)
                .texture("edge", "block/bars/" + name + "_edge")
                .texture("particle", "block/bars/" + name)
                .renderType(RenderType.CUTOUT_MIPPED.name)
        ));
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block.get())
                .part().modelFile(bars.get("post_ends")).addModel().end();
        builder.part().modelFile(bars.get("post")).addModel()
                .condition(IronBarsBlock.NORTH, false).condition(IronBarsBlock.EAST, false)
                .condition(IronBarsBlock.SOUTH, false).condition(IronBarsBlock.WEST, false)
                .end()
                .part().modelFile(bars.get("cap")).addModel()
                .condition(IronBarsBlock.NORTH, true).condition(IronBarsBlock.EAST, false)
                .condition(IronBarsBlock.SOUTH, false).condition(IronBarsBlock.WEST, false)
                .end()
                .part().modelFile(bars.get("cap")).rotationY(90).addModel()
                .condition(IronBarsBlock.NORTH, false).condition(IronBarsBlock.EAST, true)
                .condition(IronBarsBlock.SOUTH, false).condition(IronBarsBlock.WEST, false)
                .end()
                .part().modelFile(bars.get("cap_alt")).addModel()
                .condition(IronBarsBlock.NORTH, false).condition(IronBarsBlock.EAST, false)
                .condition(IronBarsBlock.SOUTH, true).condition(IronBarsBlock.WEST, false)
                .end()
                .part().modelFile(bars.get("cap_alt")).rotationY(90).addModel()
                .condition(IronBarsBlock.NORTH, false).condition(IronBarsBlock.EAST, false)
                .condition(IronBarsBlock.SOUTH, false).condition(IronBarsBlock.WEST, true)
                .end()
                .part().modelFile(bars.get("side")).addModel()
                .condition(IronBarsBlock.NORTH, true).end()
                .part().modelFile(bars.get("side")).rotationY(90).addModel()
                .condition(IronBarsBlock.EAST, true).end()
                .part().modelFile(bars.get("side_alt")).addModel()
                .condition(IronBarsBlock.SOUTH, true).end()
                .part().modelFile(bars.get("side_alt")).rotationY(90).addModel()
                .condition(IronBarsBlock.WEST, true).end();

    }

    private void metalLadder(MetalLadderBlock block, String name) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int rotation = (state.getValue(LadderBlock.FACING).get2DDataValue()+2)%4*90;
            return ConfiguredModel.builder().modelFile(models()
                    .withExistingParent(name + "_ladder", Create.asResource("block/ladder"))
                    .texture("0", Drift.asResource("block/ladder_" + name + "_hoop"))
                    .texture("1", Drift.asResource("block/ladder_" + name))
                    .texture("particle", Drift.asResource("block/ladder_" + name))
                    .renderType(RenderType.CUTOUT_MIPPED.name)
            ).rotationY(rotation).build();
        }, LadderBlock.WATERLOGGED);
    }
	
	private void windowBlockWithItem(DeferredBlock<TransparentBlock> block, WoodType wood) {
		columnBlockWithItem(block, 
			ResourceLocation.fromNamespaceAndPath(block.getId().getNamespace(), "block/window/" + block.getId().getPath()),
			ResourceLocation.bySeparator(wood.name().replaceFirst(":", ":block/") + "_planks", ':'),
			RenderType.CUTOUT_MIPPED);
	}

    private void windowPane(DeferredBlock<ConnectedGlassPaneBlock> block, ResourceLocation texture, WoodType wood) {
        String woodName = ResourceLocation.bySeparator(wood.name(), ':').getPath();
        List<String> parents = List.of("noside", "noside_alt", "post", "side", "side_alt");
        Map<String, ModelFile> window = new HashMap<>();
        parents.forEach(s -> window.put(s, models()
                .withExistingParent(woodName + "_window_pane_" + s, Create.asResource("block/connected_glass_pane/" + s))
                .texture("pane", ResourceLocation.bySeparator(texture.toString().replaceAll("block/", "block/window/"), ':'))
                .texture("edge", ResourceLocation.bySeparator(wood.name().replaceFirst(":", ":block/") + "_planks", ':'))
                .renderType(RenderType.CUTOUT_MIPPED.name)
        ));
        paneBlock(block.get(), window.get("post"), window.get("side"), window.get("side_alt"), window.get("noside"), window.get("noside_alt"));
    }
	
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(Drift.ID + ":block/" + deferredBlock.getId().getPath()));
    }
	
}
