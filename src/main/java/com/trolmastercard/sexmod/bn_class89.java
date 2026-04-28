/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.MinecraftForge
 */
package com.trolmastercard.sexmod;

import java.io.File;
import java.io.IOException;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class bn_class89 {
    public static void a(boolean bl) throws IOException {
        MinecraftForge.EVENT_BUS.register((Object)new ah_class29());
        MinecraftForge.EVENT_BUS.register((Object)new eo_class262());
        MinecraftForge.EVENT_BUS.register((Object)new q_class419());
        MinecraftForge.EVENT_BUS.register((Object)new co_class139());
        MinecraftForge.EVENT_BUS.register((Object)new gu_class386());
        MinecraftForge.EVENT_BUS.register((Object)new ho_class404.a_inner405());
        MinecraftForge.EVENT_BUS.register((Object)new g_class338.a_inner339());
        MinecraftForge.EVENT_BUS.register((Object) LampItem.b);
        MinecraftForge.EVENT_BUS.register((Object)hy_class407.b);
        MinecraftForge.EVENT_BUS.register((Object)hj_class402.a);
        MinecraftForge.EVENT_BUS.register((Object)new gp_class379());
        MinecraftForge.EVENT_BUS.register((Object)new fu_class330());
        MinecraftForge.EVENT_BUS.register((Object)new LunaEntity.a_inner237());
        MinecraftForge.EVENT_BUS.register((Object)new ey_class280());
        MinecraftForge.EVENT_BUS.register((Object)dw_class207.a);
        MinecraftForge.EVENT_BUS.register((Object)new KoboldEntity.c_inner311());
        MinecraftForge.EVENT_BUS.register((Object)new hy_class407.a_inner408());
        MinecraftForge.EVENT_BUS.register((Object)new KoboldManager.b_inner50("tribes"));
        MinecraftForge.EVENT_BUS.register((Object)new c7_class116());
        MinecraftForge.EVENT_BUS.register((Object)new am_class34());
        MinecraftForge.EVENT_BUS.register((Object)new GoblinEntity.c_inner222());
        MinecraftForge.EVENT_BUS.register((Object)new PlayerGoblin.a_inner265());
        MinecraftForge.EVENT_BUS.register((Object)new LampItem.a_inner38());
        MinecraftForge.EVENT_BUS.register((Object)new ad_class25());
        MinecraftForge.EVENT_BUS.register((Object)new GalathEntity.a_inner298());
        MinecraftForge.EVENT_BUS.register((Object)new GalathMangTracker());
        MinecraftForge.EVENT_BUS.register((Object)cc_class124.r);
        MinecraftForge.EVENT_BUS.register((Object)aj_class31.b);
        MinecraftForge.EVENT_BUS.register((Object)new fq_class325());
        MinecraftForge.EVENT_BUS.register((Object)new gy_class392());
        MinecraftForge.EVENT_BUS.register((Object)new bj_class84());
        MinecraftForge.EVENT_BUS.register((Object)g3_class344.b());
        MinecraftForge.EVENT_BUS.register((Object)new ManglelieEntity.b_inner295());
        MinecraftForge.EVENT_BUS.register((Object)new f4_class289());
        if (bl) {
            bn_class89.b();
        }
    }

    @SideOnly(value=Side.CLIENT)
    static void b() {
        if (bn_class89.a()) {
            MinecraftForge.EVENT_BUS.register((Object)new fr_class326());
        } else {
            g2_class343.a = false;
        }
        MinecraftForge.EVENT_BUS.register((Object)new ds_class200());
        MinecraftForge.EVENT_BUS.register((Object)new fh_class313());
        MinecraftForge.EVENT_BUS.register((Object)new d3_class161());
        MinecraftForge.EVENT_BUS.register((Object)new l_class413());
        MinecraftForge.EVENT_BUS.register((Object)new bq_class93());
        MinecraftForge.EVENT_BUS.register((Object)new cn_class138());
        MinecraftForge.EVENT_BUS.register((Object)new e__class234());
        MinecraftForge.EVENT_BUS.register((Object)new w_class427());
        MinecraftForge.EVENT_BUS.register((Object)new dv_class204.a_inner205());
        MinecraftForge.EVENT_BUS.register((Object)new gm_class376());
        MinecraftForge.EVENT_BUS.register((Object)new c6_class115());
        MinecraftForge.EVENT_BUS.register((Object)new a_class4.b_inner5());
        MinecraftForge.EVENT_BUS.register((Object)new br_class94.a_inner95());
        MinecraftForge.EVENT_BUS.register((Object)new gb_class359());
        MinecraftForge.EVENT_BUS.register((Object)new ga_class358());
        MinecraftForge.EVENT_BUS.register((Object)new hf_class401());
    }

    static boolean a() {
        File file = new File("sexmod/dontAskAgain");
        file.getParentFile().mkdirs();
        return !file.exists();
    }

    private static Exception a(Exception exception) {
        return exception;
    }
}

