/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderHandEvent
 *  net.minecraftforge.client.event.RenderPlayerEvent$Pre
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$Phase
 *  net.minecraftforge.fml.common.gameevent.TickEvent$RenderTickEvent
 */
package com.trolmastercard.sexmod;

import java.util.ConcurrentModificationException;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class l_class413 {
    Vec3d b = null;
    Vec3d a = null;

    @SubscribeEvent
    public void a(RenderPlayerEvent.Pre pre) {
        try {
            for (GirlEntity em_class2582 : GirlEntity.ad()) {
                if (em_class2582.isDead || em_class2582.java_util_UUID_ae() == null || em_class2582.currentAction() == Action.NULL) continue;
                EntityPlayer entityPlayer = pre.getEntityPlayer();
                if (!em_class2582.currentAction().hasPlayer || !em_class2582.java_util_UUID_ae().equals(entityPlayer.getPersistentID()) && !em_class2582.java_util_UUID_ae().equals(entityPlayer.getUniqueID())) continue;
                pre.setCanceled(true);
                return;
            }
        } catch (ConcurrentModificationException concurrentModificationException) {
            // empty catch block
        }
    }

    @SubscribeEvent
    public void a(RenderHandEvent renderHandEvent) {
        Minecraft minecraft = Minecraft.getMinecraft();
        EntityPlayerSP entityPlayerSP = minecraft.player;
        PlayerGirl ei_class2512 = PlayerGirl.g(entityPlayerSP);
        if (ei_class2512 != null && ei_class2512.boolean_Q()) {
            renderHandEvent.setCanceled(true);
            return;
        }
        try {
            for (GirlEntity em_class2582 : GirlEntity.ad()) {
                UUID uUID = em_class2582.java_util_UUID_ae();
                Action fp_class3242 = em_class2582.currentAction();
                if (em_class2582.isDead || uUID == null || fp_class3242 == null || !fp_class3242.hasPlayer || !uUID.equals(entityPlayerSP.getUniqueID()) && !uUID.equals(entityPlayerSP.getPersistentID())) continue;
                renderHandEvent.setCanceled(true);
                return;
            }
        } catch (ConcurrentModificationException concurrentModificationException) {
            // empty catch block
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public void a(TickEvent.RenderTickEvent renderTickEvent) {
        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft.player == null) {
            return;
        }
        if (renderTickEvent.phase == TickEvent.Phase.END) {
            if (this.b != null) {
                minecraft.player.setPosition(this.b.x, this.b.y, this.b.z);
                minecraft.player.lastTickPosX = this.a.x;
                minecraft.player.lastTickPosY = this.a.y;
                minecraft.player.lastTickPosZ = this.a.z;
                this.b = null;
                this.a = null;
            }
            return;
        }
        if (minecraft.gameSettings.thirdPersonView != 0) {
            return;
        }
        GirlEntity em_class2582 = GirlEntity.a(minecraft.player.getPersistentID(), false);
        if (em_class2582 == null) {
            return;
        }
        if (!em_class2582.currentAction().useBoyCam) {
            return;
        }
        if (em_class2582.boolean_m()) {
            return;
        }
        this.b = minecraft.player.getPositionVector();
        this.a = new Vec3d(minecraft.player.lastTickPosX, minecraft.player.lastTickPosY, minecraft.player.lastTickPosZ);
        Vec3d vec3d = em_class2582.boolean_Q() ? em_class2582.b("boyCam").add(em_class2582.net_minecraft_util_math_Vec3d_o()) : em_class2582.b("boyCam").add(b6_class67.a(new Vec3d(em_class2582.lastTickPosX, em_class2582.lastTickPosY, em_class2582.lastTickPosZ), em_class2582.getPositionVector(), (double)renderTickEvent.renderTickTime));
        minecraft.player.posX = vec3d.x;
        minecraft.player.posY = vec3d.y - (double)minecraft.player.getEyeHeight();
        minecraft.player.posZ = vec3d.z;
        minecraft.player.lastTickPosX = vec3d.x;
        minecraft.player.lastTickPosY = vec3d.y - (double)minecraft.player.getEyeHeight();
        minecraft.player.lastTickPosZ = vec3d.z;
    }

    private static ConcurrentModificationException a(ConcurrentModificationException concurrentModificationException) {
        return concurrentModificationException;
    }
}

