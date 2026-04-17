package net.justmili.shulkersinbundles.neoforge;

import net.justmili.shulkersinbundles.ShulkersInBundles;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(ShulkersInBundles.MOD_ID)
public class ShulkersInBundlesNeo {
    public ShulkersInBundlesNeo(IEventBus bus, ModContainer container) {
        ShulkersInBundles.init();
    }
}
