package net.justmili.shulkersinbundles.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleItem.class)
public abstract class NoInsertItemsInBundlesInShulkers {
    @Shadow
    private static void playInsertFailSound(Entity entity) {
    }

    @Inject(method = "overrideOtherStackedOnMe", at = @At("HEAD"), cancellable = true)
    private void preventItemsInBundlesInShulkers(ItemStack self, ItemStack other, Slot slot, ClickAction clickAction, Player player, SlotAccess carriedItem, CallbackInfoReturnable<Boolean> cir) {
        if (clickAction == ClickAction.PRIMARY && !other.isEmpty()) {
            if (slot instanceof ShulkerBoxSlot) {
                playInsertFailSound(player);
                cir.setReturnValue(true);
            }
        }
    }
}