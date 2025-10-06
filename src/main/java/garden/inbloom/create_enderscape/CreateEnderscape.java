package garden.inbloom.create_enderscape;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;

import garden.inbloom.create_enderscape.block.connected.CrEsSpriteShifts;
import garden.inbloom.create_enderscape.block.CrEsBlocks;
import garden.inbloom.create_enderscape.item.CrEsItems;
import net.bunten.enderscape.registry.EnderscapeCreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CreateEnderscape.MODID)
public class CreateEnderscape {
    public static final String MODID = "create_enderscape";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CreateEnderscape(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        NeoForge.EVENT_BUS.register(this);
        
        // Register items
        CrEsSpriteShifts.register(modEventBus);
        CrEsBlocks.register(modEventBus);
        CrEsItems.register(modEventBus);
        REGISTRATE.registerEventListeners(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    	if (event.getTabKey() == EnderscapeCreativeModeTab.ENDERSCAPE) {
    		event.accept(CrEsItems.SHADOLINE_NUGGET);
    		event.accept(CrEsItems.CRUSHED_RAW_SHADOLINE);
    		event.accept(CrEsBlocks.TEST_BLOCK);
    		event.accept(CrEsBlocks.SHADOLINE_SHINGLES);
    		event.accept(CrEsBlocks.SHADOLINE_TILES);
    	}

    	if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
    	}
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
