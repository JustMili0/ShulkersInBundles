package net.justmili.fabric;

import net.justmili.ShulkersInBundles;
import net.fabricmc.api.ModInitializer;

public final class ShulkersInBundlesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ShulkersInBundles.init();
    }
}
