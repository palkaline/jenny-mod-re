/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  javax.vecmath.Vector2f
 *  net.minecraftforge.fml.common.network.NetworkRegistry$TargetPoint
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 */
package com.trolmastercard.sexmod;

import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Vector2f;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//ei
public abstract class PlayerGirl
extends Fighter {
    final static public String aa = "sexmod:CustomModel";
    final static public String ae = "sexmod:GirlSpecific";
    final static public float ac = 0.0f;
    final static public int am = 100;
    final static public int Y = 65;
    static public boolean ag = true;
    public Vector2f ao = new Vector2f(0.0f, 0.0f);
    public boolean ad = false;
    public boolean aj = false;
    public boolean ak = false;
    public boolean af = true;
    public boolean ah = false;
    final static protected DataParameter<Optional<UUID>> ai = EntityDataManager.createKey(GirlEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID).getSerializer().createKey(118);

    static public Hashtable<UUID, PlayerGirl> al = new Hashtable();
    static public List<PlayerGirl> Z = new ArrayList<PlayerGirl>();
    int an = -1;
    public boolean ab = true;

    protected PlayerGirl(World world) {
        super(world);
        this.setSize(0.01f, 0.01f);
        Z.add(this);
    }

    protected PlayerGirl(World world, UUID uUID) {
        this(world);
        this.m.set(ai, Optional.of(uUID));
    }

    // TODO clash
    @Nullable
    public static PlayerGirl d_(UUID uUID) {
        return al.get(uUID);
    }

    @Nullable
    public static PlayerGirl g(@Nonnull EntityPlayer entityPlayer) {
        return al.get(entityPlayer.getPersistentID());
    }

    @Nullable
    public static PlayerGirl com_trolmastercard_sexmod_ei_class251_a(UUID uUID) {
        try {
            for (GirlEntity em_class2582 : PlayerGirl.ad()) {
                PlayerGirl ei_class2512;
                if (em_class2582.world.isRemote || !(em_class2582 instanceof PlayerGirl) || !uUID.equals((ei_class2512 = (PlayerGirl)em_class2582).java_util_UUID_m())) continue;
                return ei_class2512;
            }
        } catch (ConcurrentModificationException concurrentModificationException) {
            // empty catch block
        }
        return null;
    }

    @Override
    public NetworkRegistry.TargetPoint net_minecraftforge_fml_common_network_NetworkRegistry$TargetPoint_P() {
        return new NetworkRegistry.TargetPoint(this.dimension, this.posX, this.posY - 0.0, this.posZ, 50.0);
    }

    public void a(int n, Action fp_class3242) {
        ge_class363.b.sendToAllTracking((IMessage)new gd_class361(this.java_util_UUID_m(), n, fp_class3242), this.net_minecraftforge_fml_common_network_NetworkRegistry$TargetPoint_P());
    }

    public EntityPlayer net_minecraft_entity_player_EntityPlayer_c(EntityPlayer entityPlayer) {
        return entityPlayer;
    }

    public boolean boolean_z() {
        return true;
    }

    public Vec3d c(Vec3d vec3d, float f) {
        return vec3d;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean boolean_v() {
        return true;
    }

    public boolean boolean_q() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void void_H() {
    }

    public boolean boolean_p() {
        return true;
    }

    public boolean boolean_a(String string) {
        return false;
    }

    public boolean boolean_A() {
        return true;
    }

    @Override
    public String getGirlName() {
        EntityPlayer entityPlayer;
        if (this.m.get(ai).isPresent() && (entityPlayer = this.world.getPlayerEntityByUUID((UUID)this.m.get(ai).get())) != null) {
            return entityPlayer.getName();
        }
        return "anonymous horny girl";
    }

    // Base
    public void u_() {
    }

    public abstract void b(String var1, UUID var2);

    public abstract at_class43 com_trolmastercard_sexmod_at_class43_a(int var1);

    public abstract String java_lang_String_c(int var1);

    public Vec3i net_minecraft_util_math_Vec3i_b(int n) {
        return new Vec3i(255, 255, 255);
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public boolean isNotColliding() {
        return true;
    }

    public boolean boolean_F() {
        return false;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.m.register(ai, Optional.absent());
    }

    @SideOnly(value=Side.CLIENT)
    public static void void_i() {
        PlayerGirl ei_class2512 = PlayerGirl.d_(Minecraft.getMinecraft().player.getPersistentID());
        if (ei_class2512 == null) {
            return;
        }
        ei_class2512.void_r();
    }

    @Override
    public void void_r() {
        this.B = null;
        this.setNoGravity(false);
        if (this.world.isRemote) {
            this.V();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    protected void V() {
        if (this.boolean_n() || this.boolean_f()) {
            d3_class161.a(true);
            EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().player;
            entityPlayerSP.setInvisible(false);
            entityPlayerSP.setNoGravity(false);
            entityPlayerSP.noClip = false;
            this.m.set(G, false);
            ge_class363.b.sendToServer((IMessage)new s_class421(this.girlID()));
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean boolean_H() {
        Minecraft minecraft = Minecraft.getMinecraft();
        return !this.boolean_f() || minecraft.gameSettings.thirdPersonView != 0;
    }

    protected void c(boolean bl) {
        if (!ag) {
            return;
        }
        if (this.java_util_UUID_m() == null) {
            return;
        }
        EntityPlayer entityPlayer = this.world.getPlayerEntityByUUID(this.java_util_UUID_m());
        if (entityPlayer == null) {
            return;
        }
        entityPlayer.capabilities.allowFlying = bl;
        if (!bl) {
            entityPlayer.capabilities.isFlying = false;
        }
        entityPlayer.sendPlayerAbilities();
    }

    public static boolean boolean_e(UUID uUID) {
        PlayerGirl.void_C();
        for (Map.Entry<UUID, PlayerGirl> entry : al.entrySet()) {
            UUID uUID2 = entry.getKey();
            if (!uUID.equals(uUID2)) continue;
            return true;
        }
        return false;
    }

    public static boolean e(EntityPlayer entityPlayer) {
        if (entityPlayer == null) {
            return false;
        }
        return PlayerGirl.boolean_e(entityPlayer.getPersistentID());
    }

    @Override
    public AxisAlignedBB getEntityBoundingBox() {
        return super.getEntityBoundingBox().offset(0.0, 0.5, 0.0);
    }

    protected EntityPlayer net_minecraft_entity_player_EntityPlayer_j() {
        List<EntityPlayer> list = this.world.playerEntities;
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : list) {
            if (entityPlayer2.getPersistentID().equals(this.m.get(ai).get())) continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            double d = entityPlayer.getDistanceSq(this.net_minecraft_util_math_Vec3d_w().x, this.net_minecraft_util_math_Vec3d_w().y, this.net_minecraft_util_math_Vec3d_w().z);
            double d2 = entityPlayer2.getDistanceSq(this.net_minecraft_util_math_Vec3d_w().x, this.net_minecraft_util_math_Vec3d_w().y, this.net_minecraft_util_math_Vec3d_w().z);
            if (!(d2 < d)) continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean boolean_e() {
        EntityPlayer entityPlayer = this.net_minecraft_entity_player_EntityPlayer_j();
        if (entityPlayer == null) {
            return false;
        }
        return entityPlayer.getPersistentID().equals(Minecraft.getMinecraft().player.getPersistentID());
    }

    public Vec3d net_minecraft_util_math_Vec3d_w() {
        return new Vec3d(this.posX, this.posY - 0.0, this.posZ);
    }

    protected void void_b(UUID uUID) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this.world.getPlayerEntityByUUID(uUID);
        EntityPlayerMP entityPlayerMP2 = (EntityPlayerMP)this.world.getPlayerEntityByUUID((UUID)this.m.get(ai).get());
        ge_class363.b.sendTo((IMessage)new gz_class393(false), entityPlayerMP);
        ge_class363.b.sendTo((IMessage)new gz_class393(false), entityPlayerMP2);
        this.void_e(uUID);
        this.rotationYaw = 0.0f;
        this.rotationYawHead = 0.0f;
        entityPlayerMP.rotationYaw = 180.0f;
        entityPlayerMP.rotationYawHead = 180.0f;
        entityPlayerMP.setNoGravity(true);
        entityPlayerMP.noClip = true;
        Vec3d vec3d = this.getPositionVector();
        entityPlayerMP.setPositionAndUpdate(vec3d.x, vec3d.y, vec3d.z + 1.0);
        entityPlayerMP.capabilities.isFlying = true;
        entityPlayerMP2.capabilities.isFlying = true;
        this.j(uUID);
        this.m.set(G, true);
        this.c(vec3d);
        this.void_b(0.0f);
    }

    @Override
    protected void playStepSound(BlockPos blockPos, Block block) {
        super.playStepSound(blockPos, block);
    }

    public AxisAlignedBB net_minecraft_util_math_AxisAlignedBB_a(EntityPlayer entityPlayer) {
        return entityPlayer.getEntityBoundingBox();
    }

    @Override
    public void onUpdate() {
        this.noClip = true;
        this.setNoGravity(true);
        super.onUpdate();
        this.D_();
        if (!this.world.isRemote) {
            return;
        }
        if (this.boolean_f()) {
            w_class427.a.a();
        }
    }

    @SideOnly(value=Side.CLIENT)
    void void_h() {
        Minecraft.getMinecraft().player.eyeHeight = this.getEyeHeight();
    }

    @SideOnly(value=Side.CLIENT)
    public boolean boolean_f() {
        if (!this.m.get(ai).isPresent()) {
            return false;
        }
        return ((UUID)this.m.get(ai).get()).equals(Minecraft.getMinecraft().player.getPersistentID());
    }

    public boolean boolean_E() {
        return false;
    }

    void void_d(EntityPlayer entityPlayer) {
        NBTTagCompound nBTTagCompound = entityPlayer.getEntityData();
        String string = nBTTagCompound.getString(aa + (Object)((Object)fy_class335.a(this)));
        this.f(string);
    }

    @Override
    public void updateAITasks() {
        //Object object;
        PlayerGirl.void_C();
        this.void_l();
        this.G();
        UUID uUID = this.java_util_UUID_m();
        if (uUID == null) {
            return;
        }
        EntityPlayer entityPlayer = this.world.getPlayerEntityByUUID(uUID);
        if (entityPlayer == null) {
            this.setPositionAndUpdate(this.posX, 0.0, this.posZ);
            return;
        }
        this.void_d(entityPlayer);
        if (this.boolean_Q()) {
            Vec3d object = this.net_minecraft_util_math_Vec3d_o();
            this.setPositionAndUpdate(object.x, object.y, object.z);
        } else {
            this.setPositionAndUpdate(entityPlayer.posX, entityPlayer.posY + 0.0, entityPlayer.posZ);
        }
        Action object = this.currentAction();
        if (object == Action.NULL && entityPlayer.isSwingInProgress) {
            this.setCurrentAction(Action.ATTACK);
        }
        if (object == Action.ATTACK && !entityPlayer.isSwingInProgress) {
            this.setCurrentAction(Action.NULL);
        }
    }

    // TODO clashes
    void D_() {
        if (this.an == -1) {
            return;
        }
        ++this.an;
        if (!this.world.isRemote && this.an == 65) {
            this.f(this.int_ah() == 0 ? 1 : 0);
        }
        if (this.an < 100) {
            return;
        }
        if (this.currentAction() != Action.STRIP) {
            return;
        }
        if (this.world.isRemote) {
            this.void_n();
            return;
        }
        this.setCurrentAction(Action.NULL);
    }

    @SideOnly(value=Side.CLIENT)
    void void_n() {
        if (this.boolean_f()) {
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.gameSettings.thirdPersonView = 0;
            minecraft.entityRenderer.loadEntityShader(minecraft.getRenderViewEntity());
            d3_class161.a(true);
        }
    }

    public boolean boolean_o() {
        return this.boolean_Q();
    }

    public Vec3d b(Vec3d vec3d, float f) {
        return vec3d;
    }

    public boolean a(Action fp_class3242, EntityPlayer entityPlayer) {
        return false;
    }

    public boolean boolean_l() {
        return true;
    }

    public void void_b(EntityPlayer entityPlayer) {
    }

    @Override
    public void setCurrentAction(Action fp_class3242) {
        if (!this.world.isRemote && fp_class3242 == Action.NULL && this.boolean_Q()) {
            System.out.println("prevented a potential animation break");
            return;
        }
        if (fp_class3242 == Action.STRIP) {
            this.an = this.world.isRemote ? 5 : 0;
        }
        super.setCurrentAction(fp_class3242);
    }

    void f(EntityPlayer entityPlayer) {
        this.m.set(X, ItemStack.EMPTY);
        this.m.set(T, ItemStack.EMPTY);
        this.m.set(U, ItemStack.EMPTY);
        this.m.set(W, ItemStack.EMPTY);
        for (ItemStack itemStack : entityPlayer.getArmorInventoryList()) {
            if (itemStack.getItem() instanceof ItemElytra) {
                this.m.set(T, itemStack);
                continue;
            }
            if (!(itemStack.getItem() instanceof ItemArmor)) continue;
            ItemArmor itemArmor = (ItemArmor)itemStack.getItem();
            switch (itemArmor.getEquipmentSlot()) {
                case HEAD: {
                    this.m.set(X, itemStack);
                    break;
                }
                case CHEST: {
                    this.m.set(T, itemStack);
                    break;
                }
                case LEGS: {
                    this.m.set(U, itemStack);
                    break;
                }
                case FEET: {
                    this.m.set(W, itemStack);
                }
            }
        }
    }

    public UUID java_util_UUID_m() {
        if (this.m.get(ai).isPresent()) {
            return (UUID)this.m.get(ai).get();
        }
        return null;
    }

    @Nullable
    public EntityPlayer net_minecraft_entity_player_EntityPlayer_k() {
        UUID uUID = this.java_util_UUID_m();
        if (uUID == null) {
            return null;
        }
        return this.world.getPlayerEntityByUUID(uUID);
    }

    public void a(Optional<UUID> optional) {
        this.m.set(ai, optional);
    }

    public void void_y() {
    }

    public void void_B() {
    }

    public static void void_C() {
        ArrayList<PlayerGirl> arrayList = new ArrayList<PlayerGirl>();
        try {
            for (PlayerGirl ei_class2512 : Z) {
                if (ei_class2512.java_util_UUID_m() == null) continue;
                al.put(ei_class2512.java_util_UUID_m(), ei_class2512);
                arrayList.add(ei_class2512);
            }
        } catch (ConcurrentModificationException concurrentModificationException) {
            // empty catch block
        }
        for (PlayerGirl ei_class2512 : arrayList) {
            Z.remove(ei_class2512);
        }
        PlayerGirl.void_t();
    }

    static void void_t() {
        ArrayList<UUID> arrayList = new ArrayList<UUID>();
        for (Map.Entry<UUID, PlayerGirl> object : al.entrySet()) {
            if (!object.getValue().isDead) continue;
            arrayList.add(object.getKey());
        }
        for (UUID uUID : arrayList) {
            al.remove(uUID);
        }
    }

    protected boolean boolean_c(UUID uUID) {
        if (uUID == null) {
            return false;
        }
        PlayerGirl ei_class2512 = PlayerGirl.d_(uUID);
        return ei_class2512 != null;
    }

    @Override
    public void a(String string, UUID uUID) {
        if (this.boolean_a(string)) {
            return;
        }
        if (!this.m.get(ai).isPresent()) {
            return;
        }
        ge_class363.b.sendToServer((IMessage)new g4_class347(string, uUID, (UUID)this.m.get(ai).get(), this.ab));
        this.ab = true;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound.setString("owner", ((UUID)this.m.get(ai).get()).toString());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.m.set(ai, Optional.of(UUID.fromString(nBTTagCompound.getString("owner"))));
        Z.add(this);
    }

    @Override
    public void a(SoundEvent soundEvent, float f, float f2) {
        Vec3d vec3d = this.net_minecraft_util_math_Vec3d_w();
        if (this.world.isRemote) {
            this.world.playSound(vec3d.x, vec3d.y, vec3d.z, soundEvent, SoundCategory.NEUTRAL, f, f2, false);
        } else {
            this.world.playSound(null, new BlockPos(vec3d.x, vec3d.y, vec3d.z), soundEvent, SoundCategory.PLAYERS, f, f2);
        }
    }

    @Override
    public void a(SoundEvent soundEvent) {
        this.a(soundEvent, 1.0f, 1.0f);
    }

    public void a(SoundEvent[] soundEventArray) {
        this.a(soundEventArray[this.getRNG().nextInt(soundEventArray.length)], 1.0f, 1.0f);
    }

    @Override
    public void a(SoundEvent soundEvent, float f) {
        this.a(soundEvent, f, 1.0f);
    }

    @Override
    protected void U() {
    }

    private static ConcurrentModificationException a(ConcurrentModificationException concurrentModificationException) {
        return concurrentModificationException;
    }
}

