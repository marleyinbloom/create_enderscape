package garden.inbloom.create_enderscape.datagen;

import garden.inbloom.create_enderscape.register.DriftItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DriftItemModelProvider extends ItemModelProvider {

	public DriftItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
		super(output, modid, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		basicItem(DriftItems.MAGNIA_CONTROL_UNIT.get());
		
		basicItem(DriftItems.DUSK_INGOT.get());
		
		basicItem(DriftItems.SHADOLINE_NUGGET.get());
		basicItem(DriftItems.SHADOLINE_SHEET.get());
		basicItem(DriftItems.CRUSHED_RAW_SHADOLINE.get());
	}

}
