/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraftforge.client.event.ModelRegistryEvent
 *  net.minecraftforge.client.model.ModelLoader
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package com.trolmastercard.sexmod;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class gp_class379
extends ItemFishingRod {
    final static public gp_class379 a = new gp_class379();

    public gp_class379() {
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
        this.addPropertyOverride(new ResourceLocation("cast"), new IItemPropertyGetter(){
            @Override
            @SideOnly(value=Side.CLIENT)
            public float apply(ItemStack itemStack, @Nullable World world, @Nullable EntityLivingBase entityLivingBase) {
                if (entityLivingBase == null) {
                    return 0.0f;
                }
                if (!(entityLivingBase instanceof LunaEntity)) {
                    return 0.0f;
                }
                return entityLivingBase.getDataManager().get(LunaEntity.af) != false ? 1.0f : 0.0f;
            }
        });
    }

    public static void a() {
        a.setRegistryName("sexmod", "luna_rod");
        a.setTranslationKey("luna_rod");
        MinecraftForge.EVENT_BUS.register(gp_class379.class);
    }

    @SubscribeEvent
    public static void a(RegistryEvent.Register<Item> register) {
        register.getRegistry().register(a);
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void a(ModelRegistryEvent modelRegistryEvent) {
        ModelLoader.setCustomModelResourceLocation((Item)a, 0, (ModelResourceLocation)new ModelResourceLocation("fishing_rod"));
    }

    public ActionResult<ItemStack> a(World world, LunaEntity eb_class2362, EnumHand enumHand) {
        ItemStack itemStack = eb_class2362.getHeldItem(enumHand);
        if (eb_class2362.av != null) {
            int n = eb_class2362.av.c();
            itemStack.damageItem(n, eb_class2362);
            eb_class2362.swingArm(enumHand);
            world.playSound(null, eb_class2362.posX, eb_class2362.posY, eb_class2362.posZ, SoundEvents.ENTITY_BOBBER_RETRIEVE, SoundCategory.NEUTRAL, 1.0f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
        } else {
            world.playSound(null, eb_class2362.posX, eb_class2362.posY, eb_class2362.posZ, SoundEvents.ENTITY_BOBBER_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world.isRemote) {
                int n;
                gi_class370.b = eb_class2362;
                double d = eb_class2362.getPositionVector().distanceTo(new Vec3d(eb_class2362.ai.getX(), eb_class2362.ai.getY(), eb_class2362.ai.getZ()));
                gi_class370 gi_class3702 = new gi_class370(world, eb_class2362, d * LunaEntity.ap);
                int n2 = EnchantmentHelper.getFishingSpeedBonus(itemStack);
                if (n2 > 0) {
                    gi_class3702.b(n2);
                }
                if ((n = EnchantmentHelper.getFishingLuckBonus(itemStack)) > 0) {
                    gi_class3702.a(n);
                }
                world.spawnEntity(gi_class3702);
            }
            eb_class2362.swingArm(enumHand);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

    private static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }
}

