package garden.inbloom.create_enderscape.block.connected;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.simibubi.create.CreateClient;
import com.simibubi.create.content.decoration.encasing.CasingConnectivity;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.foundation.block.connected.CTModel;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.block.connected.HorizontalCTBehaviour;

import garden.inbloom.create_enderscape.block.connected.behaviors.ShadolineRoofCTBehavior;
import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.minecraft.world.level.block.Block;

public class DriftCTBlockRegistry {
	public static void register() {
		registerCTBehviour(DriftBlocks.DUSK_CASING.get(), () -> new EncasedCTBehaviour(DriftSpriteShifts.DUSK_CASING));
		registerCasingConnectivity(DriftBlocks.DUSK_CASING.get(), (block, T) ->
			CreateClient.CASING_CONNECTIVITY.makeCasing(block, DriftSpriteShifts.DUSK_CASING));

		registerCTBehviour(DriftBlocksDeco.SHADOLINE_SHINGLES.get(), () -> new ShadolineRoofCTBehavior(DriftSpriteShifts.SHADOLINE_SHINGLES));
		registerCTBehviour(DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS.get(), () -> new ShadolineRoofCTBehavior(DriftSpriteShifts.SHADOLINE_SHINGLES));
		registerCTBehviour(DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB.get(), () -> new ShadolineRoofCTBehavior(DriftSpriteShifts.SHADOLINE_SHINGLES));
		registerCTBehviour(DriftBlocksDeco.SHADOLINE_TILES.get(), () -> new ShadolineRoofCTBehavior(DriftSpriteShifts.SHADOLINE_TILES));
		registerCTBehviour(DriftBlocksDeco.SHADOLINE_TILE_STAIRS.get(), () -> new ShadolineRoofCTBehavior(DriftSpriteShifts.SHADOLINE_TILES));
		registerCTBehviour(DriftBlocksDeco.SHADOLINE_TILE_SLAB.get(), () -> new ShadolineRoofCTBehavior(DriftSpriteShifts.SHADOLINE_TILES));
		
		registerCTBehviour(DriftBlocksDeco.CELESTIAL_WINDOW.get(), () -> new HorizontalCTBehaviour(DriftSpriteShifts.CELESTIAL_WINDOW));
		registerCTBehviour(DriftBlocksDeco.CELESTIAL_WINDOW_PANE.get(), () -> new HorizontalCTBehaviour(DriftSpriteShifts.CELESTIAL_WINDOW));
		registerCTBehviour(DriftBlocksDeco.MURUBLIGHT_WINDOW.get(), () -> new HorizontalCTBehaviour(DriftSpriteShifts.MURUBLIGHT_WINDOW));
		registerCTBehviour(DriftBlocksDeco.MURUBLIGHT_WINDOW_PANE.get(), () -> new HorizontalCTBehaviour(DriftSpriteShifts.MURUBLIGHT_WINDOW));
		registerCTBehviour(DriftBlocksDeco.VEILED_WINDOW.get(), () -> new HorizontalCTBehaviour(DriftSpriteShifts.VEILED_WINDOW));
		registerCTBehviour(DriftBlocksDeco.VEILED_WINDOW_PANE.get(), () -> new HorizontalCTBehaviour(DriftSpriteShifts.VEILED_WINDOW));
	}
	
	private static <T extends Block> void registerCasingConnectivity(T entry,
			 BiConsumer<T, CasingConnectivity> consumer) {
		consumer.accept(entry, CreateClient.CASING_CONNECTIVITY);
	}
	
	private static void registerCTBehviour(Block entry, Supplier<ConnectedTextureBehaviour> behaviorSupplier) {
		ConnectedTextureBehaviour behavior = behaviorSupplier.get();
		CreateClient.MODEL_SWAPPER.getCustomBlockModels()
			.register(RegisteredObjectsHelper.getKeyOrThrow(entry), model -> new CTModel(model, behavior));
		
	}
}
