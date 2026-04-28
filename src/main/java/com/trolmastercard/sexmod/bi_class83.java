/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.registry.EntityRegistry
 */
package com.trolmastercard.sexmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class bi_class83 {
    public static void a() {
        bi_class83.a("jenny", JennyEntity.class, fy_class335.JENNY.npcID, 3286592, 12655237);
        bi_class83.a("ellie", EllieEntity.class, fy_class335.ELLIE.npcID, 0x161616, 0x980000);
        bi_class83.a("slime", SlimeEntity.class, fy_class335.SLIME.npcID, 13167780, 8244330);
        bi_class83.a("bia", BiaEntity.class, fy_class335.BIA.npcID, 7488816, 7254603);
        bi_class83.a("bee", BeeEntity.class, fy_class335.BEE.npcID, 16701032, 4400155);
        bi_class83.a("luna", LunaEntity.class, fy_class335.LUNA.npcID, 7881787, 7940422);
        bi_class83.a("allie", AllieEntity.class, fy_class335.ALLIE.npcID);
        bi_class83.a("kobold", KoboldEntity.class, fy_class335.KOBOLD.npcID);
        bi_class83.a("kobold_egg", i_class410.class, 4674237);
        bi_class83.a("goblin", GoblinEntity.class, fy_class335.GOBLIN.npcID, 39424, 19456);
        bi_class83.a("galath", GalathEntity.class, fy_class335.GALATH.npcID, 0xFF0000, 0xFF0000);
        bi_class83.a("manglelie", ManglelieEntity.class, fy_class335.MANGLELIE.npcID, 0xF9F9F9, 8485574);
        bi_class83.a("custom_model", cy_class153.class, 6281823);
        bi_class83.b("player_jenny", PlayerJenny.class, fy_class335.JENNY.playerID);
        bi_class83.b("player_ellie", PlayerEllie.class, fy_class335.ELLIE.playerID);
        bi_class83.b("player_slime", PlayerSlime.class, fy_class335.SLIME.playerID);
        bi_class83.b("player_bia", PlayerBia.class, fy_class335.BIA.playerID);
        bi_class83.b("player_bee", PlayerBee.class, fy_class335.BEE.playerID);
        bi_class83.b("player_allie", PlayerAllie.class, fy_class335.ALLIE.playerID);
        bi_class83.b("player_kobold", PlayerKobold.class, fy_class335.KOBOLD.playerID);
        bi_class83.b("player_goblin", PlayerGoblin.class, fy_class335.GOBLIN.playerID);
        bi_class83.b("player_luna", PlayerLuna.class, fy_class335.LUNA.playerID);
        bi_class83.b("player_galath", PlayerGalath.class, fy_class335.GALATH.playerID);
        bi_class83.a("friendly_slime", ay_class51.class, 5548484);
        bi_class83.a("luna_hook", gi_class370.class, 4768742);
        bi_class83.a("energy_ball", c4_class113.class, 2565153);
        bi_class83.a("pyrocinical", EntityPyrocynical.class, 515153);
        EntityRegistry.addSpawn(SlimeEntity.class, 10, 1, 1, (EnumCreatureType)EnumCreatureType.CREATURE, (Biome[])new Biome[]{Biomes.SWAMPLAND, Biomes.MUTATED_SWAMPLAND});
        EntityRegistry.addSpawn(BeeEntity.class, 5, 1, 1, (EnumCreatureType)EnumCreatureType.CREATURE, (Biome[])new Biome[]{Biomes.FOREST, Biomes.FOREST_HILLS});
        EntityRegistry.addSpawn(EntityPyrocynical.class, 3, 1, 1, (EnumCreatureType)EnumCreatureType.AMBIENT, (Biome[])new Biome[]{Biomes.HELL});
        EntityRegistry.addSpawn(ManglelieEntity.class, 5, 1, 1, (EnumCreatureType)EnumCreatureType.AMBIENT, (Biome[])new Biome[]{Biomes.HELL});
    }

    private static void b(String string, Class<? extends Entity> clazz, int n) {
        EntityRegistry.registerModEntity((ResourceLocation)new ResourceLocation("sexmod:" + string), clazz, (String)string, (int)n, (Object) Main.instance, 100, 1, (boolean)false);
    }

    private static void a(String string, Class<? extends Entity> clazz, int n, int n2, int n3) {
        EntityRegistry.registerModEntity((ResourceLocation)new ResourceLocation("sexmod:" + string), clazz, (String)string, (int)n, (Object) Main.instance, 50, 1, (boolean)true, (int)n2, (int)n3);
    }

    private static void a(String string, Class<? extends Entity> clazz, int n) {
        EntityRegistry.registerModEntity((ResourceLocation)new ResourceLocation("sexmod:" + string), clazz, (String)string, (int)n, (Object) Main.instance, 50, 1, (boolean)true);
    }
}

