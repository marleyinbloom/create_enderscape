package garden.inbloom.create_enderscape.register;

import com.simibubi.create.Create;
import garden.inbloom.create_enderscape.Drift;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DriftCreativeTabs {
	public static DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Drift.ID);
	public static List<ItemLike> MAIN_BLOCKS = new ArrayList<>();
	public static List<ItemLike> MAIN_ITEMS = new ArrayList<>();
	public static List<ItemLike> DECO_BLOCKS = new ArrayList<>();
	public static List<ItemLike> DECO_ITEMS = new ArrayList<>();
	
	@SuppressWarnings("unused")
    public static final Supplier<CreativeModeTab> MAIN = CREATIVE_TAB.register("main",
		() -> CreativeModeTab.builder().icon(() -> new ItemStack(DriftBlocks.DUSK_CASING.get()))
		.title(Component.translatable("tab." + Drift.ID + ".main"))
		.withTabsBefore(Create.asResource("base"))
		.displayItems((parameters, output) -> {
			MAIN_BLOCKS.forEach(output::accept);
			MAIN_ITEMS.forEach(output::accept);
		}).build());

    @SuppressWarnings("unused")
	public static final Supplier<CreativeModeTab> DECO = CREATIVE_TAB.register("deco",
		() -> CreativeModeTab.builder().icon(() -> new ItemStack(DriftBlocksDeco.SHADOLINE_SHINGLES.get()))
		.title(Component.translatable("tab." + Drift.ID + ".deco"))
		.withTabsBefore(Create.asResource("palettes"))
		.displayItems((parameters, output) -> {
			DECO_BLOCKS.forEach(output::accept);
			DECO_ITEMS.forEach(output::accept);
		}).build());
	
	public static void register(IEventBus event) {
		Drift.LOGGER.info("Registering Creative Tabs!");
		CREATIVE_TAB.register(event);
	}
}
