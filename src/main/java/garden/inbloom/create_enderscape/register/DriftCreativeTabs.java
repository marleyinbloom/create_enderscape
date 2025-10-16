package garden.inbloom.create_enderscape.register;

import java.util.function.Supplier;

import com.simibubi.create.Create;

import garden.inbloom.create_enderscape.Drift;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DriftCreativeTabs {
	public static DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Drift.ID);
	
	public static final Supplier<CreativeModeTab> MAIN = CREATIVE_TAB.register("main",
		() -> CreativeModeTab.builder().icon(() -> new ItemStack(DriftBlocks.DUSK_CASING.get()))
		.title(Component.translatable("tab." + Drift.ID + ".main"))
		.withTabsBefore(Create.asResource("base"))
		.displayItems((parameters, output) -> {
			output.accept(DriftBlocks.DUSK_CASING);
			output.accept(DriftItems.MAGNIA_CONTROL_UNIT);
			output.accept(DriftItems.DUSK_INGOT);
			output.accept(DriftItems.SHADOLINE_NUGGET);
			output.accept(DriftItems.SHADOLINE_SHEET);
			output.accept(DriftItems.CRUSHED_RAW_SHADOLINE);
		}).build());
	
	public static final Supplier<CreativeModeTab> DECO = CREATIVE_TAB.register("deco",
		() -> CreativeModeTab.builder().icon(() -> new ItemStack(DriftBlocksDeco.SHADOLINE_SHINGLES.get()))
		.title(Component.translatable("tab." + Drift.ID + ".deco"))
		.withTabsBefore(Create.asResource("palettes"))
		.displayItems((parameters, output) -> {
			output.accept(DriftBlocksDeco.SHADOLINE_SHINGLES);
			output.accept(DriftBlocksDeco.SHADOLINE_TILES);

			output.accept(DriftBlocksDeco.CELESTIAL_WINDOW);
			output.accept(DriftBlocksDeco.MURUBLIGHT_WINDOW);
			output.accept(DriftBlocksDeco.VEILED_WINDOW);
		}).build());
	
	public static void register(IEventBus event) {
		Drift.LOGGER.info("Registering Creative Tabs!");
		CREATIVE_TAB.register(event);
	}
}
