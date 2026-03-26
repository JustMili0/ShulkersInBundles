package net.justmili.shulkersinbundles.mixin;

import com.mojang.serialization.DataResult;
import net.justmili.shulkersinbundles.data.ShulkerFractions;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleContents.class)
public class ShulkersInBundles {
    @Inject(method = "canItemBeInBundle", at = @At("HEAD"), cancellable = true)
    private static void allowShulkersInBundles(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.isEmpty()) return;
        if (stack.getItem() instanceof BlockItem blockItem
            && blockItem.getBlock() instanceof ShulkerBoxBlock) {

            cir.setReturnValue(true);
        }
    }
    @Inject(method = "getWeight", at = @At("HEAD"), cancellable = true)
    private static void shulkerWeight(ItemInstance instance, CallbackInfoReturnable<DataResult<Fraction>> cir) {
        Item item = instance.typeHolder().value();

        if (item instanceof BlockItem blockItem
            && blockItem.getBlock() instanceof ShulkerBoxBlock) {

            cir.setReturnValue(DataResult.success(ShulkerFractions.getShulkerWeight()));
        }
    }
}
