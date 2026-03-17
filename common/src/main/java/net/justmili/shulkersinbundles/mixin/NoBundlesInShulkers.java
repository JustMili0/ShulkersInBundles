package net.justmili.shulkersinbundles.mixin;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxSlot.class)
public class NoBundlesInShulkers {
    @Inject(method = "mayPlace", at = @At("HEAD"), cancellable = true)
    private void preventBundlesInShulkers(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getOrDefault(DataComponents.BUNDLE_CONTENTS, BundleContents.EMPTY) != BundleContents.EMPTY) {
            cir.setReturnValue(false);
        }
    }
}
