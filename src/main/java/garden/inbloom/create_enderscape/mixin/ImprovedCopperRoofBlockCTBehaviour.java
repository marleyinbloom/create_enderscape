package garden.inbloom.create_enderscape.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import com.simibubi.create.content.decoration.RoofBlockCTBehaviour;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;

import garden.inbloom.create_enderscape.register.DriftTags.DriftBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(RoofBlockCTBehaviour.class)
public abstract class ImprovedCopperRoofBlockCTBehaviour extends ConnectedTextureBehaviour.Base {

	@Inject(method = "connects", at = @At("HEAD"), cancellable = true)
	private void connects(BlockAndTintGetter reader, BlockPos pos, BlockState state, BlockState other, CallbackInfoReturnable<Boolean> callback) {
		double top = state.getCollisionShape(reader, pos)
			.max(Axis.Y);
		boolean canConnect = (other.is(DriftBlockTags.ROOF_BLOCKS.tag) || other.is(DriftBlockTags.ROOFS_CONNECT_TO_COPPER.tag));
		double topOther = !canConnect ? 0
			: other.getCollisionShape(reader, pos)
				.max(Axis.Y);
		callback.setReturnValue(Mth.equal(top, topOther));
		callback.cancel();
	}
}
