package garden.inbloom.create_enderscape.register;

import static garden.inbloom.create_enderscape.register.CrEsTags.NameSpace.COMMON;
import static garden.inbloom.create_enderscape.register.CrEsTags.NameSpace.CREATE;
import static garden.inbloom.create_enderscape.register.CrEsTags.NameSpace.MOD;

import javax.annotation.Nullable;

import com.simibubi.create.Create;

import garden.inbloom.create_enderscape.Drift;
import net.bunten.enderscape.Enderscape;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class CrEsTags {
	public enum NameSpace {
		MOD(Drift.MODID),
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
	
	public enum CrEsBlockTags {
		CONNECTS_TO_ROOF_BLOCKS(CREATE, "connects_to_roof_blocks"),
		CONNECTS_TO_ROOF_BLOCKS_COPPER(CREATE, "connects_to_roof_blocks/copper"),
		CONNECTS_TO_ROOF_BLOCKS_SHADOLINE(CREATE, "connects_to_roof_blocks/shadoline"),
		ROOF_BLOCKS(CREATE, "roof_blocks"),
		ROOF_BLOCKS_COPPER(CREATE, "roof_blocks/copper"),
		ROOF_BLOCKS_SHADOLINE(CREATE, "roof_blocks/shadoline"),
		
		FAN_PROCESSING_CATALYSTS_CORRUPTING(MOD, "fan_processing_catalysts/corrupting"),
		;
		
		public final TagKey<Block> tag;

		CrEsBlockTags() {
			this(MOD);
		}

		CrEsBlockTags(NameSpace namespace) {
			this(namespace, null);
		}

		CrEsBlockTags(NameSpace namespace, @Nullable String pathOverride) {
			this.tag = TagKey.create(Registries.BLOCK, namespace.id(this, pathOverride));
		}
		
		public boolean matches(ItemStack stack) {
			return stack != null && stack.getItem() instanceof BlockItem blockItem && matches(blockItem.getBlock().defaultBlockState());
		}

		public boolean matches(BlockState state) {
			return state.is(tag);
		}
	}
	
	public enum CrEsFluidTags {
		FAN_PROCESSING_CATALYSTS_CORRUPTING(MOD, "fan_processing_catalysts/corrupting"),

		DRIFT_JELLY(COMMON);

		public final TagKey<Fluid> tag;

		CrEsFluidTags() {
			this(MOD);
		}

		CrEsFluidTags(NameSpace namespace) {
			this(namespace, null);
		}

		CrEsFluidTags(NameSpace namespace, @Nullable String pathOverride) {
			this.tag = TagKey.create(Registries.FLUID, namespace.id(this, pathOverride));
		}

		public boolean matches(Fluid fluid) {
			return fluid.defaultFluidState().is(tag);
		}

		public boolean matches(FluidState state) {
			return state.is(tag);
		}
	}

}
