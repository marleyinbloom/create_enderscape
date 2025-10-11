package garden.inbloom.create_enderscape.register;

import garden.inbloom.create_enderscape.CreateEnderscape;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;

public class CrEsItems {
	public static final CreateRegistrate REGISTRATE = CreateEnderscape.REGISTRATE;

	public static final ItemEntry<Item> DUSK_INGOT = REGISTRATE.item("dusk_ingot", Item::new)
			.properties(p -> p)
			.lang("Dusk Ingot")
			.register();
	public static final ItemEntry<Item> SHADOLINE_NUGGET = REGISTRATE.item("shadoline_nugget", Item::new)
			.properties(p -> p)
			.lang("Shadoline Nugget")
			.register();
	public static final ItemEntry<Item> SHADOLINE_SHEET = REGISTRATE.item("shadoline_sheet", Item::new)
			.properties(p -> p)
			.lang("Shadoline Sheet")
			.register();
	public static final ItemEntry<Item> CRUSHED_RAW_SHADOLINE = REGISTRATE.item("crushed_raw_shadoline", Item::new)
			.properties(p -> p)
			.lang("Crushed Raw Shadoline")
			.register();
	public static final ItemEntry<Item> MAGNIA_CONTROL_UNIT = REGISTRATE.item("magnia_control_unit", Item::new)
			.properties(p -> p)
			.lang("Magnia Control Unit")
			.register();
	
	
	public static void register(IEventBus eventBus) {}
}
