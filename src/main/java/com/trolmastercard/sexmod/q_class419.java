/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.FMLCommonHandler
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.PlayerEvent$PlayerLoggedInEvent
 *  net.minecraftforge.fml.common.gameevent.PlayerEvent$PlayerLoggedOutEvent
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 */
package com.trolmastercard.sexmod;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class q_class419 {
    final static UUID b = UUID.fromString("b91e6484-8911-4def-ab04-9fa3452fca5f");
    final static UUID a = UUID.fromString("adf20149-2adc-4a9d-9af5-8e9aeda019d6");

    @SubscribeEvent
    public void a(PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent) {
        UUID uUID;
        EntityPlayerMP entityPlayerMP = playerLoggedInEvent.player.world.getMinecraftServer().getPlayerList().getPlayerByUUID(playerLoggedInEvent.player.getPersistentID());
        entityPlayerMP.setInvisible(false);
        entityPlayerMP.setNoGravity(false);
        entityPlayerMP.noClip = false;
        if (!entityPlayerMP.capabilities.isCreativeMode && entityPlayerMP.capabilities.isFlying) {
            entityPlayerMP.capabilities.isFlying = false;
        }
        ge_class363.b.sendTo((IMessage)new gz_class393(true), entityPlayerMP);
        ge_class363.b.sendTo((IMessage)new gf_class364(GalathMangTracker.c(entityPlayerMP.getPersistentID())), entityPlayerMP);
        for (ItemStack object2 : entityPlayerMP.inventory.mainInventory) {
            if (object2.getItem() != LampItem.b || !object2.hasTagCompound()) continue;
            object2.getTagCompound().setUniqueId("user", UUID.randomUUID());
        }
        UUID uUID2 = KoboldManager.findTribeIdWith(entityPlayerMP.getPersistentID());
        if (uUID2 != null) {
            HashSet<BlockPos> hashSet = KoboldManager.d(uUID2);
            ge_class363.b.sendTo((IMessage)new h6_class397(hashSet, true), entityPlayerMP);
        }
        PlayerGirl.void_C();
        PlayerGirl ei_class2512 = PlayerGirl.d_(playerLoggedInEvent.player.getPersistentID());
        World world = FMLCommonHandler.instance().getMinecraftServerInstance().getEntityWorld();
        this.a(world, (EntityPlayer)entityPlayerMP, ei_class2512);
        if (ei_class2512 != null) {
            ei_class2512.void_a(false);
            ei_class2512.setCurrentAction(Action.NULL);
            s_class421.a_inner422.a(ei_class2512);
        }
        if ((uUID = playerLoggedInEvent.player.getPersistentID()).equals(b)) {
            this.a(world, (EntityPlayer)entityPlayerMP, uUID);
        }
        if (uUID.equals(a)) {
            this.b(world, entityPlayerMP, uUID);
        }
        GalathEntity.void_c(entityPlayerMP);
    }

    void a(World world, EntityPlayer entityPlayer, UUID uUID) {
        PlayerBia eg_class2482 = new PlayerBia(world, uUID);
        eg_class2482.setNoGravity(true);
        eg_class2482.noClip = true;
        eg_class2482.motionX = 0.0;
        eg_class2482.motionY = 0.0;
        eg_class2482.motionZ = 0.0;
        eg_class2482.setPosition(entityPlayer.posX, entityPlayer.posY + 69.0, entityPlayer.posZ);
        world.spawnEntity(eg_class2482);
        eg_class2482.void_B();
    }

    void b(World world, EntityPlayer entityPlayer, UUID uUID) {
        PlayerEllie ee_class2432 = new PlayerEllie(world, uUID);
        ee_class2432.setNoGravity(true);
        ee_class2432.noClip = true;
        ee_class2432.motionX = 0.0;
        ee_class2432.motionY = 0.0;
        ee_class2432.motionZ = 0.0;
        ee_class2432.setPosition(entityPlayer.posX, entityPlayer.posY + 69.0, entityPlayer.posZ);
        world.spawnEntity(ee_class2432);
        ee_class2432.void_B();
    }

    void a(World world, EntityPlayer entityPlayer, PlayerGirl ei_class2513) {
        Predicate<PlayerGirl> predicate = ei_class2512 -> true;
        List<PlayerGirl> list = world.getEntities(PlayerGirl.class, predicate::test);
        for (PlayerGirl ei_class2514 : list) {
            if (!ei_class2514.java_util_UUID_m().equals(entityPlayer.getPersistentID()) || ei_class2513 != null && ei_class2514.getEntityId() == ei_class2513.getEntityId()) continue;
            world.removeEntity(ei_class2514);
        }
    }

    @SubscribeEvent
    public void a(PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent) {
        EntityPlayer entityPlayer = playerLoggedOutEvent.player;
        try {
            for (GirlEntity em_class2582 : GirlEntity.ad()) {
                if (em_class2582 instanceof PlayerGirl) {
                    ((PlayerGirl)em_class2582).void_b(entityPlayer);
                }
                if (em_class2582.java_util_UUID_ae() == null) continue;
                if (em_class2582.java_util_UUID_ae().equals(entityPlayer.getPersistentID()) || em_class2582.java_util_UUID_ae().equals(entityPlayer.getUniqueID())) {
                    s_class421.a_inner422.a(em_class2582);
                    em_class2582.void_a(false);
                    em_class2582.setCurrentAction(Action.NULL);
                }
                if (!(em_class2582 instanceof PlayerGirl) || !((PlayerGirl)em_class2582).java_util_UUID_m().equals(entityPlayer.getPersistentID()) || em_class2582.java_util_UUID_ae() == null) continue;
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP)playerLoggedOutEvent.player.world.getPlayerEntityByUUID(em_class2582.java_util_UUID_ae());
                ge_class363.b.sendTo((IMessage)new gz_class393(true), entityPlayerMP);
                s_class421.a_inner422.a(entityPlayerMP);
                entityPlayer.setInvisible(false);
                em_class2582.void_e((UUID)null);
            }
        } catch (ConcurrentModificationException concurrentModificationException) {
            // empty catch block
        }
    }

    private static ConcurrentModificationException a(ConcurrentModificationException concurrentModificationException) {
        return concurrentModificationException;
    }
}

