package net.justmili.shulkersinbundles.mixin;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.component.BundleContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleContents.Mutable.class)
public class NoBundlesInBundles {
    @Inject(method = "tryTransfer", at = @At("HEAD"), cancellable = true)
    private void preventBundlesInBundles(Slot slot, Player player, CallbackInfoReturnable<Integer> cir) {
        if (slot.getItem().getOrDefault(DataComponents.BUNDLE_CONTENTS, BundleContents.EMPTY) != BundleContents.EMPTY) {
            cir.setReturnValue(0);
        }
    }
}
