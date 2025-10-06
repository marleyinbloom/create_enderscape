package garden.inbloom.create_enderscape.block;

import java.util.function.Supplier;

import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.RoofBlockCTBehaviour;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.block.connected.AllCTTypes;

import garden.inbloom.create_enderscape.CreateEnderscape;
import garden.inbloom.create_enderscape.block.connected.CrEsSpriteShifts;
import garden.inbloom.create_enderscape.block.connected.ShadolineRoofCTBehavior;
import garden.inbloom.create_enderscape.item.CrEsItems;
import net.bunten.enderscape.registry.EnderscapeBlocks;
import net.bunten.enderscape.registry.EnderscapeNoteBlockInstruments;
import net.bunten.enderscape.registry.EnderscapeSoundTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CrEsBlocks {
	public static final CreateRegistrate REGISTRATE = CreateEnderscape.REGISTRATE;
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateEnderscape.MODID);
	
	public static final BlockEntry<Block> TEST_BLOCK = REGISTRATE.block("test_block", 
	    properties -> new Block(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.CUT_SHADOLINE.get())))
	    .item().build().register();
	public static final BlockEntry<Block> SHADOLINE_SHINGLES = REGISTRATE.block("shadoline_shingles", 
	    properties -> new Block(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.CUT_SHADOLINE.get())))
		.onRegister(CreateRegistrate.connectedTextures(() -> new ShadolineRoofCTBehavior(CrEsSpriteShifts.SHADOLINE_SHINGLES)))
	    .item().build().register();
	public static final BlockEntry<Block> SHADOLINE_TILES = REGISTRATE.block("shadoline_tiles", 
	    properties -> new Block(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.CUT_SHADOLINE.get())))
			.onRegister(CreateRegistrate.connectedTextures(() -> new ShadolineRoofCTBehavior(CrEsSpriteShifts.SHADOLINE_TILES)))
	    .item().build().register();
	public static final BlockEntry<CasingBlock> DUSK_CASING = REGISTRATE.block("dusk_casing",
	    properties -> new CasingBlock(BlockBehaviour.Properties.ofFullCopy(EnderscapeBlocks.DUSK_PURPUR_BLOCK.get())
	    	.sound(EnderscapeSoundTypes.PURPUR)))
	    .transform(BuilderTransformers.casing(() -> CrEsSpriteShifts.DUSK_CASING))
	    .register();

	static {
		CreateEnderscape.LOGGER.info("Registered Blocks!");
	}
	
	public static void register(IEventBus eventBus) {}
}
