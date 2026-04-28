/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonSyntaxException
 *  net.minecraftforge.fml.client.registry.ClientRegistry
 */
package com.trolmastercard.sexmod;

import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ae_class26 {
    static public ShaderGroup b;
    final static ResourceLocation a;
    static Framebuffer c;

    public static void a() {
        Minecraft minecraft = Minecraft.getMinecraft();
        if (!OpenGlHelper.shadersSupported) {
            Main.LOGGER.warn("Shaders not supported");
            return;
        }
        if (ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
            ShaderLinkHelper.setNewStaticShaderLinkHelper();
        }
        try {
            b = new ShaderGroup(minecraft.getTextureManager(), minecraft.getResourceManager(), minecraft.getFramebuffer(), a);
            b.createBindFramebuffers(minecraft.displayWidth, minecraft.displayHeight);
            c = b.getFramebufferRaw("final");
            ClientRegistry.registerEntityShader(GirlEntity.class, (ResourceLocation)a);
            System.out.println("succ registered the outline shader :)");
        } catch (IOException iOException) {
            Main.LOGGER.warn("Failed to load shader: {}", (Object)a, (Object)iOException);
        } catch (JsonSyntaxException jsonSyntaxException) {
            Main.LOGGER.warn("Failed to load shader: {}", (Object)a, (Object)jsonSyntaxException);
        }
    }

    static {
        a = new ResourceLocation("sexmod", "shaders/post/outline.json");
    }

    private static IOException a(IOException iOException) {
        return iOException;
    }
}

