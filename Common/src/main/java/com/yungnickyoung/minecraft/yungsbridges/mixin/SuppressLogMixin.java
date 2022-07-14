package com.yungnickyoung.minecraft.yungsbridges.mixin;

import net.minecraft.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Util.class)
public class SuppressLogMixin {
    @Inject(method = "logAndPauseIfInIde(Ljava/lang/String;)V", at = @At("HEAD"), cancellable = true, require = 0)
    private static void yungsbridges_supressLog(String string, CallbackInfo ci) {
        if (string.startsWith("Detected setBlock in a far chunk") && string.contains("yungsbridges:bridge_list")) {
            ci.cancel();
        }
    }
}
