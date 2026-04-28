/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package com.trolmastercard.sexmod;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class co_class139
extends Potion {
    final static public Potion b = new co_class139("horny potion", false, 16736968, 0, 0);
    final static public PotionType a = (PotionType)new PotionType("horny_potion", new PotionEffect(b, 3600), new PotionEffect(MobEffects.NAUSEA, 200, 1)).setRegistryName("horny_potion");

    public co_class139() {
        super(false, 0);
    }

    public co_class139(String string, boolean bl, int n, int n2, int n3) {
        super(bl, n);
        this.setPotionName(string);
        this.setIconIndex(n2, n3);
        this.setRegistryName(new ResourceLocation("sexmod:" + string));
    }

    public static void a() {
        ForgeRegistries.POTIONS.register(b);
        ForgeRegistries.POTION_TYPES.register(a);
        PotionHelper.addMix(PotionTypes.MUNDANE, Item.getItemFromBlock(Blocks.RED_FLOWER), a);
    }

    @SubscribeEvent
    public void a(TickEvent.PlayerTickEvent playerTickEvent) {
        EntityPlayer entityPlayer = playerTickEvent.player;
        PotionEffect potionEffect = entityPlayer.getActivePotionEffect(b);
        if (entityPlayer.world.isRemote) {
            return;
        }
        if (potionEffect == null) {
            return;
        }
        if (potionEffect.getDuration() > 3500) {
            return;
        }
        entityPlayer.removePotionEffect(b);
        ge_class363.b.sendTo((IMessage)new bd_class76(entityPlayer), (EntityPlayerMP)entityPlayer);
    }

    @SubscribeEvent
    public void a(LivingEvent.LivingUpdateEvent livingUpdateEvent) {
        EntityAgeable entityAgeable;
        if (livingUpdateEvent.getEntity() instanceof EntityVillager && (entityAgeable = (EntityVillager)livingUpdateEvent.getEntity()).isPotionActive(b)) {
            ((EntityVillager)entityAgeable).tasks.addTask(2, new EntityAIVillagerJustBang((EntityVillager)entityAgeable));
            entityAgeable.removePotionEffect(b);
        }
        if (!(livingUpdateEvent.getEntity() instanceof EntityAnimal)) {
            return;
        }
        entityAgeable = (EntityAnimal)livingUpdateEvent.getEntity();
        if (entityAgeable.isPotionActive(b)) {
            if (entityAgeable.getGrowingAge() >= 0) {
                entityAgeable.setGrowingAge(0);
                ((EntityAnimal)entityAgeable).resetInLove();
                ((EntityAnimal)entityAgeable).setInLove(((EntityAnimal)entityAgeable).world.getClosestPlayerToEntity(entityAgeable, 30.0));
            }
            entityAgeable.removePotionEffect(b);
        }
    }

    private static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }
}

