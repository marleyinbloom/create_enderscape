package garden.inbloom.create_enderscape.datagen;

import java.util.Objects;

import garden.inbloom.create_enderscape.register.DriftBlocksDeco;
import garden.inbloom.create_enderscape.register.DriftItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

		windowPaneItem(DriftBlocksDeco.CELESTIAL_WINDOW_PANE.asItem());
		windowPaneItem(DriftBlocksDeco.MURUBLIGHT_WINDOW_PANE.asItem());
		windowPaneItem(DriftBlocksDeco.VEILED_WINDOW_PANE.asItem());
	}
	
    public ItemModelBuilder windowPaneItem(Item item) {
        return windowPaneItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    
    public ItemModelBuilder windowPaneItem(ResourceLocation item) {
        return getBuilder(item.toString())
            .parent(new ModelFile.UncheckedModelFile("item/generated"))
            .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(),
            	"block/windows/" + item.getPath().replaceAll("_pane", "")));
    }
}
