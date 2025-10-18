package garden.inbloom.create_enderscape.datagen;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import garden.inbloom.create_enderscape.Drift;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DriftDatagen {
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		ExistingFileHelper existFile = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
		String modid = Drift.ID;
		DriftTagProvider tagProvider = new DriftTagProvider();
		BlockTagsProvider blockTagProvider = tagProvider.new DriftBlockTagProvider(output, lookup, modid, existFile);
		
		generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), 
			List.of(new LootTableProvider.SubProviderEntry(DriftBlockLootTableProvider::new, LootContextParamSets.BLOCK)),
			lookup));
		generator.addProvider(event.includeServer(), blockTagProvider);
		generator.addProvider(event.includeServer(), tagProvider.new DriftItemTagProvider(output, lookup, 
				blockTagProvider.contentsGetter(), modid, existFile));
		generator.addProvider(event.includeServer(), new DriftRecipeProvider(output, lookup));
		generator.addProvider(event.includeServer(), new DriftAdvancementProvider(output, lookup, existFile));
		
		if (event.includeServer())
			DriftRecipeProvider.registerAllProcessing(generator, output, lookup, modid);

		generator.addProvider(event.includeClient(), new DriftLanguageProvider(output, modid));
		generator.addProvider(event.includeClient(), new DriftItemModelProvider(output, modid, existFile));
		generator.addProvider(event.includeClient(), new DriftBlockStateProvider(output, modid, existFile));
	}
}
