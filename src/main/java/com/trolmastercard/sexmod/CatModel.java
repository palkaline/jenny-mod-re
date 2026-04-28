/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import net.minecraft.util.ResourceLocation;

public class CatModel
extends GirlModel<GirlEntity> {
    @Override
    protected ResourceLocation[] net_minecraft_util_ResourceLocation_arr_a() {
        return new ResourceLocation[]{
                new ResourceLocation("sexmod", "geo/cat/cat.geo.json"),
                new ResourceLocation("sexmod", "geo/cat/cat.geo.json")};
    }

    @Override
    public ResourceLocation getSkinLocation() {
        return new ResourceLocation("sexmod", "textures/entity/cat/cat.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GirlEntity em_class2582) {
        return new ResourceLocation("sexmod", "animations/cat/cat.animation.json");
    }

    @Override
    public String[] c() {
        return new String[]{"armorHelmet"};
    }

    @Override
    public String[] f() {
        return new String[]{"armorShoulderR", "armorShoulderL", "armorChest", "armorBoobs"};
    }

    @Override
    public String[] java_lang_String_arr_a() {
        return new String[]{"boobsFlesh", "cloth"};
    }

    @Override
    public String[] h() {
        return new String[]{"armorBootyR", "armorBootyL", "armorPantsLowL", "armorPantsLowR", "armorPantsLowR", "armorPantsUpR", "armorPantsUpL", "armorHip"};
    }

    @Override
    public String[] e() {
        return new String[]{"fleshL", "fleshR", "vagina", "curvesL", "curvesR", "kneeL", "kneeR", "cloth"};
    }

    @Override
    public String[] java_lang_String_arr_b() {
        return new String[]{"armorShoesL", "armorShoesR"};
    }
}

