package garden.inbloom.create_enderscape.register;

import com.google.common.base.Supplier;
import com.simibubi.create.AllBlocks;

import garden.inbloom.create_enderscape.Drift;
import net.bunten.enderscape.registry.EnderscapeSoundTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DriftBlocks {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Drift.ID);
	
	//region Block definitions
	public static final DeferredBlock<Block> DUSK_CASING = registerBlock("dusk_casing", 
		() -> new Block(Block.Properties.ofFullCopy(AllBlocks.ANDESITE_CASING.get())
		.mapColor(MapColor.COLOR_BLACK).sound(EnderscapeSoundTypes.PURPUR)));
	//endregion

	//region Registration methods
	protected static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, true);
    }
	
	protected static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Boolean andItem) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        if (andItem)
        	registerBlockItem(name, toReturn);
        return toReturn;
    }

	protected static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        DriftItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
	//endregion
    
    
	public static void register(IEventBus event) {
		Drift.LOGGER.info("Registering Blocks!");
		DriftBlocksDeco.register();
		BLOCKS.register(event);
	}
}
