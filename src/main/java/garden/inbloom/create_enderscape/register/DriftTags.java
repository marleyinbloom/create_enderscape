package garden.inbloom.create_enderscape.register;

import static garden.inbloom.create_enderscape.register.DriftTags.NameSpace.COMMON;
import static garden.inbloom.create_enderscape.register.DriftTags.NameSpace.CREATE;
import static garden.inbloom.create_enderscape.register.DriftTags.NameSpace.MOD;

import javax.annotation.Nullable;

import com.simibubi.create.Create;

import garden.inbloom.create_enderscape.Drift;
import net.bunten.enderscape.Enderscape;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class DriftTags {
	public enum NameSpace {
		MOD(Drift.ID),
		CREATE(Create.ID),
		ENDERSCAPE(Enderscape.MOD_ID),
		VANILLA("minecraft"),
		COMMON("c");

		public final String id;

		NameSpace(String id) {
			this.id = id;
		}

		public ResourceLocation id(String path) {
			return ResourceLocation.fromNamespaceAndPath(this.id, path);
		}

		public ResourceLocation id(Enum<?> entry, @Nullable String pathOverride) {
			return this.id(pathOverride != null ? pathOverride : Lang.asId(entry.name()));
		}
	}
	
	public enum DriftBlockTags {
		CONNECTS_TO_ROOF_BLOCKS(CREATE, "connects_to_roof_blocks"),
		CONNECTS_TO_ROOF_BLOCKS_COPPER(CREATE, "connects_to_roof_blocks/copper"),
		CONNECTS_TO_ROOF_BLOCKS_SHADOLINE(CREATE, "connects_to_roof_blocks/shadoline"),
		ROOF_BLOCKS(CREATE, "roof_blocks"),
		ROOF_BLOCKS_COPPER(CREATE, "roof_blocks/copper"),
		ROOF_BLOCKS_SHADOLINE(CREATE, "roof_blocks/shadoline"),
		
		FAN_PROCESSING_CATALYSTS_CORRUPTING(MOD, "fan_processing_catalysts/corrupting"),

		STORAGE_BLOCKS(COMMON, "storage_blocks"),
		STORAGE_BLOCKS_SHADOLINE(COMMON, "storage_blocks/shadoline"),
		STORAGE_BLOCKS_RAW_SHADOLINE(COMMON, "storage_blocks/raw_shadoline"),
		STRIPPED_LOGS(COMMON, "stripped_logs"),
		STRIPPED_WOOD(COMMON, "stripped_wood"),
		;
		
		//region Block tag methods
		public final TagKey<Block> tag;

		DriftBlockTags() {
			this(MOD);
		}

		DriftBlockTags(NameSpace namespace) {
			this(namespace, null);
		}

		DriftBlockTags(NameSpace namespace, @Nullable String pathOverride) {
			this.tag = TagKey.create(Registries.BLOCK, namespace.id(this, pathOverride));
		}
		
		public boolean matches(ItemStack stack) {
			return stack != null && stack.getItem() instanceof BlockItem blockItem && matches(blockItem.getBlock().defaultBlockState());
		}

		public boolean matches(BlockState state) {
			return state.is(tag);
		}
		//endregion
	}
	
	public enum DriftItemTags {
		INGOTS(COMMON, "ingots"),
		INGOTS_DUSK(COMMON, "ingots/dusk"),
		INGOTS_SHADOLINE(COMMON, "ingots/shadoline"),
		NUGGETS(COMMON, "nuggets"),
		NUGGETS_SHADOLINE(COMMON, "nuggets/shadoline"),
		RAW_MATERIALS(COMMON, "raw_materials"),
		RAW_MATERIALS_SHADOLINE(COMMON, "raw_materials/shadoline"),
		STORAGE_BLOCKS(COMMON, "storage_blocks"),
		STORAGE_BLOCKS_SHADOLINE(COMMON, "storage_blocks/shadoline"),
		STORAGE_BLOCKS_RAW_SHADOLINE(COMMON, "storage_blocks/raw_shadoline"),
		STRIPPED_LOGS(COMMON, "stripped_logs"),
		STRIPPED_WOOD(COMMON, "stripped_wood"),
		;
		
		//region Block tag methods
		public final TagKey<Item> tag;

		DriftItemTags() {
			this(MOD);
		}

		DriftItemTags(NameSpace namespace) {
			this(namespace, null);
		}

		DriftItemTags(NameSpace namespace, @Nullable String pathOverride) {
			this.tag = TagKey.create(Registries.ITEM, namespace.id(this, pathOverride));
		}

		public boolean matches(ItemStack state) {
			return state.is(tag);
		}
		//endregion
	}
	
	public enum DriftFluidTags {
		FAN_PROCESSING_CATALYSTS_CORRUPTING(MOD, "fan_processing_catalysts/corrupting"),

		DRIFT_JELLY(COMMON);

		//region Fluid tag methods
		public final TagKey<Fluid> tag;

		DriftFluidTags() {
			this(MOD);
		}

		DriftFluidTags(NameSpace namespace) {
			this(namespace, null);
		}

		DriftFluidTags(NameSpace namespace, @Nullable String pathOverride) {
			this.tag = TagKey.create(Registries.FLUID, namespace.id(this, pathOverride));
		}

		public boolean matches(Fluid fluid) {
			return fluid.defaultFluidState().is(tag);
		}

		public boolean matches(FluidState state) {
			return state.is(tag);
		}
		//endregion
	}
}
