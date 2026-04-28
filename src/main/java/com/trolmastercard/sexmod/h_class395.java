/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

public class h_class395
extends f_class282 {
    int j = 0;
    int i = 0;

    public h_class395(GirlEntity em_class2582) {
        super(em_class2582);
    }

    @Override
    public void resetTask() {
        super.resetTask();
        this.d.jumpMovementFactor = 0.02f;
    }

    @Override
    protected f_class282.a_inner283 com_trolmastercard_sexmod_f_class282$a_inner283_a() {
        boolean bl;
        float f = this.d.getDistance(this.a);
        boolean bl2 = bl = f > 5.0f;
        if (this.d.java_util_UUID_ae() == null && !bl && this.f == f_class282.a_inner283.FOLLOW) {
            if (++this.j > 60) {
                bl = false;
                this.j = 0;
            } else {
                bl = true;
            }
        }
        if (bl) {
            return f_class282.a_inner283.FOLLOW;
        }
        return f_class282.a_inner283.IDLE;
    }

    @Override
    protected void a(f_class282.a_inner283 a_inner2832) {
        switch (a_inner2832) {
            case FOLLOW: {
                double d = this.d.getDistance(this.a);
                if ((double)this.c.getPathSearchRange() > d) {
                    this.c.clearPath();
                    this.c.tryMoveToEntityLiving(this.a, 0.5);
                } else {
                    this.c();
                }
                this.i = 300;
                this.double_b();
                break;
            }
            case IDLE: {
                this.double_b();
            }
        }
    }

    @Override
    protected double double_b() {
        float f = this.d.getDistance(this.a);
        float f2 = 0.02f;
        double d = Math.min(0.7, Math.floor(f / 3.0f) * 0.05);
        this.d.jumpMovementFactor = f2 = (float)((double)f2 + d);
        return f2;
    }

    private static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }
}

