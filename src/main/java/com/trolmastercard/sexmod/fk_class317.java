/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.client.registry.RenderingRegistry
 */
package com.trolmastercard.sexmod;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class fk_class317 {
    public static void a() {
        RenderingRegistry.registerEntityRenderingHandler(KoboldEntity.class, renderManager -> new KoboldRenderer(renderManager, (AnimatedGeoModel)new KoboldModel(), -0.4));
        RenderingRegistry.registerEntityRenderingHandler(JennyEntity.class, renderManager -> new du_class203(renderManager, new JennyModel(), -0.15));
        RenderingRegistry.registerEntityRenderingHandler(EllieEntity.class, renderManager -> new dk_class189(renderManager, new EllieModel(), 0.05));
        RenderingRegistry.registerEntityRenderingHandler(SlimeEntity.class, renderManager -> new d1_class159(renderManager, (AnimatedGeoModel)new SlimeModel(), -0.2));
        RenderingRegistry.registerEntityRenderingHandler(BiaEntity.class, renderManager -> new dt_class201(renderManager, (AnimatedGeoModel)new BiaModel(), -0.4));
        RenderingRegistry.registerEntityRenderingHandler(AllieEntity.class, renderManager -> new d8_class167(renderManager, (AnimatedGeoModel)new AllieModel(), -0.4));
        RenderingRegistry.registerEntityRenderingHandler(BeeEntity.class, renderManager -> new dn_class194(renderManager, new BeeModel(), -0.4));
        RenderingRegistry.registerEntityRenderingHandler(ay_class51.class, bp_class92::new);
        RenderingRegistry.registerEntityRenderingHandler(LunaEntity.class, renderManager -> new dp_class195(renderManager, new CatModel(), -0.4));
        RenderingRegistry.registerEntityRenderingHandler(GoblinEntity.class, renderManager -> new GoblinRenderer(renderManager, (AnimatedGeoModel)new GoblinModel(), -0.6));
        RenderingRegistry.registerEntityRenderingHandler(GalathEntity.class, renderManager -> new GalathRenderer(renderManager, (AnimatedGeoModel)new GalathModel(), -0.05));
        RenderingRegistry.registerEntityRenderingHandler(i_class410.class, renderManager -> new cp_class140(renderManager, new KoboldEggModel2()));
        RenderingRegistry.registerEntityRenderingHandler(ManglelieEntity.class, renderManager -> new ManglelieRenderer(renderManager, (AnimatedGeoModel)new ManglelieModel(), -0.05));
        RenderingRegistry.registerEntityRenderingHandler(PlayerBia.class, renderManager -> new d0_class157(renderManager, (AnimatedGeoModel)new BiaModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlayerJenny.class, renderManager -> new db_class173(renderManager, (AnimatedGeoModel)new JennyModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlayerEllie.class, renderManager -> new dl_class190(renderManager, (AnimatedGeoModel)new EllieModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlayerSlime.class, renderManager -> new d5_class163(renderManager, (AnimatedGeoModel)new SlimeModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlayerAllie.class, renderManager -> new dv_class204(renderManager, (AnimatedGeoModel)new AllieModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlayerBee.class, renderManager -> new d2_class160(renderManager, (AnimatedGeoModel)new BeeModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlayerLuna.class, renderManager -> new di_class185(renderManager, (AnimatedGeoModel)new CatModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlayerKobold.class, renderManager -> new de_class177(renderManager, (AnimatedGeoModel)new KoboldModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlayerGoblin.class, renderManager -> new dg_class179(renderManager, (AnimatedGeoModel)new GoblinModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlayerGalath.class, renderManager -> new dx_class208(renderManager, (AnimatedGeoModel)new GalathModel()));
        RenderingRegistry.registerEntityRenderingHandler(gi_class370.class, fi_class314::new);
        RenderingRegistry.registerEntityRenderingHandler(cy_class153.class, renderManager -> new b_class57(renderManager, new CrossModel()));
        RenderingRegistry.registerEntityRenderingHandler(c4_class113.class, ag_class28::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPyrocynical.class, e_class214::new);
    }
}

