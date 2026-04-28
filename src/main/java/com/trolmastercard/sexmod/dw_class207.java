/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package com.trolmastercard.sexmod;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class dw_class207
extends BlockFire {
    final static public Block a = new dw_class207();

    @Override
    public void updateTick(World world, BlockPos blockPos, IBlockState iBlockState, Random random) {
    }

    public static void a() {
        a.setRegistryName("sexmod", "fire");
        a.setTranslationKey("fire");
        MinecraftForge.EVENT_BUS.register(dw_class207.class);
    }

    @SubscribeEvent
    public static void a(RegistryEvent.Register<Block> register) {
        register.getRegistry().register(a);
    }
}

