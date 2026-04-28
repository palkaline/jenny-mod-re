/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NYIWinchesterModel
extends AnimatedGeoModel<aj_class31> {
    @Override
    public ResourceLocation getModelLocation(aj_class31 aj_class312) {
        return new ResourceLocation("sexmod", "geo/west/winchester.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(aj_class31 aj_class312) {
        return new ResourceLocation("sexmod", "textures/items/winchester/winchester.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(aj_class31 aj_class312) {
        return new ResourceLocation("sexmod", "animations/west/winchester.animation.json");
    }
}

