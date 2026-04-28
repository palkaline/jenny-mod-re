/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import net.minecraft.entity.Entity;

public enum fy_class335 {
    JENNY(JennyEntity.class, 177013, PlayerJenny.class, 12388645),
    ELLIE(EllieEntity.class, 228922, PlayerEllie.class, 46348348),
    BIA(BiaEntity.class, 230053, PlayerBia.class, 65456415),
    SLIME(SlimeEntity.class, 168597, PlayerSlime.class, 54816432),
    BEE(BeeEntity.class, 4663354, PlayerBee.class, 48648638),
    ALLIE(AllieEntity.class, 5614613, PlayerAllie.class, 64867483),
    LUNA(LunaEntity.class, 6816463, PlayerLuna.class, 81234824),
    KOBOLD(KoboldEntity.class, 5648456, PlayerKobold.class, 62484851, true),
    GOBLIN(GoblinEntity.class, 4567275, PlayerGoblin.class, 6584344, true),
    GALATH(GalathEntity.class, 314351, PlayerGalath.class, 652535516),
    MANGLELIE(ManglelieEntity.class, 618151);

    final public int npcID;
    final public int playerID;
    final public Class<? extends GirlEntity> npcClass;
    final public Class<? extends PlayerGirl> playerClass;
    final public boolean isNpcOnly;
    final public int editorID;
    final public boolean hasSpecifics;

    private fy_class335(Class<? extends GirlEntity> npcClass, int n2, Class<? extends PlayerGirl> playerClass, int n3, boolean bl) {
        this.npcID = n2;
        this.playerID = n3;
        this.npcClass = npcClass;
        this.playerClass = playerClass;
        this.isNpcOnly = false;
        this.hasSpecifics = bl;
        this.editorID = r_class420.b++;
    }

    private fy_class335(Class<? extends GirlEntity> clazz, int n2, Class<? extends PlayerGirl> clazz2, int n3) {
        this.npcID = n2;
        this.playerID = n3;
        this.npcClass = clazz;
        this.playerClass = clazz2;
        this.isNpcOnly = false;
        this.hasSpecifics = false;
        this.editorID = r_class420.b++;
    }

    private fy_class335(Class<? extends GirlEntity> clazz, int n2) {
        this.npcID = n2;
        this.npcClass = clazz;
        this.isNpcOnly = true;
        this.hasSpecifics = false;
        this.editorID = r_class420.b++;
        this.playerClass = null;
        this.playerID = 0;
    }

    public static fy_class335 a(String string) {
        for (fy_class335 fy_class3352 : fy_class335.values()) {
            if (!fy_class3352.toString().equalsIgnoreCase(string)) continue;
            return fy_class3352;
        }
        return JENNY;
    }

    public static fy_class335 a(Entity entity) {
        if (!(entity instanceof GirlEntity)) {
            return null;
        }
        GirlEntity em_class2582 = (GirlEntity)entity;
        Class<?> clazz = em_class2582.getClass();
        for (fy_class335 fy_class3352 : fy_class335.values()) {
            if (clazz.equals(fy_class3352.npcClass)) {
                return fy_class3352;
            }
            if (!clazz.equals(fy_class3352.playerClass)) continue;
            return fy_class3352;
        }
        return null;
    }

    private static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }
}

