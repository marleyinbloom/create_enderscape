package garden.inbloom.create_enderscape.block;

import java.util.function.Supplier;

import com.simibubi.create.content.decoration.palettes.WindowBlock;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.WindowGen;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;

import garden.inbloom.create_enderscape.CreateEnderscape;
import garden.inbloom.create_enderscape.block.connected.CrEsSpriteShifts;
import net.bunten.enderscape.Enderscape;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;

public class CrEsWindowGen extends WindowGen {
	public static final CreateRegistrate REGISTRATE = CreateEnderscape.REGISTRATE;
	
	public static BlockEntry<WindowBlock> woodenWindowBlock(WoodType woodType, Block planksBlock,
			Supplier<Supplier<RenderType>> renderType, boolean translucent) {
		String woodName = woodType.name();
		String name = woodName + "_window";
		NonNullFunction<String, ResourceLocation> end_texture =
			$ -> Enderscape.id("block/" + woodName + "_planks");
		NonNullFunction<String, ResourceLocation> side_texture = n -> CreateEnderscape.asResource("block/" + n);
		return windowBlock(name, () -> planksBlock, () -> CrEsSpriteShifts.getWoodenWindow(woodType), renderType,
			translucent, end_texture, side_texture, planksBlock::defaultMapColor).register();
	}
}
