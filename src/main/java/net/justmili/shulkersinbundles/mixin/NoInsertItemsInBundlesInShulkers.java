package net.justmili.shulkersinbundles.mixin;

import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleItem.class)
public class NoInsertItemsInBundlesInShulkers {
    @Inject(method = "overrideOtherStackedOnMe", at = @At("HEAD"), cancellable = true)
    private void preventItemsInBundlesInShulkers(ItemStack self, ItemStack other, Slot slot, ClickAction clickAction, Player player, SlotAccess slotAccess, CallbackInfoReturnable<Boolean> cir) {
        if (clickAction == ClickAction.PRIMARY && !other.isEmpty()) {
            if (slot instanceof ShulkerBoxSlot) {
                cir.setReturnValue(true);
            }
        }
    }
}