package makamys.boatfix.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Entity.class)
public class MixinEntity {
    @Redirect(method = "updateSubmergedInWaterState()V", 
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Box;contains(Lnet/minecraft/util/math/Vec3d;)Z"))
    public boolean redirectContains(Box box, Vec3d vec) {
        return true;
    }
}
