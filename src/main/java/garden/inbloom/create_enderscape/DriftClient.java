package garden.inbloom.create_enderscape;

import com.simibubi.create.CreateClient;

import garden.inbloom.create_enderscape.block.connected.DriftCTBlockRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = Drift.ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Drift.ID, value = Dist.CLIENT)
public class DriftClient {
    public DriftClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        DriftCTBlockRegistry.register();
        CreateClient.MODEL_SWAPPER.getCustomBlockModels().forEach((model,F) -> Drift.LOGGER.info(model.toString()));
    }
}
