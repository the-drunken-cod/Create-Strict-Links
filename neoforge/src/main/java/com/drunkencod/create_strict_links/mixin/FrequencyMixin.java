package com.drunkencod.create_strict_links.mixin;

import com.drunkencod.create_strict_links.config.NeoForgeConfigHelper;
import com.simibubi.create.content.redstone.link.RedstoneLinkNetworkHandler.Frequency;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Frequency.class)
public abstract class FrequencyMixin {

    @Shadow
    private ItemStack stack;

    // #region equals override — additionally verify Data Components (NBT)
    @Inject(method = "equals", at = @At("HEAD"), cancellable = true)
    private void strictEquals(Object obj, CallbackInfoReturnable<Boolean> cir) {
        if (!NeoForgeConfigHelper.SERVER.isModEnabled.get())
            return;

        if (this == obj) {
            cir.setReturnValue(true);
            return;
        }

        if (!(obj instanceof Frequency other)) {
            cir.setReturnValue(false);
            return;
        }

        cir.setReturnValue(ItemStack.isSameItemSameComponents(this.stack, other.getStack()));
    }
}
