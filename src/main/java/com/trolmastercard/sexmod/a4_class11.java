/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import com.trolmastercard.sexmod.ay_class51;
import com.trolmastercard.sexmod.bp_class92;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

public class a4_class11
implements LayerRenderer<ay_class51> {
    final private bp_class92 b;
    final private ModelBase a = new ModelSlime(0);

    public a4_class11(bp_class92 bp_class922) {
        this.b = bp_class922;
    }

    //a
    @Override
    public void doRenderLayer(ay_class51 ay_class512, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (!ay_class512.isInvisible()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.a.setModelAttributes(this.b.getMainModel());
            this.a.render(ay_class512, f, f2, f4, f5, f6, f7);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }

    // gay synthetic
    //@Override
    //public void doRenderLayer(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
    //    this.a((ay_class51)entityLivingBase, f, f2, f3, f4, f5, f6, f7);
    //}
}

