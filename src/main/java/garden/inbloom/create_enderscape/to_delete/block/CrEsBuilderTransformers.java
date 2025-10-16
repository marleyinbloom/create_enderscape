package garden.inbloom.create_enderscape.to_delete.block;

import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

import java.util.function.Supplier;

import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.simibubi.create.content.decoration.MetalScaffoldingBlockItem;
import com.simibubi.create.content.decoration.MetalScaffoldingCTBehaviour;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;

public class CrEsBuilderTransformers extends BuilderTransformers {
	
	public static <B extends Block, P> NonNullUnaryOperator<BlockBuilder<B, P>> scaffold(String name,
			 Supplier<DataIngredient> ingredient, MapColor color, SoundType soundType,
			 CTSpriteShiftEntry scaffoldShift, CTSpriteShiftEntry scaffoldInsideShift,
			 CTSpriteShiftEntry casingShift) {
		return b -> b.initialProperties(() -> Blocks.SCAFFOLDING)
			.properties(p -> p.sound(soundType)
					.mapColor(color))
			.addLayer(() -> RenderType::cutout)
			.blockstate((c, p) -> p.getVariantBuilder(c.get())
				.forAllStatesExcept(s -> {
					String suffix = s.getValue(MetalScaffoldingBlock.BOTTOM) ? "_horizontal" : "";
					return ConfiguredModel.builder()
						.modelFile(p.models()
							.withExistingParent(c.getName() + suffix, p.modLoc("block/scaffold/block" + suffix))
							.texture("top", p.modLoc("block/funnel/" + name + "_funnel_frame"))
							.texture("inside", p.modLoc("block/scaffold/" + name + "_scaffold_inside"))
							.texture("side", p.modLoc("block/scaffold/" + name + "_scaffold"))
							.texture("casing", p.modLoc("block/" + name + "_casing"))
							.texture("particle", p.modLoc("block/scaffold/" + name + "_scaffold")))
						.build();
				}, MetalScaffoldingBlock.WATERLOGGED, MetalScaffoldingBlock.DISTANCE))
			.onRegister(connectedTextures(
					() -> new MetalScaffoldingCTBehaviour(scaffoldShift, scaffoldInsideShift, casingShift)))
			.transform(pickaxeOnly())
			.tag(BlockTags.CLIMBABLE)
			.item(MetalScaffoldingBlockItem::new)
			.recipe((c, p) -> p.stonecutting(ingredient.get(), RecipeCategory.DECORATIONS, c::get, 2))
			.model((c, p) -> p.withExistingParent(c.getName(), p.modLoc("block/" + c.getName())))
			.build();
	}
	
	public static <B extends Block, P> NonNullUnaryOperator<BlockBuilder<B, P>> ladder(String name,
			Supplier<DataIngredient> ingredient, MapColor color, SoundType soundType) {
		return b -> b.initialProperties(() -> Blocks.LADDER)
			.properties(p -> p.mapColor(color))
			.addLayer(() -> RenderType::cutout)
			.blockstate((c, p) -> p.horizontalBlock(c.get(), p.models()
				.withExistingParent(c.getName(), p.modLoc("block/ladder"))
				.texture("0", p.modLoc("block/ladder_" + name + "_hoop"))
				.texture("1", p.modLoc("block/ladder_" + name))
				.texture("particle", p.modLoc("block/ladder_" + name))))
			.properties(p -> p.sound(soundType))
			.transform(pickaxeOnly())
			.tag(BlockTags.CLIMBABLE)
			.item()
			.recipe((c, p) -> p.stonecutting(ingredient.get(), RecipeCategory.DECORATIONS, c::get, 2))
			.model((c, p) -> p.blockSprite(c::get, p.modLoc("block/ladder_" + name)))
			.build();
	}
}
