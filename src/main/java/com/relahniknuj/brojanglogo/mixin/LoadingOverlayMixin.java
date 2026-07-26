package com.relahniknuj.brojanglogo.mixin;

import com.relahniknuj.brojanglogo.CustomLogoTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.server.packs.resources.ReloadInstance;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.function.Consumer;


@Mixin(LoadingOverlay.class)
public class LoadingOverlayMixin {

    @Inject(method = "<init>",at = @At("TAIL"))
    private void replaceLogo(Minecraft mc, ReloadInstance reload, Consumer<Optional<Throwable>> onFinish, boolean fadeIn, CallbackInfo ci) {
        mc.getTextureManager().registerAndLoad(LoadingOverlay.MOJANG_STUDIOS_LOGO_LOCATION, new CustomLogoTexture());
    }
}
