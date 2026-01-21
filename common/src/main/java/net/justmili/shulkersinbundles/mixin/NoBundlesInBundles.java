package net.justmili.shulkersinbundles.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.component.BundleContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleContents.class)
public class NoBundlesInBundles {
    @Inject(method = "canItemBeInBundle", at = @At("HEAD"), cancellable = true)
    private static void preventBundlesInBundles(
        ItemStack stack,
        CallbackInfoReturnable<Boolean> cir
    ) {
        if (stack.getItem() instanceof BundleItem) {
            cir.setReturnValue(false);
        }
    }
}
