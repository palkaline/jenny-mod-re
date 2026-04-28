/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.FMLCommonHandler
 */
package com.trolmastercard.sexmod;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class g0_class341 {
    public static boolean a() {
        String string = Thread.currentThread().getName().toLowerCase();
        if (string.contains("server")) {
            return true;
        }
        if (string.contains("client")) {
            return false;
        }
        MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (minecraftServer == null) {
            return false;
        }
        boolean bl = minecraftServer.isCallingFromMinecraftThread();
        Main.LOGGER.warn("couldn't clarify if is running on a server or client thread. Came to the solution onServer=" + bl);
        return bl;
    }

    private static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }
}

