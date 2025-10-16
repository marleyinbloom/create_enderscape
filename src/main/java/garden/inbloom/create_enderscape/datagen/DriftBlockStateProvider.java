package garden.inbloom.create_enderscape.datagen;

import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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
		roofBlockWithItem(DriftBlocksDeco.SHADOLINE_TILES, "shadoline");
		
		windowBlockWithItem(DriftBlocksDeco.CELESTIAL_WINDOW, EnderscapeBlocks.CELESTIAL_WOOD_TYPE);
		windowBlockWithItem(DriftBlocksDeco.MURUBLIGHT_WINDOW, EnderscapeBlocks.MURUBLIGHT_WOOD_TYPE);
		windowBlockWithItem(DriftBlocksDeco.VEILED_WINDOW, EnderscapeBlocks.VEILED_WOOD_TYPE);
	}

	private void cubeBlockWithItem(DeferredBlock<?> block) {
		simpleBlockWithItem(block.get(), cubeAll(block.get()));
	}


	private void columnBlockWithItem(DeferredBlock<?> block, String side, ResourceLocation top, RenderType renderType) {
		simpleBlockWithItem(block.get(), models().cubeColumn(block.getRegisteredName(), 
			Drift.asResource(side), top).renderType(renderType.name));
	}
	
	private void columnBlockWithItem(DeferredBlock<?> block, String side, String top) {
		simpleBlockWithItem(block.get(), models().cubeColumn(block.getRegisteredName(), 
			Drift.asResource(side), Drift.asResource(top)));
	}

	private void roofBlockWithItem(DeferredBlock<?> block, String madeOf) {
		columnBlockWithItem(block, "block/" + block.getId().getPath(), "block/" + madeOf + "_roof_top");
	}
	
	private void windowBlockWithItem(DeferredBlock<?> block, WoodType wood) {
		columnBlockWithItem(block, "block/windows/" + block.getId().getPath(), 
			ResourceLocation.fromNamespaceAndPath(ResourceLocation.bySeparator(wood.name(), ':').getNamespace(), 
			"block/" + ResourceLocation.bySeparator(wood.name(), ':').getPath() + "_planks"),
			RenderType.CUTOUT_MIPPED);
	}
	
}
