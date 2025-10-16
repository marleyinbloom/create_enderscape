package garden.inbloom.create_enderscape.block.connected;

import java.util.function.Supplier;

import com.simibubi.create.CreateClient;
import com.simibubi.create.foundation.block.connected.CTModel;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.tterrag.registrate.util.nullness.NonNullConsumer;

import net.createmod.catnip.platform.CatnipServices;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class ConnectedBlock extends Block {
	
	
	public ConnectedBlock(Properties properties) {
		super(properties);
	}

	public static NonNullConsumer<? super Block> connectedTextures(
		Supplier<ConnectedTextureBehaviour> behavior) {
		return entry -> CatnipServices.PLATFORM.executeOnClientOnly(() -> () -> registerCTBehviour(entry, behavior));
	}
	
	@OnlyIn(Dist.CLIENT)
	private static void registerCTBehviour(Block entry, Supplier<ConnectedTextureBehaviour> behaviorSupplier) {
		ConnectedTextureBehaviour behavior = behaviorSupplier.get();
		CreateClient.MODEL_SWAPPER.getCustomBlockModels()
			.register(RegisteredObjectsHelper.getKeyOrThrow(entry), model -> new CTModel(model, behavior));
	}

}
