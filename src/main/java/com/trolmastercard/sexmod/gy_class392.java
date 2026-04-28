/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraftforge.event.world.WorldEvent$Load
 *  net.minecraftforge.event.world.WorldEvent$Save
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package com.trolmastercard.sexmod;

import com.trolmastercard.sexmod.fy_class335;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class gy_class392
extends WorldSavedData {
    final static String a = "sexmod:customstaticgirlnames";
    final static HashMap<UUID, HashMap<fy_class335, String>> b = new HashMap();

    public gy_class392() {
        super(a);
    }

    public gy_class392(String string) {
        super(a);
    }

    @SubscribeEvent
    public void a(WorldEvent.Save save) {
        World world = save.getWorld();
        world.getMapStorage().setData(a, this);
        this.markDirty();
    }

    @SubscribeEvent
    public void a(WorldEvent.Load load) {
        World world = load.getWorld();
        world.getMapStorage().getOrLoadData(gy_class392.class, a);
    }

    public static void a(UUID uUID, fy_class335 fy_class3352, String string) {
        HashMap<fy_class335, String> hashMap = b.get(uUID);
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put(fy_class3352, string);
        b.put(uUID, hashMap);
    }

    @Nullable
    public static String a(UUID uUID, fy_class335 fy_class3352) {
        HashMap<fy_class335, String> hashMap = b.get(uUID);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get((Object)fy_class3352);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        for (String string : nBTTagCompound.getKeySet()) {
            UUID uUID;
            try {
                uUID = UUID.fromString(string);
            } catch (IllegalArgumentException illegalArgumentException) {
                continue;
            }
            b.put(uUID, this.a(nBTTagCompound.getCompoundTag(string)));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        for (Map.Entry<UUID, HashMap<fy_class335, String>> entry : b.entrySet()) {
            UUID uUID = entry.getKey();
            nBTTagCompound.setTag(uUID.toString(), this.a(entry.getValue()));
        }
        return nBTTagCompound;
    }

    private NBTTagCompound a(HashMap<fy_class335, String> hashMap) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        for (Map.Entry<fy_class335, String> entry : hashMap.entrySet()) {
            nBTTagCompound.setString(entry.getKey().name(), entry.getValue());
        }
        return nBTTagCompound;
    }

    private HashMap<fy_class335, String> a(NBTTagCompound nBTTagCompound) {
        HashMap<fy_class335, String> hashMap = new HashMap<fy_class335, String>();
        for (fy_class335 fy_class3352 : fy_class335.values()) {
            String string = nBTTagCompound.getString(fy_class3352.name());
            if ("".equals(string)) continue;
            hashMap.put(fy_class3352, string);
        }
        return hashMap;
    }

    private static IllegalArgumentException a(IllegalArgumentException illegalArgumentException) {
        return illegalArgumentException;
    }
}

