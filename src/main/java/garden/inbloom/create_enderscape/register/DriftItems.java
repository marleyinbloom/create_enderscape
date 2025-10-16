package garden.inbloom.create_enderscape.register;

import com.google.common.base.Supplier;

import garden.inbloom.create_enderscape.Drift;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DriftItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Drift.ID);

	public static final DeferredItem<Item> MAGNIA_CONTROL_UNIT = registerItem("magnia_control_unit");
	public static final DeferredItem<Item> DUSK_INGOT = registerItem("dusk_ingot");
	public static final DeferredItem<Item> SHADOLINE_NUGGET = registerItem("shadoline_nugget");
	public static final DeferredItem<Item> SHADOLINE_SHEET = registerItem("shadoline_sheet");
	public static final DeferredItem<Item> CRUSHED_RAW_SHADOLINE = registerItem("crushed_raw_shadoline");
    
    //region Registration methods
	protected static DeferredItem<Item> registerItem(String name) {
    	return registerItem(name, () -> new Item(new Item.Properties()));
    }
    
	protected static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> item) {
    	return ITEMS.register(name, item);
    }
    //endregion

    public static void register(IEventBus eventBus) {
		Drift.LOGGER.info("Registering Items!");
        ITEMS.register(eventBus);
    }
}
