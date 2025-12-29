# Shulkers In Bundles
"Oh nice, now I can keep most of _(if not all)_ my shulkers in one slot in my inventory"

<hr>

## Why?
It doesn't seem like Bundles have been used much ever since they were added. And when they were fully implemented with the release of Minecraft 1.21.2.. still not much use other than storing little bits of items early-game.

I come to change it, and make it so Bundles can now store up to 16 Shulkers in them; empty or not, it'll fit! Now bundles are useful early _and_ late game. _I think_

<hr>

### How long will this be kept updated?
Until I'm 2 meters under. I love Minecraft _and_ programming, so I'll keep updating the mod for however long I live.

### Ensured no exploits or issues?
I've made sure that while you can put Shulkers in Bundles, you cannot put Bundles in Bundles or Bundles in Shulkers, preventing near-infinite storage in a single slot.
That is also to prevent making bundles with massive amounts of data that could overload a server or even chunk-ban.

### Can I change the max shulker amount?
Yes actually! This mod exposes a supported API for other mods to modify how many shulkers can be put in the bundle.

An example:
```java
package xyz.yourmod.mixin; //doesn't matter what your package is named

import net.justmili.data.ShulkerFractions;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerFractions.class)
public class ShulkerWeightMixin {
    @Inject(method = "getShulkerWeight", at = @At("HEAD"), cancellable = true)
    private static void modifyShulkerWeight(CallbackInfoReturnable<Fraction> cir) {
        cir.setReturnValue(Fraction.getFraction(1, 8));
        // ^^^ The 2nd number is how many shulkers will fit.
        // (To be exact, this for example is 1/8th of the bundle per shulker, so 8 shulkers will fit.)
        // Minimum is 1, maximum is 64.
    }
}
```
Keep in mind, if multiple mods modify the shulker weight, the last-applied (or with highest priority) mixin will be used.

And no, I'm not making a config, too much work for a small mod like this especially since this is on 4 loaders and over 10 versions.

<hr>

### Server-side & client-side
Shulkers In Bundles can be installed purely server-side and does not require the client to have it, **BUT** it is recommended to have it also on the client because without it the bundle tooltip will look very cursed.

<hr>

Another small QoL project just like Always Shield, hope y'all like it too