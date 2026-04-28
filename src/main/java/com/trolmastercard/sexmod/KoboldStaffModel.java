/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KoboldStaffModel
extends AnimatedGeoModel<hy_class407> {
    @Override
    public ResourceLocation getModelLocation(hy_class407 hy_class4072) {
        return new ResourceLocation("sexmod", "geo/kobold/staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(hy_class407 hy_class4072) {
        return new ResourceLocation("sexmod", "textures/entity/kobold/staff.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(hy_class407 hy_class4072) {
        return new ResourceLocation("sexmod", "animations/kobold/staff.animation.json");
    }
}

