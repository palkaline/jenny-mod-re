/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.event.entity.living.LivingHealEvent
 *  net.minecraftforge.event.entity.living.LivingHurtEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package com.trolmastercard.sexmod;

import com.google.common.collect.Multimap;

import java.util.List;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class g_class338
extends f_class282 {
    Fighter q;
    EntityLivingBase r;
    Entity o;
    double l = 3.4028234663852886E38;
    Vec3d i = Vec3d.ZERO;
    int j = 0;
    int n = 0;
    int k = 0;
    int p = 0;
    int m = 0;

    public g_class338(Fighter e2_class2182) {
        super(e2_class2182);
        this.q = e2_class2182;
    }

    @Override
    public void updateTask() {
        super.updateTask();
        this.l = this.q.getDistance(this.a);
        this.i = this.a.getPositionVector();
        if (this.q.currentAction() == Action.BOW) {
            this.q.setCurrentAction(Action.NULL);
        }
    }

    boolean a(EntityLivingBase entityLivingBase) {
        Vec3d vec3d = this.q.getPositionVector();
        return !(entityLivingBase instanceof GirlEntity) && this.n <= 0 && entityLivingBase != null && entityLivingBase.world != null && !this.q.equals(entityLivingBase) && entityLivingBase.isEntityAlive() && vec3d.distanceTo(this.a.getPositionVector()) < 15.0 && vec3d.distanceTo(entityLivingBase.getPositionVector()) < 20.0 && !entityLivingBase.equals(this.a);
    }

    @Override
    protected void a(f_class282.a_inner283 a_inner2832) {
        switch (a_inner2832) {
            case ATTACK: {
                this.q.getLookHelper().setLookPositionWithEntity(this.r, 30.0f, 30.0f);
                double d = this.q.getDistance(this.r);
                this.c.clearPath();
                if (d < 1.9 && --this.k <= 0) {
                    this.d();
                    break;
                }
                if (this.q.Q.getStackInSlot(1).getItem() instanceof ItemBow && this.q.getEntitySenses().canSee(this.r) && ++this.p > 0 && d > 6.0) {
                    this.e.set(Fighter.M, 2);
                    this.q.setCurrentAction(Action.BOW);
                    if (++this.p >= 32) {
                        this.p = -20;
                        this.e();
                        this.q.setCurrentAction(Action.NULL);
                    }
                    this.l = this.q.getDistance(this.a);
                    this.i = this.a.getPositionVector();
                    return;
                }
                if (d < 2.0) {
                    this.e.set(Fighter.M, 1);
                    this.c.tryMoveToEntityLiving(this.r, 0.5);
                    this.q.a(GirlEntity.a_inner259.WALK);
                    break;
                }
                this.e.set(Fighter.M, 1);
                this.c.tryMoveToEntityLiving(this.r, 0.7);
                this.q.a(GirlEntity.a_inner259.RUN);
                break;
            }
            case FOLLOW: {
                this.e.set(Fighter.M, 0);
                double d = this.q.getDistance(this.a);
                if ((double)this.c.getPathSearchRange() > d) {
                    this.c.clearPath();
                    if (!this.q.N) {
                        this.c.tryMoveToEntityLiving(this.a, 0.5);
                        this.void_a();
                    }
                } else {
                    this.c();
                }
                this.j = 300;
                this.double_b();
                break;
            }
            case IDLE: {
                this.e.set(Fighter.M, 0);
                if (!this.q.N) {
                    if (++this.j > 200 + r_class420.f.nextInt(100)) {
                        this.j = 0;
                        Vec3d vec3d = this.a.getPositionVector();
                        Vec3d vec3d2 = new Vec3d(vec3d.x + 1.0 + (double)(r_class420.f.nextFloat() * 3.0f), vec3d.y, vec3d.z + 1.0 + (double)(r_class420.f.nextFloat() * 3.0f));
                        this.c.clearPath();
                        this.c.tryMoveToXYZ(vec3d2.x, vec3d2.y, vec3d2.z, 0.5);
                    }
                    this.double_b();
                    break;
                }
                if (!(this.q.getDistance(this.a) > 10.0f)) break;
                this.c();
                break;
            }
            case RIDE: {
                if (this.q.isRiding()) {
                    this.q.setCurrentAction(Action.SIT);
                    break;
                }
                this.q.setNoGravity(true);
                this.q.noClip = true;
                Vec3d vec3d = this.a.getPositionVector().subtract(this.o.getLookVec().x * 0.5, 0.0, this.o.getLookVec().z * 0.5);
                this.q.setPositionAndRotation(vec3d.x, vec3d.y, vec3d.z, 0.0f, 0.0f);
                this.q.motionX = 0.0;
                this.q.motionY = 0.0;
                this.q.motionZ = 0.0;
                this.q.setCurrentAction(Action.RIDE);
                break;
            }
            case DOWNED: {
                this.c.clearPath();
            }
        }
    }

    @Override
    protected f_class282.a_inner283 com_trolmastercard_sexmod_f_class282$a_inner283_a() {
        float f;
        boolean bl;
        //Entity entity;
        --this.n;
        if (this.q.N || this.q.java_util_UUID_ae() != null) {
            return f_class282.a_inner283.DOWNED;
        }
        if (this.a.isRiding()) {
            Entity entity = this.a.getRidingEntity();
            if (this.q.isRiding() || this.q.startRiding(entity) || entity instanceof EntityHorse && ((EntityHorse)entity).isHorseSaddled()) {
                this.o = entity;
                return f_class282.a_inner283.RIDE;
            }
        } else if (!this.a.isRiding() && this.q.isRiding() || this.f == f_class282.a_inner283.RIDE && !this.a.isRiding()) {
            this.q.setCurrentAction(Action.NULL);
            this.q.dismountRidingEntity();
            this.q.noClip = false;
            this.q.setNoGravity(false);
        }
        if (this.a(this.r)) {
            return f_class282.a_inner283.ATTACK;
        }
        DamageSource damageSource = this.q.getLastDamageSource();
        if (damageSource != null) {
            EntityLivingBase entity = (EntityLivingBase) damageSource.getTrueSource();
            if (this.a(entity)) {
                this.r = entity;
                return f_class282.a_inner283.ATTACK;
            }
        }
        EntityLivingBase entity = this.a.getLastAttackedEntity();
        if (this.a.ticksExisted - this.a.getLastAttackedEntityTime() < 140 && this.a((EntityLivingBase)entity)) {
            this.r = entity;
            return f_class282.a_inner283.ATTACK;
        }
        if (this.f != f_class282.a_inner283.FOLLOW) {
            damageSource = this.a.getLastDamageSource();
            if (damageSource != null && this.a((EntityLivingBase)(entity = (EntityLivingBase)damageSource.getTrueSource()))) {
                this.r = entity;
                return f_class282.a_inner283.ATTACK;
            }
            Vec3d vec3d = this.q.getPositionVector();
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(vec3d.x - 5.0, vec3d.y - 2.0, vec3d.z - 5.0, vec3d.x + 5.0, vec3d.y + 2.0, vec3d.z + 5.0);
            List<EntityMob> list = this.q.world.getEntitiesWithinAABB(EntityMob.class, axisAlignedBB);
            list.sort((entityMob, entityMob2) -> {
                double d;
                double d2 = entityMob.getDistance(this.q);
                if (d2 == (d = (double)entityMob2.getDistance(this.q))) {
                    return 0;
                }
                return d2 < d ? -1 : 1;
            });
            for (EntityMob entityMob3 : list) {
                if (!this.a(entityMob3) || entityMob3 instanceof EntityCreeper) continue;
                this.r = entityMob3;
                return f_class282.a_inner283.ATTACK;
            }
        }
        boolean bl2 = bl = (f = this.q.getDistance(this.a)) > 5.0f;
        if (!bl && this.f == f_class282.a_inner283.FOLLOW) {
            if (++this.m > 60) {
                bl = false;
                this.m = 0;
            } else {
                bl = true;
            }
        }
        if (bl && this.f == f_class282.a_inner283.ATTACK) {
            this.n = 60;
        }
        if (bl) {
            return f_class282.a_inner283.FOLLOW;
        }
        return f_class282.a_inner283.IDLE;
    }

    public void e() {
        EntityArrow entityArrow = this.net_minecraft_entity_projectile_EntityArrow_b();
        double d = this.r.posX - this.q.posX;
        double d2 = this.r.getEntityBoundingBox().minY + (double)(this.r.height / 3.0f) - entityArrow.posY;
        double d3 = this.r.posZ - this.q.posZ;
        double d4 = MathHelper.sqrt(d * d + d3 * d3);
        entityArrow.shoot(d, d2 + d4 * (double)0.2f, d3, 1.6f, 2.0f);
        this.q.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0f, 1.0f / (this.q.getRNG().nextFloat() * 0.4f + 0.8f));
        this.q.world.spawnEntity(entityArrow);
        entityArrow.setDamage(4.5);
    }

    protected EntityArrow net_minecraft_entity_projectile_EntityArrow_b() {
        EntityTippedArrow entityTippedArrow = new EntityTippedArrow(this.q.world, this.q);
        ItemStack itemStack = this.q.Q.getStackInSlot(1);
        double d = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, itemStack);
        int n = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, itemStack);
        int n2 = EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, itemStack);
        if (d != 0.0) {
            entityTippedArrow.setDamage(entityTippedArrow.getDamage() + d * 0.5 + 0.5);
        }
        if (n != 0) {
            entityTippedArrow.setKnockbackStrength(n);
        }
        if (n2 != 0) {
            entityTippedArrow.setFire(100);
        }
        return entityTippedArrow;
    }

    void d() {
        this.q.setCurrentAction(Action.ATTACK);
        this.e.set(Fighter.M, 1);
        ItemStack itemStack = this.q.Q.getStackInSlot(0);
        Multimap<String, AttributeModifier> multimap = itemStack.getAttributeModifiers(EntityEquipmentSlot.MAINHAND);
        float f = 0.0f;
        float f2 = 0.0f;
        for (AttributeModifier attributeModifier : multimap.get(SharedMonsterAttributes.ATTACK_DAMAGE.getName())) {
            f = (float)attributeModifier.getAmount();
        }
        for (AttributeModifier attributeModifier : multimap.get(SharedMonsterAttributes.ATTACK_SPEED.getName())) {
            f2 = (float)attributeModifier.getAmount();
        }
        f2 = Math.max(f2, 0.5f);
        float f3 = EnchantmentHelper.getModifierForCreature(itemStack, this.r.getCreatureAttribute());
        int n = EnchantmentHelper.getEnchantmentLevel(Enchantments.KNOCKBACK, itemStack);
        int n2 = EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_ASPECT, itemStack);
        int n3 = EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING, itemStack);
        this.r.knockBack(this.q, (float)n * 0.5f, MathHelper.sin(this.q.rotationYaw * ((float)Math.PI / 180)), -MathHelper.cos(this.q.rotationYaw * ((float)Math.PI / 180)));
        this.r.setFire(n2 * 4);
        if (n3 != 0) {
            float f4 = 0.5f;
            if (n3 == 2) {
                f4 = 0.67f;
            } else if (n3 == 3) {
                f4 = 0.75f;
            }
            for (EntityLivingBase entityLivingBase : this.q.world.getEntitiesWithinAABB(EntityLivingBase.class, this.r.getEntityBoundingBox().grow(1.0, 0.25, 1.0))) {
                if (entityLivingBase == this.q || entityLivingBase == this.a || entityLivingBase == this.r || this.q.isOnSameTeam(entityLivingBase) || !(this.q.getDistanceSq(entityLivingBase) < 9.0)) continue;
                entityLivingBase.knockBack(this.q, 0.4f, MathHelper.sin(this.q.rotationYaw * ((float)Math.PI / 180)), -MathHelper.cos(this.q.rotationYaw * ((float)Math.PI / 180)));
                entityLivingBase.attackEntityFrom(DamageSource.causeMobDamage(this.q), (f + f3) * f4);
            }
        }
        this.r.attackEntityFrom(DamageSource.causeMobDamage(this.q), f + f3);
        this.k = Math.round(Math.abs(f2) / 3.373494f * 20.0f);
    }

    @Override
    protected double double_b() {
        double d = super.double_b();
        if (this.q.N) {
            d = 0.0;
        }
        this.c.setSpeed(d);
        this.q.a(this.q.com_trolmastercard_sexmod_em_class258$a_inner259_q());
        return d;
    }

    @Override
    public void resetTask() {
        super.resetTask();
        this.q.getDataManager().set(Fighter.M, 0);
    }

    void void_a() {
        if (this.q.onGround || this.q.isInWater() || this.q.motionX + this.q.motionZ != 0.0 || this.q.motionY <= 0.0) {
            return;
        }
        Vec3d vec3d = new Vec3d(0.0, 0.0, 0.1f);
        vec3d = ck_class135.a(vec3d, this.q.rotationYaw);
        this.q.motionX = vec3d.x;
        this.q.motionZ = vec3d.z;
    }

    private static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }

    public static class a_inner339 {
        @SubscribeEvent
        public void a(LivingHurtEvent livingHurtEvent) {
            if (livingHurtEvent.getEntityLiving() instanceof Fighter) {
                Fighter e2_class2182 = (Fighter)livingHurtEvent.getEntityLiving();
                if (e2_class2182.N) {
                    livingHurtEvent.setCanceled(true);
                } else if (e2_class2182.getHealth() - livingHurtEvent.getAmount() < 0.0f && !((String)e2_class2182.getDataManager().get(Fighter.v)).equals("")) {
                    e2_class2182.N = true;
                    e2_class2182.setCurrentAction(Action.DOWNED);
                    livingHurtEvent.setAmount(e2_class2182.getHealth() - 1.0f);
                    e2_class2182.getNavigator().clearPath();
                }
            }
        }

        @SubscribeEvent
        public void a(LivingHealEvent livingHealEvent) {
            if (livingHealEvent.getEntityLiving() instanceof Fighter) {
                Fighter e2_class2182 = (Fighter)livingHealEvent.getEntityLiving();
                if (e2_class2182.N && e2_class2182.getHealth() + livingHealEvent.getAmount() >= e2_class2182.getMaxHealth()) {
                    e2_class2182.N = false;
                    e2_class2182.setCurrentAction(Action.NULL);
                }
            }
        }

        @SubscribeEvent
        public void a(LivingDeathEvent livingDeathEvent) {
            if (livingDeathEvent.getEntityLiving() instanceof Fighter) {
                Fighter e2_class2182 = (Fighter)livingDeathEvent.getEntityLiving();
                if (e2_class2182.world.isRemote) {
                    return;
                }
                for (int i = 0; i < 6; ++i) {
                    Item item = e2_class2182.Q.getStackInSlot(i).getItem();
                    if (item == Items.AIR) continue;
                    e2_class2182.dropItem(item, 1);
                }
            }
        }

        private static RuntimeException a(RuntimeException runtimeException) {
            return runtimeException;
        }
    }
}

