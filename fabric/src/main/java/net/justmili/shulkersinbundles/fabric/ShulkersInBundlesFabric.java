package net.justmili.shulkersinbundles.fabric;

import net.justmili.shulkersinbundles.ShulkersInBundles;
import net.fabricmc.api.ModInitializer;

public final class ShulkersInBundlesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ShulkersInBundles.init();
    }
}
