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
	}
	
	private void miscTranslations() {
		add("tab." + Drift.ID + ".main", "Create: Catch My Drift");
		add("tab." + Drift.ID + ".deco", "Catch My Drift's Building Blocks");
	}
	
	private void blockTranslations() {
		addBlock(DriftBlocks.DUSK_CASING, "Dusk Casing");

		addBlock(DriftBlocksDeco.SHADOLINE_SHINGLES, "Shadoline Shingles");
		addBlock(DriftBlocksDeco.SHADOLINE_TILES, "Shadoline Tiles");

		addBlock(DriftBlocksDeco.CELESTIAL_WINDOW, "Celestial Window");
		addBlock(DriftBlocksDeco.MURUBLIGHT_WINDOW, "Murublight Window");
		addBlock(DriftBlocksDeco.VEILED_WINDOW, "Veiled Window");
	}

	private void itemTranslations() {
		addItem(DriftItems.MAGNIA_CONTROL_UNIT, "Magnia Control Unit");
		
		addItem(DriftItems.DUSK_INGOT, "Dusk Ingot");
		addItem(DriftItems.SHADOLINE_NUGGET, "Shadoline Nugget");
		addItem(DriftItems.SHADOLINE_SHEET, "Shadoline Sheet");
		addItem(DriftItems.CRUSHED_RAW_SHADOLINE, "Crushed Raw Shadoline");

	}

}
