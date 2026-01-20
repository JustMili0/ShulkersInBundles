package net.justmili.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BundleContents.Mutable.class)
public class ShulkersInBundlesInsert {
    @WrapOperation(method = "tryInsert", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;canFitInsideContainerItems()Z"))
    private boolean shulkersinbundles(Item item, Operation<Boolean> original) {
        if (item instanceof BlockItem blockItem && blockItem.getBlock() instanceof ShulkerBoxBlock) {
            return true;
        }
        return original.call(item);
    }
}
