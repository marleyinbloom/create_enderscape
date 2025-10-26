package garden.inbloom.create_enderscape.datagen;

import com.simibubi.create.Create;
import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.register.DriftItems;
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

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class DriftAdvancementProvider extends AdvancementProvider {
	
	public DriftAdvancementProvider(PackOutput output, CompletableFuture<Provider> registries,
			ExistingFileHelper existingFileHelper) {
		super(output, registries, existingFileHelper, List.of(new Generator()));
	}
	
	private static final class Generator implements AdvancementGenerator {
		@SuppressWarnings("unused")
		@Override
		public void generate(Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
			AdvancementHolder CRACKED_MIRROR = Advancement.Builder.advancement()
			.parent(AdvancementSubProvider.createPlaceholder(Create.asResource("mechanical_press").toString()))
			.display(EnderscapeItems.CRACKED_MIRROR.get(),
				Component.translatable("advancement." + Drift.ID + ".cracked_mirror.title"),
				Component.translatable("advancement." + Drift.ID + ".cracked_mirror.desc"),
				null, AdvancementType.GOAL, true, true, true)
			.addCriterion("has_cracked_mirror", 
				InventoryChangeTrigger.TriggerInstance.hasItems(EnderscapeItems.CRACKED_MIRROR.get()))
			.requirements(AdvancementRequirements.allOf(List.of("has_cracked_mirror")))
			.save(saver, Drift.asResource("cracked_mirror"), existingFileHelper);

			AdvancementHolder DUSK_INGOT = Advancement.Builder.advancement()
			.parent(AdvancementSubProvider.createPlaceholder(Create.asResource("brass").toString()))
			.display(DriftItems.DUSK_INGOT.get(),
					Component.translatable("advancement." + Drift.ID + ".dusk_ingot.title"),
					Component.translatable("advancement." + Drift.ID + ".dusk_ingot.desc"),
					null, AdvancementType.TASK, false, true, false)
			.addCriterion("has_dusk_ingot", 
				InventoryChangeTrigger.TriggerInstance.hasItems(DriftItems.DUSK_INGOT.get()))
			.requirements(AdvancementRequirements.allOf(List.of("has_dusk_ingot")))
			.save(saver, Drift.asResource("dusk_ingot"), existingFileHelper);
			
		}	
	}
}
