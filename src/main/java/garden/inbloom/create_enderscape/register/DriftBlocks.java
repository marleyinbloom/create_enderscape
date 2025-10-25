package garden.inbloom.create_enderscape.register;

import com.google.common.base.Supplier;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import garden.inbloom.create_enderscape.Drift;
import garden.inbloom.create_enderscape.block.MagniaCouplerBlock;
import net.bunten.enderscape.block.properties.MagniaType;
import net.bunten.enderscape.registry.EnderscapeSoundTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class DriftBlocks {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Drift.ID);
	
	//region Block definitions
	public static final DeferredBlock<CasingBlock> DUSK_CASING = registerBlock("dusk_casing", 
		() -> new CasingBlock(Block.Properties.ofFullCopy(AllBlocks.ANDESITE_CASING.get())
		.mapColor(MapColor.COLOR_BLACK).sound(EnderscapeSoundTypes.PURPUR)));
	
	public static final DeferredBlock<MagniaCouplerBlock> ALLURING_MAGNIA_COUPLER = registerBlock("alluring_magnia_coupler",
		() -> new MagniaCouplerBlock(MagniaType.ALLURING, BlockBehaviour.Properties.ofFullCopy(AllBlocks.ANDESITE_CASING.get())
		.noOcclusion()
		.lightLevel(state -> state.getValue(MagniaCouplerBlock.POWERED) ? 0 : 12)));
	
	public static final DeferredBlock<MagniaCouplerBlock> REPULSIVE_MAGNIA_COUPLER = registerBlock("repulsive_magnia_coupler",
		() -> new MagniaCouplerBlock(MagniaType.REPULSIVE, BlockBehaviour.Properties.ofFullCopy(AllBlocks.ANDESITE_CASING.get())
		.noOcclusion()
		.lightLevel(state -> state.getValue(MagniaCouplerBlock.POWERED) ? 0 : 12)));

	//endregion

	//region Registration methods
	protected static <T extends Block> DeferredBlock<T> registerDecoBlock(String name, Supplier<T> block) {
        return registerDecoBlock(name, block, true);
    }
	
	protected static <T extends Block> DeferredBlock<T> registerDecoBlock(String name, Supplier<T> block, Boolean andItem) {
        return registerBlock(name, block, andItem, DriftCreativeTabs.MAIN_BLOCKS);
    }
	
	protected static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, true);
    }
	
	protected static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Boolean andItem) {
        return registerBlock(name, block, andItem, DriftCreativeTabs.MAIN_BLOCKS);
    }
	
	protected static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Boolean andItem, List<ItemLike> creativeList) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        if (andItem)
        	registerBlockItem(name, toReturn, creativeList);
        return toReturn;
    }

	protected static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, List<ItemLike> creativeList) {
        DriftItems.registerItem(name, () -> new BlockItem(block.get(), new Item.Properties()), creativeList);
    }
	//endregion
    
	public static void register(IEventBus event) {
		Drift.LOGGER.info("Registering Blocks!");
		DriftBlocksDeco.register();
		BLOCKS.register(event);
	}
}
