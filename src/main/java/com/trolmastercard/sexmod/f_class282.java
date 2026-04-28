/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package com.trolmastercard.sexmod;

import java.util.UUID;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public abstract class f_class282
extends EntityAIBase {
    public GirlEntity d;
    public EntityPlayer a;
    public PathNavigate c;
    public EntityDataManager e;
    public a_inner283 f = a_inner283.IDLE;
    final static public double g = 0.5;
    final static public double h = 0.7;
    final static public int b = 60;

    public f_class282(GirlEntity em_class2582) {
        this.d = em_class2582;
        this.c = em_class2582.getNavigator();
        this.e = em_class2582.getDataManager();
    }

    protected void c() {
        BlockPos blockPos;
        int n = 0;
        do {
            blockPos = this.a.getPosition().add(r_class420.f.nextInt(10), 0, r_class420.f.nextInt(10));
        } while (++n < 20 && !this.d.attemptTeleport(blockPos.getX(), blockPos.getY(), blockPos.getZ()));
        if (n >= 20) {
            this.d.setPosition(this.a.posX, this.a.posY, this.a.posZ);
        }
        this.d.motionX = 0.0;
        this.d.motionY = 0.0;
        this.d.motionZ = 0.0;
    }

    protected double double_b() {
        GirlEntity.a_inner259 a_inner2592;
        double d;
        float f = this.d.getDistance(this.a);
        if (this.a.isSprinting()) {
            d = 0.7;
            a_inner2592 = GirlEntity.a_inner259.RUN;
        } else {
            d = 0.5;
            a_inner2592 = GirlEntity.a_inner259.WALK;
        }
        double d2 = Math.floor(f / 5.0f) * 0.2;
        d += d2;
        if (this.d.isInWater()) {
            d *= 60.0;
            a_inner2592 = GirlEntity.a_inner259.WALK;
        }
        this.c.setSpeed(d);
        this.d.a(a_inner2592);
        return d;
    }

    @Override
    public void resetTask() {
        this.c.clearPath();
        this.f = a_inner283.IDLE;
        this.d.setCurrentAction(Action.NULL);
        this.e.set(GirlEntity.v, "");
        this.c = null;
        this.e = null;
        this.a = null;
    }

    @Override
    public boolean shouldExecute() {
        return !this.d.getDataManager().get(GirlEntity.v).equals("");
    }

    @Override
    public boolean shouldContinueExecuting() {
        String string = this.e.get(GirlEntity.v);
        return !string.equals("") && this.d.world.getPlayerEntityByUUID(UUID.fromString(string)) != null;
    }

    @Override
    public void startExecuting() {
        this.c = this.d.getNavigator();
        this.e = this.d.getDataManager();
        this.a = this.d.world.getPlayerEntityByUUID(UUID.fromString(this.e.get(GirlEntity.v)));
    }

    @Override
    public void updateTask() {
        this.f = this.com_trolmastercard_sexmod_f_class282$a_inner283_a();
        if (this.d.o != null) {
            this.d.o.a = this.f == a_inner283.IDLE;
        }
        this.a(this.f);
    }

    protected abstract a_inner283 com_trolmastercard_sexmod_f_class282$a_inner283_a();

    protected abstract void a(a_inner283 var1);

    @SubscribeEvent
    public void a(LivingDeathEvent livingDeathEvent) {
        GirlEntity em_class2582;
        if (livingDeathEvent.getEntityLiving() instanceof GirlEntity && !(em_class2582 = (GirlEntity)livingDeathEvent.getEntityLiving()).getDataManager().get(GirlEntity.v).equals("")) {
            livingDeathEvent.setCanceled(true);
        }
    }

    private static RuntimeException b(RuntimeException runtimeException) {
        return runtimeException;
    }

    public static enum a_inner283 {
        ATTACK,
        FOLLOW,
        IDLE,
        RIDE,
        DOWNED;

    }
}

