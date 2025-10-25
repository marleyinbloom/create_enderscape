package garden.inbloom.create_enderscape.block;

import net.bunten.enderscape.block.properties.MagniaType;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MagniaCouplerBlock extends Block {
	public static final BooleanProperty POWERED = BooleanProperty.create("powered");
	
	public final MagniaType magniaType;
	
	public MagniaCouplerBlock(MagniaType magniaType, Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(POWERED, false));
		this.magniaType = magniaType;
	}
	
	@Override
	protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos otherPos, boolean isMoving) {
		if (!level.isClientSide()) {
			boolean currentState = state.getValue(POWERED);
			boolean isPowered = level.hasNeighborSignal(pos);
			Vec3 soundPos = Vec3.atCenterOf(pos);
			if (currentState != isPowered) {
                level.gameEvent(null, isPowered ? GameEvent.BLOCK_DEACTIVATE : GameEvent.BLOCK_ACTIVATE, pos);
                level.playSound(null, soundPos.x, soundPos.y, soundPos.z,
                        isPowered ? magniaType.getPowerOffSound() : magniaType.getPowerOnSound(),
                        SoundSource.BLOCKS, 1.0f, 1.0f);
                level.setBlockAndUpdate(pos, state.setValue(POWERED, isPowered));
            }
		}
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(POWERED);
	}

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(0, 0, 0, 16, 12, 16);
    }
}
