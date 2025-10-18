package garden.inbloom.create_enderscape.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import com.simibubi.create.Create;

import garden.inbloom.create_enderscape.Drift;
import net.bunten.enderscape.registry.EnderscapeItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DriftAdvancementProvider extends AdvancementProvider {
	
	public DriftAdvancementProvider(PackOutput output, CompletableFuture<Provider> registries,
			ExistingFileHelper existingFileHelper) {
		super(output, registries, existingFileHelper, List.of(new Generator()));
	}
	
	private static final class Generator implements AdvancementGenerator {
		@SuppressWarnings("unused")
		@Override
		public void generate(Provider registries, Consumer<AdvancementHolder> saver,
				ExistingFileHelper existingFileHelper) {
			Advancement.Builder builder = Advancement.Builder.advancement();
			
			builder.parent(AdvancementSubProvider.createPlaceholder(Create.asResource("mechanical_press").toString()));
			builder.display(EnderscapeItems.CRACKED_MIRROR.get(),
				Component.translatable("advancement." + Drift.ID + ".cracked_mirror.title"),
				Component.translatable("advancement." + Drift.ID + ".cracked_mirror.desc"),
				null, AdvancementType.GOAL, true, true, true);
			builder.addCriterion("has_cracked_mirror", 
				InventoryChangeTrigger.TriggerInstance.hasItems(EnderscapeItems.CRACKED_MIRROR.get()));
			builder.requirements(AdvancementRequirements.allOf(List.of("has_cracked_mirror")));
			AdvancementHolder CRACKED_MIRROR = builder.save(saver, Drift.asResource("cracked_mirror"), existingFileHelper);
		}	
	}
}
