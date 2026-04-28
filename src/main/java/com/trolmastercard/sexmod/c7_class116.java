/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.ModelRegistryEvent
 *  net.minecraftforge.client.model.ModelLoader
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$RightClickBlock
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package com.trolmastercard.sexmod;

import com.trolmastercard.sexmod.EyeAndKoboldColor_class2;
import com.trolmastercard.sexmod.hn_class403;
import com.trolmastercard.sexmod.i_class410;
import java.util.UUID;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class c7_class116
extends Item
implements IAnimatable {
    final private AnimationFactory b = new AnimationFactory(this);
    static public c7_class116 a = new c7_class116();

    public c7_class116() {
        this.setMaxStackSize(1);
    }

    public static void a() {
        a.setRegistryName("sexmod", "kobold_egg_item");
        a.setTranslationKey("kobold_egg_item");
        MinecraftForge.EVENT_BUS.register(c7_class116.class);
    }

    @Override
    public void registerControllers(AnimationData animationData) {
    }

    @Override
    public AnimationFactory getFactory() {
        return this.b;
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void a(ModelRegistryEvent modelRegistryEvent) {
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation("sexmod:kobold_egg_item");
        ModelLoader.setCustomMeshDefinition((Item)a, itemStack -> modelResourceLocation);
        ModelBakery.registerItemVariants((Item)a, (ResourceLocation[])new ResourceLocation[]{modelResourceLocation});
        a.setTileEntityItemStackRenderer(new hn_class403());
    }

    @SubscribeEvent
    public static void a(RegistryEvent.Register<Item> register) {
        register.getRegistry().register(a);
    }

    @SubscribeEvent
    public static void a(PlayerInteractEvent.RightClickBlock rightClickBlock) {
        World world = rightClickBlock.getWorld();
        ItemStack itemStack = rightClickBlock.getItemStack();
        Vec3d vec3d = rightClickBlock.getHitVec();
        if (world.isRemote) {
            return;
        }
        if (itemStack.getItem() != a) {
            return;
        }
        i_class410 i_class4102 = new i_class410(world);
        i_class4102.setPosition(vec3d.x, vec3d.y, vec3d.z);
        i_class4102.getDataManager().set(i_class410.b, EyeAndKoboldColor_class2.getColorByWoolId(itemStack.getMetadata()).toString());
        NBTTagCompound nBTTagCompound = itemStack.getTagCompound();
        if (nBTTagCompound != null) {
            i_class4102.f = UUID.fromString(nBTTagCompound.getString("tribeID"));
        }
        world.spawnEntity(i_class4102);
        itemStack.shrink(1);
    }

    private static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }
}

