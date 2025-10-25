package garden.inbloom.create_enderscape.datagen;

import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.register.DriftBlocks;
import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import garden.inbloom.create_enderscape.register.DriftItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DriftLanguageProvider extends LanguageProvider {

	public DriftLanguageProvider(PackOutput output, String modid) {
		super(output, modid, "en_us");
	}

	@Override
	protected void addTranslations() {
		miscTranslations();
		
		blockTranslations();
		itemTranslations();
		advancementTranslations();
	}
	
	private void miscTranslations() {
		add("tab." + Drift.ID + ".main", "Create: Catch My Drift");
		add("tab." + Drift.ID + ".deco", "Catch My Drift's Building Blocks");
	}
	
	private void blockTranslations() {
		addBlock(DriftBlocks.DUSK_CASING, "Dusk Casing");
		addBlock(DriftBlocks.ALLURING_MAGNIA_COUPLER, "Alluring Magnia Coupler");
		addBlock(DriftBlocks.REPULSIVE_MAGNIA_COUPLER, "Repulsive Magnia Coupler");

		addBlock(DriftBlocksDeco.SHADOLINE_SHINGLES, "Shadoline Shingles");
		addBlock(DriftBlocksDeco.SHADOLINE_SHINGLE_STAIRS, "Shadoline Shingle Stairs");
		addBlock(DriftBlocksDeco.SHADOLINE_SHINGLE_SLAB, "Shadoline Shingle Slab");
		addBlock(DriftBlocksDeco.SHADOLINE_TILES, "Shadoline Tiles");
		addBlock(DriftBlocksDeco.SHADOLINE_TILE_STAIRS, "Shadoline Tile Stairs");
		addBlock(DriftBlocksDeco.SHADOLINE_TILE_SLAB, "Shadoline Tile Slab");

		addBlock(DriftBlocksDeco.CELESTIAL_WINDOW, "Celestial Window");
		addBlock(DriftBlocksDeco.CELESTIAL_WINDOW_PANE, "Celestial Window Pane");
		addBlock(DriftBlocksDeco.MURUBLIGHT_WINDOW, "Murublight Window");
		addBlock(DriftBlocksDeco.MURUBLIGHT_WINDOW_PANE, "Murublight Window Pane");
		addBlock(DriftBlocksDeco.VEILED_WINDOW, "Veiled Window");
		addBlock(DriftBlocksDeco.VEILED_WINDOW_PANE, "Veiled Window Pane");
	}

	private void itemTranslations() {
		addItem(DriftItems.MAGNIA_CONTROL_UNIT, "Magnia Control Unit");
		
		addItem(DriftItems.DUSK_INGOT, "Dusk Ingot");
		addItem(DriftItems.SHADOLINE_NUGGET, "Shadoline Nugget");
		addItem(DriftItems.SHADOLINE_SHEET, "Shadoline Sheet");
		addItem(DriftItems.CRUSHED_RAW_SHADOLINE, "Crushed Raw Shadoline");
	}
	
	private void advancementTranslations() {
		addAdvancement("cracked_mirror", 
			"Chaotic Evil",
			"\"I am NOT going to put the mirror here.\"\n§7(Hidden Advancement)");
		addAdvancement("dusk_ingot", 
			"Poppin' Alloys", 
			"Obtain some Dusk Ingots, made with materials found beyond The End.");
		addAdvancement("dusk_casing", 
			"The Dusk Age", 
			"Apply Dusk Ingots to stripped wood, creating a mysterious casing for your machines.");
		addAdvancement("magnia_coupler", 
			"Magnetic Shafts", 
			"Use two Magnia Couplers to send torque over a distance.");
		addAdvancement("nebula_amplifier", 
			"Purpurtual Motion Machine", 
			"Use a Nebula Amplifier with Nebulite fuel to multiply your stress capacity.");
		addAdvancement("nebula_amplifier_break", 
			"Conservation of Energy", 
			"Be disappointed after attempting to connect a Nebula Amplifier to itself.\n§7(Hidden Advancement)");
	}
	
	private void addAdvancement(String id, String title, String desc) {
		String titleKey = "advancement." + Drift.ID + "." + id + ".title";
		String descKey = "advancement." + Drift.ID + "." + id + ".desc";
		add(titleKey, title);
		add(descKey, desc);
	}

}
