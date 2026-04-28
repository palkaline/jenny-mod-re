/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GalathCoinModel
extends AnimatedGeoModel<cc_class124> {
    @Override
    public ResourceLocation getModelLocation(cc_class124 cc_class1242) {
        return new ResourceLocation("sexmod", "geo/galath/galath_coin.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(cc_class124 cc_class1242) {
        return new ResourceLocation("sexmod", "textures/items/galath_coin/galath_coin.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(cc_class124 cc_class1242) {
        return new ResourceLocation("sexmod", "animations/galath/galath_coin.animation.json");
    }
}

