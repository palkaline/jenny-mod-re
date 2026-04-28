/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.items.CapabilityItemHandler
 *  net.minecraftforge.items.ItemStackHandler
 */
package com.trolmastercard.sexmod;

import java.util.List;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public abstract class Fighter
extends GirlEntity {
    public int S = 1;
    public int P;
    public int O = 0;
    public int K;
    public Vec3d V = Vec3d.ZERO;
    public boolean N;
    public ItemStackHandler Q = new ItemStackHandler(7);
    final static public DataParameter<ItemStack> L = EntityDataManager.createKey(Fighter.class, DataSerializers.ITEM_STACK).getSerializer().createKey(117);
    final static public DataParameter<ItemStack> R = EntityDataManager.createKey(Fighter.class, DataSerializers.ITEM_STACK).getSerializer().createKey(116);
    final static public DataParameter<ItemStack> X = EntityDataManager.createKey(Fighter.class, DataSerializers.ITEM_STACK).getSerializer().createKey(115);
    final static public DataParameter<ItemStack> T = EntityDataManager.createKey(Fighter.class, DataSerializers.ITEM_STACK).getSerializer().createKey(114);
    final static public DataParameter<ItemStack> U = EntityDataManager.createKey(Fighter.class, DataSerializers.ITEM_STACK).getSerializer().createKey(113);
    final static public DataParameter<ItemStack> W = EntityDataManager.createKey(Fighter.class, DataSerializers.ITEM_STACK).getSerializer().createKey(112);
    final static public DataParameter<Integer> M = EntityDataManager.createKey(Fighter.class, DataSerializers.VARINT).getSerializer().createKey(111);

    protected Fighter(World world) {
        super(world);
        if (this.Q.getStackInSlot(0) == ItemStack.EMPTY) {
            this.Q.setStackInSlot(0, new ItemStack(Items.IRON_SWORD));
        }
        if (this.Q.getStackInSlot(1) == ItemStack.EMPTY) {
            this.Q.setStackInSlot(1, new ItemStack(Items.BOW));
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.m.register(M, 0);
        this.m.register(L, ItemStack.EMPTY);
        this.m.register(R, ItemStack.EMPTY);
        this.m.register(X, ItemStack.EMPTY);
        this.m.register(T, ItemStack.EMPTY);
        this.m.register(U, ItemStack.EMPTY);
        this.m.register(W, ItemStack.EMPTY);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new g_class338(this));
    }

    public void void_c() {
    }

    @Override
    public void updateAITasks() {
        super.updateAITasks();
        if (this.ticksExisted % 80 == 0 && this.getHealth() != this.getMaxHealth()) {
            if (!this.boolean_J()) {
                this.heal(1.0f);
            } else {
                List<EntityMob> list = this.world.getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB(new BlockPos(this.posX - 7.0, this.posY - 1.0, this.posZ - 7.0), new BlockPos(this.posX + 7.0, this.posY + 1.0, this.posZ + 7.0)));
                int n = list.isEmpty() ? 4 : 1;
                this.heal(n);
                ((WorldServer)this.world).spawnParticle(EnumParticleTypes.HEART, false, this.posX, this.posY + 1.0 + r_class420.f.nextDouble(), this.posZ, n, 1.0, 1.0, 1.0, r_class420.f.nextGaussian(), new int[0]);
            }
        }
        if (this.N && !this.boolean_J()) {
            this.N = false;
        }
        this.m.set(HAND_STATES, Byte.valueOf("1"));
        this.m.set(L, this.Q.getStackInSlot(0));
        this.m.set(R, this.Q.getStackInSlot(1));
        this.m.set(X, this.Q.getStackInSlot(2));
        this.m.set(T, this.Q.getStackInSlot(3));
        this.m.set(U, this.Q.getStackInSlot(4));
        this.m.set(W, this.Q.getStackInSlot(5));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(String string, UUID uUID) {
        if ("action.names.followme".equals(string)) {
            this.changeDataParameterFromClient("master", uUID.toString());
        } else if ("action.names.stopfollowme".equals(string)) {
            this.void_x();
        } else if ("action.names.equipment".equals(string)) {
            EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().player;
            ge_class363.b.sendToServer((IMessage)new bo_class90(this.girlID(), entityPlayerSP.getPersistentID()));
        } else if ("action.names.gohome".equals(string)) {
            this.void_x();
            ge_class363.b.sendToServer((IMessage)new gg_class366(this.girlID()));
        } else if ("action.names.setnewhome".equals(string)) {
            this.void_c();
            ge_class363.b.sendToServer((IMessage)new a6_class13(this.girlID(), new Vec3d(this.getPosition())));
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.setTag("inventory", this.Q.serializeNBT());
        super.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.Q.deserializeNBT(nBTTagCompound.getCompoundTag("inventory"));
    }

    public boolean hasCapability(Capability<?> capability, EnumFacing enumFacing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, enumFacing);
    }

    public <T> T getCapability(Capability<T> capability, EnumFacing enumFacing) {
        return (T)(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? this.Q : super.getCapability(capability, enumFacing));
    }

    private static RuntimeException b(RuntimeException runtimeException) {
        return runtimeException;
    }
}

