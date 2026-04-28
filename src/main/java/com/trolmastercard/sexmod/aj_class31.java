/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.MinecraftForge
 */
package com.trolmastercard.sexmod;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class aj_class31
extends Item
implements IAnimatable {
    final static public aj_class31 b = new aj_class31();
    final private AnimationFactory a = new AnimationFactory(this);

    public static void a() {
        b.setRegistryName("sexmod", "winchester");
        b.setTranslationKey("winchester");
        MinecraftForge.EVENT_BUS.register(aj_class31.class);
    }

    @Override
    public void registerControllers(AnimationData animationData) {
    }

    @Override
    public AnimationFactory getFactory() {
        return this.a;
    }
}

