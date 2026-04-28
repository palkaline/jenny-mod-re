/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 */
package com.trolmastercard.sexmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;

public class SlimeEntity
extends GirlEntity {
    final static double Q = (double)0.7f;
    final static float W = 0.9f;
    final static double M = 100.0;
    final static float L = 0.1f;
    final static int O = 2400;
    a_inner321 S = a_inner321.IDLE;
    static public DataParameter<Integer> U = EntityDataManager.createKey(SlimeEntity.class, DataSerializers.VARINT).getSerializer().createKey(113);
    static public DataParameter<Float> R = EntityDataManager.createKey(SlimeEntity.class, DataSerializers.FLOAT).getSerializer().createKey(112);
    static public DataParameter<Integer> T = EntityDataManager.createKey(SlimeEntity.class, DataSerializers.VARINT).getSerializer().createKey(111);
    int N = 0;
    boolean K = true;
    boolean V = false;
    int P = 0;

    public SlimeEntity(World world) {
        super(world);
    }

    @Override
    public String getGirlName() {
        return "Slime";
    }

    @Override
    public float float_i() {
        return 1.6f;
    }

    @Override
    public void setCurrentAction(Action fp_class3242) {
        if (this.currentAction() == Action.CUMBLOWJOB && (fp_class3242 == Action.THRUSTBLOWJOB || fp_class3242 == Action.SUCKBLOWJOB)) {
            return;
        }
        if (this.currentAction() == Action.DOGGYCUM && (fp_class3242 == Action.DOGGYFAST || fp_class3242 == Action.DOGGYSLOW)) {
            return;
        }
        super.setCurrentAction(fp_class3242);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean boolean_t() {
        return false;
    }

    @Override
    protected void initEntityAI() {
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(T, 0);
        this.getDataManager().register(R, Float.valueOf(0.0f));
        this.getDataManager().register(U, -1);
    }

    @Override
    protected Action com_trolmastercard_sexmod_fp_class324_a(Action fp_class3242) {
        if (fp_class3242 == Action.SUCKBLOWJOB || fp_class3242 == Action.THRUSTBLOWJOB) {
            return Action.CUMBLOWJOB;
        }
        if (fp_class3242 == Action.DOGGYSLOW || fp_class3242 == Action.DOGGYFAST) {
            return Action.DOGGYCUM;
        }
        return null;
    }

    @Override
    protected Action com_trolmastercard_sexmod_fp_class324_c(Action fp_class3242) {
        if (fp_class3242 == Action.SUCKBLOWJOB) {
            return Action.THRUSTBLOWJOB;
        }
        if (fp_class3242 == Action.DOGGYSLOW) {
            return Action.DOGGYFAST;
        }
        return null;
    }

    @Override
    protected float getJumpUpwardsMotion() {
        return 0.9f;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound.setInteger("hornyLevel", this.m.get(T));
        nBTTagCompound.setInteger("ticksUntilBirth", this.m.get(U));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.m.set(T, nBTTagCompound.getInteger("hornyLevel"));
        this.m.set(U, nBTTagCompound.getInteger("ticksUntilBirth"));
        if (this.m.get(T) != 0) {
            this.m.set(D, 0);
        }
        this.noClip = false;
        this.setNoGravity(false);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return dz_class213.b;
    }

    @Override
    public void void_g() {
        this.m.set(T, 0);
        this.m.set(D, 1);
    }

    @Override
    public void updateAITasks() {
        super.updateAITasks();
        this.a_19();
        this.void_c();
        if (this.isPotionActive(co_class139.b) && this.S == a_inner321.IDLE && this.m.get(U) == -1) {
            this.m.set(T, 2);
            if ((Integer)this.m.get(D) == 1) {
                this.setCurrentAction(Action.UNDRESS);
            }
            this.removePotionEffect(co_class139.b);
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.currentAction() == Action.NULL) {
            this.b_42();
        }
        if (this.m.get(T) >= 2 && this.ticksExisted % 10 == 0) {
            SlimeEntity.a(EnumParticleTypes.HEART, (GirlEntity)this);
        }
        if (this.world.isRemote) {
            this.void_d();
            this.void_i();
        }
    }

    @SideOnly(value=Side.CLIENT)
    void void_i() {
        if (this.java_util_UUID_ae() == null) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().player;
        if (!this.java_util_UUID_ae().equals(entityPlayerSP.getPersistentID())) {
            return;
        }
        Vec3d vec3d = this.getPositionVector();
        Vec3d vec3d2 = ck_class135.a(new Vec3d(0.0, 0.0, 0.65f), this.java_lang_Float_I().floatValue());
        vec3d = vec3d.add(vec3d2);
        entityPlayerSP.setPosition(vec3d.x, vec3d.y, vec3d.z);
        entityPlayerSP.setVelocity(0.0, 0.0, 0.0);
    }

    void void_d() {
        int n = this.m.get(U);
        if (n == -1) {
            return;
        }
        SlimeEntity.a(EnumParticleTypes.SPELL_WITCH, (GirlEntity)this);
        if (n == 0) {
            this.a(c_class108.MISC_PLOB[0]);
        }
    }

    void void_c() {
        int n = this.m.get(U);
        if (n == -1) {
            return;
        }
        this.m.set(U, n - 1);
        if (--n >= 0) {
            return;
        }
        ay_class51 ay_class512 = new ay_class51(this.world);
        ay_class512.setPosition(this.posX, this.posY, this.posZ);
        this.world.spawnEntity(ay_class512);
        this.m.set(U, -1);
    }

    void a_19() {
        int n = this.m.get(T);
        if (n < 2) {
            return;
        }
        if (n >= 4 && this.onGround && this.currentAction() == Action.NULL) {
            this.c(this.getPositionVector());
            this.void_b(this.rotationYaw);
            this.m.set(G, true);
            this.setNoGravity(true);
            this.noClip = true;
            this.setCurrentAction(Action.STARTDOGGY);
            return;
        }
        EntityPlayer entityPlayer = this.world.getClosestPlayerToEntity(this, 1.0);
        if (entityPlayer == null || !entityPlayer.onGround || SlimeEntity.com_trolmastercard_sexmod_em_class258_d(entityPlayer) != null) {
            return;
        }
        this.c(this.getPositionVector());
        this.void_b(this.rotationYaw);
        this.m.set(G, true);
        this.setNoGravity(true);
        this.noClip = true;
        entityPlayer.setNoGravity(true);
        entityPlayer.noClip = true;
        ge_class363.b.sendTo((IMessage)new gz_class393(false), (EntityPlayerMP)entityPlayer);
        this.void_e(entityPlayer.getPersistentID());
        entityPlayer.rotationYaw = this.java_lang_Float_I().floatValue();
        Vec3d vec3d = ck_class135.a(new Vec3d(0.0, 0.0, 0.65f), this.java_lang_Float_I().floatValue());
        entityPlayer.setPosition(this.posX + vec3d.x, this.posY, this.posZ + vec3d.z);
        if (this.currentAction() == Action.WAITDOGGY) {
            this.setCurrentAction(Action.DOGGYSTART);
        } else {
            this.setCurrentAction(Action.SUCKBLOWJOB);
        }
    }

    void b_42() {
        if (this.world.isRemote) {
            float f;
            if ((double)this.N == 90.0) {
                this.S = a_inner321.JUMP_START;
            }
            if (!this.K && this.onGround) {
                this.S = a_inner321.JUMP_END;
                this.N = 0;
            }
            this.rotationYaw = f = this.m.get(R).floatValue();
            this.rotationYawHead = f;
            this.renderYawOffset = f;
        } else {
            if ((double)this.N == 85.0) {
                this.m.set(R, Float.valueOf(this.float_e()));
            }
            if ((double)this.N == 100.0) {
                this.void_h();
            }
            if (!this.K && this.onGround) {
                boolean bl = this.V = this.m.get(U) == -1 && this.getRNG().nextFloat() < 0.1f;
            }
            if (this.V && this.N == 50) {
                int n = this.m.get(T);
                int n2 = n + 1;
                this.m.set(T, n2);
                if (n2 == 1) {
                    this.setCurrentAction(Action.UNDRESS);
                }
            }
        }
        if (this.onGround) {
            ++this.N;
        }
        this.K = this.onGround;
    }

    void void_h() {
        float f;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.jump();
        this.rotationYaw = f = this.m.get(R).floatValue();
        this.prevRotationYaw = f;
        Vec3d vec3d = new Vec3d(0.0, 0.0, 0.7f);
        vec3d = ck_class135.a(vec3d, f);
        this.motionX = vec3d.x;
        this.motionZ = vec3d.z;
        this.N = 0;
    }

    float float_e() {
        int n = this.m.get(T);
        if (this.m.get(U) != -1) {
            return this.float_f();
        }
        if (n < 2) {
            return this.float_f();
        }
        EntityPlayer entityPlayer = this.world.getClosestPlayerToEntity(this, 30.0);
        if (entityPlayer == null) {
            return this.float_f();
        }
        if (SlimeEntity.com_trolmastercard_sexmod_em_class258_d(entityPlayer) != null) {
            return this.float_f();
        }
        return (float)Math.atan2(this.posZ - entityPlayer.posZ, this.posX - entityPlayer.posX) * 57.29578f + 90.0f;
    }

    float float_f() {
        return r_class420.f.nextFloat() * 360.0f;
    }

    @Override
    public void fall(float f, float f2) {
    }

    @Override
    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> animationEvent) {
        if (this.world instanceof FakeWorld) {
            return null;
        }
        block4 : switch (animationEvent.getController().getName()) {
            case "eyes": {
                if (this.currentAction() == Action.NULL || !this.currentAction().autoBlink) {
                    this.createAnimation("animation.slime.null", true, animationEvent);
                    break;
                }
                this.createAnimation("animation.slime.fhappy", true, animationEvent);
                break;
            }
            case "action": {
                if (this.currentAction() == Action.NULL) {
                    this.createAnimation(this.S.a, true, animationEvent);
                    break;
                }
                switch (this.currentAction()) {
                    case UNDRESS: {
                        this.createAnimation("animation.slime.undress", false, animationEvent);
                        break block4;
                    }
                    case DRESS: {
                        this.createAnimation("animation.slime.dress", false, animationEvent);
                        break block4;
                    }
                    case STRIP: {
                        this.createAnimation("animation.slime.strip", false, animationEvent);
                        break block4;
                    }
                    case STARTBLOWJOB: {
                        this.createAnimation("animation.slime.blowjobintro", false, animationEvent);
                        break block4;
                    }
                    case SUCKBLOWJOB: {
                        this.createAnimation("animation.slime.blowjobsuck", true, animationEvent);
                        break block4;
                    }
                    case THRUSTBLOWJOB: {
                        this.createAnimation("animation.slime.blowjobthrust", true, animationEvent);
                        break block4;
                    }
                    case CUMBLOWJOB: {
                        this.createAnimation("animation.slime.blowjobcum", false, animationEvent);
                        break block4;
                    }
                    case STARTDOGGY: {
                        this.createAnimation("animation.slime.doggygoonbed", false, animationEvent);
                        break block4;
                    }
                    case WAITDOGGY: {
                        this.createAnimation("animation.slime.doggywait", true, animationEvent);
                        break block4;
                    }
                    case DOGGYSTART: {
                        this.createAnimation("animation.slime.doggystart", false, animationEvent);
                        break block4;
                    }
                    case DOGGYSLOW: {
                        this.createAnimation("animation.slime.doggyslow", true, animationEvent);
                        break block4;
                    }
                    case DOGGYFAST: {
                        this.createAnimation("animation.slime.doggyfast", true, animationEvent);
                        break block4;
                    }
                    case DOGGYCUM: {
                        this.createAnimation("animation.slime.doggycum", false, animationEvent);
                    }
                }
            }
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        AnimationController.ISoundListener iSoundListener = soundKeyframeEvent -> {
            switch (soundKeyframeEvent.sound) {
                case "undress": {
                    if (!this.boolean_e()) break;
                    this.changeDataParameterFromClient("currentModel", "0");
                    this.setCurrentAction(Action.NULL);
                    break;
                }
                case "dress": {
                    if (!this.boolean_e()) break;
                    this.m.set(D, 1);
                    this.setCurrentAction((Action)null);
                    this.void_r();
                    break;
                }
                case "becomeNude": {
                    this.m.set(D, 0);
                    break;
                }
                case "sexUiOn": {
                    if (!this.boolean_n() || ds_class200.d) break;
                    ds_class200.d();
                    break;
                }
                case "bjiMSG10": {
                    if (!this.boolean_n()) break;
                    this.a(-0.4, -0.8, -0.2, 60.0f, -3.0f);
                    break;
                }
                case "bjiMSG11": {
                    this.a(SoundEvents.ENTITY_SLIME_SQUISH, 0.5f);
                    if (!this.boolean_n()) break;
                    ds_class200.a(0.02);
                    break;
                }
                case "bjiMSG12": {
                    if (r_class420.f.nextInt(5) == 0) {
                        this.a(SoundEvents.ENTITY_SLIME_JUMP, 0.5f);
                    }
                    this.a(SoundEvents.ENTITY_SLIME_SQUISH, 0.5f);
                    if (!this.boolean_n()) break;
                    ds_class200.a(0.02);
                    break;
                }
                case "bjtMSG1": {
                    this.a(SoundEvents.BLOCK_SLIME_HIT);
                    this.a(SoundEvents.ENTITY_SLIME_DEATH);
                    if (!this.boolean_n()) break;
                    ds_class200.a(0.04);
                    break;
                }
                case "bjiDone": {
                    this.setCurrentAction(Action.SUCKBLOWJOB);
                    if (!this.boolean_n()) break;
                    ds_class200.d();
                    break;
                }
                case "bjtDone": {
                    this.setCurrentAction(Action.SUCKBLOWJOB);
                    break;
                }
                case "bjtReady": 
                case "doggyfastReady": {
                    if (!this.boolean_n() || !d3_class161.d) break;
                    this.N();
                    break;
                }
                case "bjcMSG1": {
                    this.a(SoundEvents.ENTITY_SLIME_JUMP);
                    break;
                }
                case "bjcMSG2": {
                    this.a(SoundEvents.ENTITY_SLIME_JUMP);
                    if (!this.boolean_n()) break;
                    ds_class200.c();
                    break;
                }
                case "doggyslowMSG2": {
                    this.a(SoundEvents.BLOCK_SLIME_HIT);
                    break;
                }
                case "bjcBlackScreen": {
                    if (!this.boolean_n()) break;
                    fh_class313.b();
                    break;
                }
                case "bjcDone": 
                case "doggyCumDone": {
                    if (!this.boolean_n()) break;
                    ds_class200.b();
                    this.void_r();
                    this.changeDataParameterFromClient("pregnant", String.valueOf(2400));
                    break;
                }
                case "doggyGoOnBedMSG1": {
                    this.a(SoundEvents.ENTITY_SLIME_SQUISH);
                    this.r = this.rotationYaw;
                    break;
                }
                case "doggyGoOnBedDone": {
                    this.setCurrentAction(Action.WAITDOGGY);
                    break;
                }
                case "doggystartMSG1": {
                    this.a(c_class108.MISC_TOUCH[0]);
                    break;
                }
                case "doggystartMSG2": {
                    this.a(c_class108.MISC_TOUCH[1]);
                    break;
                }
                case "doggystartMSG3": {
                    this.a(SoundEvents.ENTITY_SLIME_SQUISH, 0.25f);
                    break;
                }
                case "doggystartMSG4": {
                    this.a(c_class108.a(c_class108.MISC_SMALLINSERTS), 1.5f);
                    break;
                }
                case "doggystartMSG5": {
                    this.a(c_class108.a(c_class108.MISC_POUNDING), 0.33f);
                    this.a(SoundEvents.BLOCK_SLIME_HIT);
                    break;
                }
                case "doggystartDone": {
                    this.setCurrentAction(Action.DOGGYSLOW);
                    if (!this.boolean_n()) break;
                    ds_class200.d();
                    break;
                }
                case "doggyslowMSG1": {
                    this.a(c_class108.a(c_class108.MISC_POUNDING), 0.33f);
                    int n = r_class420.f.nextInt(4);
                    if (n == 0) {
                        n = r_class420.f.nextInt(2);
                        if (n == 0) {
                            this.a(SoundEvents.ENTITY_SLIME_JUMP);
                        } else {
                            this.a(SoundEvents.ENTITY_SLIME_SQUISH);
                        }
                    } else {
                        this.a(SoundEvents.BLOCK_SLIME_HIT);
                    }
                    if (!this.boolean_n()) break;
                    ds_class200.a(0.02);
                    break;
                }
                case "doggyfastMSG1": {
                    this.a(c_class108.a(c_class108.MISC_POUNDING), 0.75f);
                    if (this.boolean_n()) {
                        ds_class200.a(0.04);
                    }
                    ++this.P;
                    if (this.P % 2 == 0) {
                        int n = r_class420.f.nextInt(2);
                        if (n == 0) {
                            this.a(SoundEvents.ENTITY_SLIME_JUMP);
                            break;
                        }
                        this.a(SoundEvents.ENTITY_SLIME_SQUISH);
                        break;
                    }
                    this.a(SoundEvents.BLOCK_SLIME_HIT);
                    break;
                }
                case "doggyfastDone": {
                    this.setCurrentAction(Action.DOGGYSLOW);
                    break;
                }
                case "doggycumMSG1": {
                    this.a(c_class108.MISC_CUMINFLATION[0], 4.0f);
                    this.a(c_class108.a(c_class108.MISC_POUNDING), 2.0f);
                    this.a(SoundEvents.ENTITY_SLIME_DEATH);
                    break;
                }
                case "jumpStart": {
                    this.a(SoundEvents.ENTITY_SLIME_JUMP);
                    break;
                }
                case "jumpStartDone": {
                    this.S = a_inner321.JUMP_AIR;
                    break;
                }
                case "jumpEndSound": {
                    this.a(SoundEvents.ENTITY_SLIME_SQUISH);
                    break;
                }
                case "jumpEndDone": {
                    this.S = a_inner321.IDLE;
                }
            }
        };
        this.C.registerSoundListener(iSoundListener);
        animationData.addAnimationController(this.C);
        animationData.addAnimationController(this.s);
    }

    private static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }

    static enum a_inner321 {
        IDLE("animation.slime.idle"),
        JUMP_START("animation.slime.jumpstart"),
        JUMP_AIR("animation.slime.jumpair"),
        JUMP_END("animation.slime.jumpend");

        String a;

        public String a() {
            return this.a;
        }

        private a_inner321(String string2) {
            this.a = string2;
        }
    }
}

