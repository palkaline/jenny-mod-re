/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import net.minecraft.util.ResourceLocation;

public class BiaModel
extends GirlModel<GirlEntity> {
    public BiaModel() {
        this.c = this.net_minecraft_util_ResourceLocation_arr_a();
    }

    @Override
    protected ResourceLocation[] net_minecraft_util_ResourceLocation_arr_a() {
        return new ResourceLocation[]{
                new ResourceLocation("sexmod", "geo/bia/bianude.geo.json"),
                new ResourceLocation("sexmod", "geo/bia/biadressed.geo.json")};
    }

    @Override
    public ResourceLocation getSkinLocation() {
        return new ResourceLocation("sexmod", "textures/entity/bia/bia.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GirlEntity em_class2582) {
        return new ResourceLocation("sexmod", "animations/bia/bia.animation.json");
    }

    @Override
    public String[] c() {
        return new String[]{"armorHelmet"};
    }

    @Override
    public String[] g() {
        return new String[]{"leaf7", "leaf8"};
    }

    @Override
    public String[] f() {
        return new String[]{"armorChest", "armorBoobs", "armorShoulderR", "armorShoulderL"};
    }

    @Override
    public String[] java_lang_String_arr_a() {
        return new String[]{"bra", "upperBodyR", "upperBodyL"};
    }

    @Override
    public String[] h() {
        return new String[]{"armorBootyR", "armorBootyL", "armorPantsLowL", "armorPantsLowR", "armorPantsLowR", "armorPantsUpR", "armorPantsUpL", "armorHip"};
    }

    @Override
    public String[] e() {
        return new String[]{"slip", "fleshL", "fleshR", "vagina", "curvesL", "curvesR", "kneeL", "kneeR"};
    }

    @Override
    public String[] java_lang_String_arr_b() {
        return new String[]{"armorShoesL", "armorShoesR"};
    }
}

