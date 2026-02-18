package net.justmili.shulkersinbundles.data;

import org.apache.commons.lang3.math.Fraction;

public class ShulkerFractions {
    private static Fraction SHULKER_WEIGHT = Fraction.getFraction(1, 16);

    public static Fraction getShulkerWeight() {
        return SHULKER_WEIGHT;
    }
    public static void setShulkerWeight(Fraction fraction) { //For addons/mixins if anyone wants to change it
        SHULKER_WEIGHT = fraction;
    }
}
