package garden.inbloom.create_enderscape.block.connected;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;

import garden.inbloom.create_enderscape.Drift;
import net.neoforged.bus.api.IEventBus;

public class DriftSpriteShifts extends AllSpriteShifts {
	public static final CTSpriteShiftEntry DUSK_CASING = omni("dusk_casing");
	
	public static final CTSpriteShiftEntry DUSK_SCAFFOLD = horizontal("scaffold/dusk_scaffold"),
			DUSK_SCAFFOLD_INSIDE = horizontal("scaffold/dusk_scaffold_inside");
	
	public static final CTSpriteShiftEntry SHADOLINE_SHINGLES = roof("shadoline_roof_top", "shadoline_shingles_top"),
		SHADOLINE_TILES = roof("shadoline_roof_top", "shadoline_tiles_top");

	public static final CTSpriteShiftEntry CELESTIAL_WINDOW = vertical("windows/celestial_window");

	private static CTSpriteShiftEntry omni(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
	}
	
	private static CTSpriteShiftEntry roof(String roof_top_name, String top_name) {
		return getCT(AllCTTypes.ROOF, roof_top_name, top_name);
	}
	
	private static CTSpriteShiftEntry horizontal(String name) {
		return getCT(AllCTTypes.HORIZONTAL, name);
	}
	
	private static CTSpriteShiftEntry vertical(String name) {
		return getCT(AllCTTypes.VERTICAL, name);
	}
	
	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, Drift.asResource("block/" + blockTextureName),
				Drift.asResource("block/" + connectedTextureName + "_connected"));
	}
	
	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}
	

	static {
		Drift.LOGGER.info("Registered SpriteShifts!");
	}

	public static void register(IEventBus eventBus) {}
}
