/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.network.NetworkRegistry
 *  net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper
 */
package com.trolmastercard.sexmod;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ge_class363 {
    static public SimpleNetworkWrapper b;
    static private int a;

    private static int b() {
        return a++;
    }

    public static void a() {
        b = NetworkRegistry.INSTANCE.newSimpleChannel("sexmodchannel");
        b.registerMessage(gh_class368.a_inner369.class, gh_class368.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(gh_class368.a_inner369.class, gh_class368.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(gz_class393.a_inner394.class, gz_class393.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(a8_class16.a_inner17.class, a8_class16.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(PacketSendGirlToBed.a_inner24.class, PacketSendGirlToBed.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(b0_class58.a_inner59.class, b0_class58.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(dc_class174.a_inner175.class, dc_class174.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(a1_class7.a_inner8.class, a1_class7.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(a1_class7.a_inner8.class, a1_class7.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(s_class421.a_inner422.class, s_class421.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(n_class415.a_inner416.class, n_class415.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(bo_class90.a_inner91.class, bo_class90.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(gg_class366.a_inner367.class, gg_class366.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(a6_class13.a_inner14.class, a6_class13.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(b1_class60.a_inner61.class, b1_class60.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(t_class423.a_inner424.class, t_class423.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(bg_class80.a_inner81.class, bg_class80.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(cz_class154.a_inner155.class, cz_class154.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(bw_class103.a_inner104.class, bw_class103.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(b__class71.a_inner72.class, b__class71.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(g4_class347.a_inner348.class, g4_class347.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(g4_class347.a_inner348.class, g4_class347.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(eu_class273.a_inner274.class, eu_class273.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(f3_class287.a_inner288.class, f3_class287.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(ej_class253.a_inner254.class, ej_class253.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(gk_class373.a_inner374.class, gk_class373.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(dq_class197.a_inner198.class, dq_class197.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(g9_class354.a_inner355.class, g9_class354.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(b3_class63.a_inner64.class, b3_class63.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(b3_class63.a_inner64.class, b3_class63.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(fj_class315.a_inner316.class, fj_class315.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(fc_class302.a_inner303.class, fc_class302.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(h6_class397.a_inner398.class, h6_class397.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(h6_class397.a_inner398.class, h6_class397.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(au_class44.a_inner45.class, au_class44.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(en_class260.a_inner261.class, en_class260.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(z_class433.a_inner434.class, z_class433.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(e6_class226.a_inner227.class, e6_class226.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(bd_class76.a_inner77.class, bd_class76.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(gd_class361.a_inner362.class, gd_class361.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(fw_class332.a_inner333.class, fw_class332.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(g__class356.a_inner357.class, g__class356.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(ct_class144.a_inner145.class, ct_class144.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(g6_class350.a_inner351.class, g6_class350.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(g6_class350.a_inner351.class, g6_class350.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(cu_class146.a_inner147.class, cu_class146.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(cu_class146.a_inner147.class, cu_class146.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(bv_class101.a_inner102.class, bv_class101.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(cd_class125.a_inner126.class, cd_class125.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(gf_class364.a_inner365.class, gf_class364.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(bk_class85.a_inner86.class, bk_class85.class, ge_class363.b(), Side.SERVER);
        b.registerMessage(ab_class21.a_inner22.class, ab_class21.class, ge_class363.b(), Side.CLIENT);
        b.registerMessage(aq_class39.a_inner40.class, aq_class39.class, ge_class363.b(), Side.CLIENT);
    }

    static {
        a = 0;
    }
}

