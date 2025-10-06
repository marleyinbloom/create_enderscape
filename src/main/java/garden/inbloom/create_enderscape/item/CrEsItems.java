package garden.inbloom.create_enderscape.item;

import garden.inbloom.create_enderscape.CreateEnderscape;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CrEsItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateEnderscape.MODID);
	
	public static final DeferredItem<Item> SHADOLINE_NUGGET = ITEMS.register("shadoline_nugget",
		() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> CRUSHED_RAW_SHADOLINE = ITEMS.register("crushed_raw_shadoline",
		() -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> DUSK_INGOT = ITEMS.register("dusk_ingot",
			() -> new Item(new Item.Properties()));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
