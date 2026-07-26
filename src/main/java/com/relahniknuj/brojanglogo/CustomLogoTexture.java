package com.relahniknuj.brojanglogo;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.client.renderer.texture.MipmapStrategy;
import net.minecraft.client.renderer.texture.ReloadableTexture;
import net.minecraft.client.renderer.texture.TextureContents;
import net.minecraft.client.resources.metadata.texture.TextureMetadataSection;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.IOException;
import java.io.InputStream;

public class CustomLogoTexture extends ReloadableTexture {
    public CustomLogoTexture() {
        super(LoadingOverlay.MOJANG_STUDIOS_LOGO_LOCATION);
    }

    @Override
    public TextureContents loadContents(ResourceManager resourceManager) throws IOException {

        try (InputStream in = CustomLogoTexture.class.getResourceAsStream("/assets/orecracker/textures/gui/title/mojangstudios_final.png")) {
            return new TextureContents(NativeImage.read(in), new TextureMetadataSection(true, true, MipmapStrategy.MEAN, 0.0f));
        }
    }
}
