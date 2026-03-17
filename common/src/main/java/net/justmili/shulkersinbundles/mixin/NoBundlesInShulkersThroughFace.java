package net.justmili.shulkersinbundles.mixin;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxBlockEntity.class)
public class NoBundlesInShulkersThroughFace {
    @Inject(method = "canPlaceItemThroughFace", at = @At("HEAD"), cancellable = true)
    private void preventBundlesInShulkers(int slot, ItemStack stack, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getOrDefault(DataComponents.BUNDLE_CONTENTS, BundleContents.EMPTY) != BundleContents.EMPTY) {
            cir.setReturnValue(false);
        }
    }
}
