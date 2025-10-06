package garden.inbloom.create_enderscape.block.connected;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;

import garden.inbloom.create_enderscape.CreateEnderscape;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;

public class CrEsSpriteShifts extends AllSpriteShifts {
	public static final CTSpriteShiftEntry DUSK_CASING = omni("dusk_casing");

	private static CTSpriteShiftEntry omni(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
	}
	
	public static final CTSpriteShiftEntry SHADOLINE_SHINGLES = roof("shadoline_roof_top", "shadoline_shingles_top");
	public static final CTSpriteShiftEntry SHADOLINE_TILES = roof("shadoline_roof_top", "shadoline_tiles_top");
	
	private static CTSpriteShiftEntry roof(String roof_top_name,String top_name) {
		return getCT(AllCTTypes.ROOF, roof_top_name, top_name);
	}
	
	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, 
				ResourceLocation.fromNamespaceAndPath(CreateEnderscape.MODID, "block/" + blockTextureName),
				ResourceLocation.fromNamespaceAndPath(CreateEnderscape.MODID, "block/" + connectedTextureName + "_connected"));
	}
	
	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}
	
	static {
		CreateEnderscape.LOGGER.info("Registered SpriteShifts!");
	}

	public static void register(IEventBus eventBus) {}
}
