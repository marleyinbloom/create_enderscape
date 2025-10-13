package garden.inbloom.create_enderscape.block;

import java.util.function.Supplier;

import com.simibubi.create.AllTags.AllBlockTags;
import com.simibubi.create.foundation.data.MetalBarsGen;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;

import garden.inbloom.create_enderscape.CreateEnderscape;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class CasingDecoGen {

	public class CasingBarsGen extends MetalBarsGen {
		
		public static BlockEntry<IronBarsBlock> createBars(String name, boolean specialEdge, 
			Supplier<DataIngredient> ingredient, MapColor color, SoundType soundType) {
			return CreateEnderscape.REGISTRATE.block(name + "_bars", IronBarsBlock::new)
				.addLayer(() -> RenderType::cutoutMipped)
				.initialProperties(() -> Blocks.IRON_BARS)
				.properties(p -> p.sound(soundType)
						.mapColor(color))
				.tag(AllBlockTags.WRENCH_PICKUP.tag)
				.tag(AllBlockTags.FAN_TRANSPARENT.tag)
				.transform(TagGen.pickaxeOnly())
				.blockstate(barsBlockState(name, specialEdge))
				.item()
				.model((c, p) -> {
					ResourceLocation barsTexture = p.modLoc("block/bars/" + name + "_bars");
					p.generated(c, barsTexture);
				})
				.recipe((c, p) -> p.stonecutting(ingredient.get(), RecipeCategory.DECORATIONS, c::get, 4))
				.build()
				.register();
		}

	}
	
}
