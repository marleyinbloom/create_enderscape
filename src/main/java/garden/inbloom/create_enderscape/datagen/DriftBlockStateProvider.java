package garden.inbloom.create_enderscape.datagen;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;

import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DriftBlockStateProvider extends BlockStateProvider {

	public DriftBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
		super(output, modid, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		cubeBlockWithItem(DriftBlocks.DUSK_CASING);

		roofBlockWithItem(DriftBlocksDeco.SHADOLINE_SHINGLES, "shadoline");
		roofStairsWithItem(DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS, blockTexture(DriftBlocksDeco.SHADOLINE_SHINGLES.get()), "shadoline");
		roofSlabWithItem(DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB, blockTexture(DriftBlocksDeco.SHADOLINE_SHINGLES.get()), "shadoline");
		roofBlockWithItem(DriftBlocksDeco.SHADOLINE_TILES, "shadoline");
		roofStairsWithItem(DriftBlocksDeco.SHADOLINE_TILE_STAIRS, blockTexture(DriftBlocksDeco.SHADOLINE_TILES.get()), "shadoline");
		roofSlabWithItem(DriftBlocksDeco.SHADOLINE_TILE_SLAB, blockTexture(DriftBlocksDeco.SHADOLINE_TILES.get()), "shadoline");
		
		windowBlockWithItem(DriftBlocksDeco.CELESTIAL_WINDOW, EnderscapeBlocks.CELESTIAL_WOOD_TYPE);
		windowPaneWithItem(DriftBlocksDeco.CELESTIAL_WINDOW_PANE, blockTexture(DriftBlocksDeco.CELESTIAL_WINDOW.get()), 
			EnderscapeBlocks.CELESTIAL_WOOD_TYPE);
		windowBlockWithItem(DriftBlocksDeco.MURUBLIGHT_WINDOW, EnderscapeBlocks.MURUBLIGHT_WOOD_TYPE);
		windowPaneWithItem(DriftBlocksDeco.MURUBLIGHT_WINDOW_PANE, blockTexture(DriftBlocksDeco.MURUBLIGHT_WINDOW.get()), 
			EnderscapeBlocks.MURUBLIGHT_WOOD_TYPE);
		windowBlockWithItem(DriftBlocksDeco.VEILED_WINDOW, EnderscapeBlocks.VEILED_WOOD_TYPE);
		windowPaneWithItem(DriftBlocksDeco.VEILED_WINDOW_PANE, blockTexture(DriftBlocksDeco.VEILED_WINDOW.get()), 
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
	
	private void windowBlockWithItem(DeferredBlock<TransparentBlock> block, WoodType wood) {
		columnBlockWithItem(block, 
			ResourceLocation.fromNamespaceAndPath(block.getId().getNamespace(), "block/windows/" + block.getId().getPath()),
			ResourceLocation.bySeparator(wood.name().replaceFirst(":", ":block/") + "_planks", ':'),
			RenderType.CUTOUT_MIPPED);
	}
	
	private void windowPaneWithItem(DeferredBlock<ConnectedGlassPaneBlock> block, ResourceLocation texture, WoodType wood) {
		paneBlockWithRenderType(block.get(), 
			ResourceLocation.bySeparator(texture.toString().replaceAll("block/", "block/windows/"), ':'),
			ResourceLocation.bySeparator(wood.name().replaceFirst(":", ":block/") + "_planks", ':'),
			RenderType.CUTOUT_MIPPED.name);
		blockItem(block);
	}
	
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(Drift.ID + ":block/" + deferredBlock.getId().getPath()));
    }
	
}
