/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KoboldEggModel2
extends AnimatedGeoModel<i_class410> {
    @Override
    public ResourceLocation getModelLocation(i_class410 i_class4102) {
        return new ResourceLocation("sexmod", "geo/kobold/koboldegg.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(i_class410 i_class4102) {
        return new ResourceLocation("sexmod", "textures/entity/kobold/koboldegg.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(i_class410 i_class4102) {
        return new ResourceLocation("sexmod", "animations/kobold/egg.animation.json");
    }
}

