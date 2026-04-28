/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package com.trolmastercard.sexmod;

import com.trolmastercard.sexmod.g2_class343;
import javax.swing.JFrame;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class fr_class326
extends JFrame {
    public boolean a = false;

    @SubscribeEvent
    public void a(TickEvent.ClientTickEvent clientTickEvent) {
        if (this.a) {
            return;
        }
        this.a = true;
        g2_class343.a();
    }

    private static RuntimeException a(RuntimeException runtimeException) {
        return runtimeException;
    }
}

