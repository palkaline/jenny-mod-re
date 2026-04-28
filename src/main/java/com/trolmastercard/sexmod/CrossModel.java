/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.trolmastercard.sexmod;

import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrossModel
extends AnimatedGeoModel<cy_class153> {
    @Override
    public ResourceLocation getModelLocation(cy_class153 cy_class1532) {
        if (cy_class1532.f) {
            return new ResourceLocation("sexmod", "geo/cross.geo.json");
        }
        return br_class94.k(cy_class1532.a());
    }

    @Override
    public ResourceLocation getTextureLocation(cy_class153 cy_class1532) {
        if (cy_class1532.f) {
            return new ResourceLocation("sexmod", "textures/cross.png");
        }
        return br_class94.c(cy_class1532.a());
    }

    @Override
    public ResourceLocation getAnimationFileLocation(cy_class153 cy_class1532) {
        return new ResourceLocation("sexmod", "animations/slime/slime.animation.json");
    }

    @Override
    public void setLivingAnimations(cy_class153 cy_class1532, Integer n, @Nullable AnimationEvent animationEvent) {
    }
}

