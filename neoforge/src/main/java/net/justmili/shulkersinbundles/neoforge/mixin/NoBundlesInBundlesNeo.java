package net.justmili.shulkersinbundles.neoforge.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BundleContents.Mutable.class)
public class NoBundlesInBundlesNeo {
    //I hate whoever did this dumbass patch on the NeoForged team
    @WrapOperation(method = "tryInsert", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;canFitInsideContainerItems()Z"), require = 0)
    private boolean preventBundlesInBundles(ItemStack stack, Operation<Boolean> original) {
        if (stack.getItem() instanceof BundleItem) {
            return false;
        }
        return original.call(stack);
    }
}
