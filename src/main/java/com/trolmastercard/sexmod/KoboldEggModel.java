/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KoboldEggModel
extends AnimatedGeoModel<c7_class116> {
    @Override
    public ResourceLocation getModelLocation(c7_class116 c7_class1162) {
        return new ResourceLocation("sexmod", "geo/kobold/koboldegg.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(c7_class116 c7_class1162) {
        return new ResourceLocation("sexmod", "textures/entity/kobold/koboldegg.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(c7_class116 c7_class1162) {
        return new ResourceLocation("sexmod", "animations/kobold/egg.animation.json");
    }
}

