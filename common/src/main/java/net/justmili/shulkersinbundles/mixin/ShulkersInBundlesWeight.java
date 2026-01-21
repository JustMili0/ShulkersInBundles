package net.justmili.shulkersinbundles.mixin;

import net.justmili.shulkersinbundles.data.ShulkerFractions;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleContents.class)
public class ShulkersInBundlesWeight {
    @Inject(method = "getWeight", at = @At("HEAD"), cancellable = true)
    private static void shulkerWeight(ItemStack stack, CallbackInfoReturnable<Fraction> cir) {
        if (stack.getItem() instanceof BlockItem blockItem
            && blockItem.getBlock() instanceof ShulkerBoxBlock) {

            cir.setReturnValue(ShulkerFractions.getShulkerWeight());
        }
    }
}
