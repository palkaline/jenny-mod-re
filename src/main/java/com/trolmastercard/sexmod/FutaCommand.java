/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.IClientCommand
 */
package com.trolmastercard.sexmod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Random;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.IClientCommand;

public class FutaCommand
extends CommandBase
implements IClientCommand {
    final static String d = "sexmod/futa";
    final static int a = 10;
    final static float c = 0.025f;
    static public boolean e = true;
    final static public FutaCommand b = new FutaCommand();

    public FutaCommand() {
        String string = "";
        try {
            string = new BufferedReader(new FileReader(d)).readLine().toLowerCase();
        } catch (Exception exception) {
            // empty catch block
        }
        if ("".equals(string)) {
            return;
        }
        if ("true".equals(string)) {
            e = true;
        }
        if ("false".equals(string)) {
            e = false;
        }
    }

    @Override
    public String getName() {
        return "futa";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return "/futa <true|false>";
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] stringArray) throws CommandException {
        if (stringArray.length < 1) {
            this.a(iCommandSender);
            return;
        }
        String string = stringArray[0].toLowerCase();
        if ("true".equals(string)) {
            e = true;
        } else if ("false".equals(string)) {
            e = false;
        } else {
            this.a(iCommandSender);
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(d);
            fileWriter.write(string);
            fileWriter.close();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        try {
            for (GirlEntity em_class2582 : GirlEntity.ad()) {
                if (em_class2582.isDead || !em_class2582.world.isRemote || !(em_class2582 instanceof GalathEntity)) continue;
                Vec3d vec3d = em_class2582.b("cockParticles").add(em_class2582.getPositionVector());
                Random random = em_class2582.getRNG();
                for (int i = 0; i < 10; ++i) {
                    em_class2582.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, vec3d.x, vec3d.y, vec3d.z, random.nextFloat() * 0.025f * (float)be_class78.a(), random.nextFloat() * 0.025f * (float)be_class78.a(), random.nextFloat() * 0.025f * (float)be_class78.a(), new int[0]);
                }
            }
        } catch (ConcurrentModificationException concurrentModificationException) {
            // empty catch block
        }
    }

    void a(ICommandSender iCommandSender) {
        iCommandSender.sendMessage(new TextComponentString(String.format("%sYou can either do %s/futa true %sor %s/futa false", new Object[]{TextFormatting.YELLOW, TextFormatting.GRAY, TextFormatting.YELLOW, TextFormatting.GRAY})));
    }

    public boolean allowUsageWithoutPrefix(ICommandSender iCommandSender, String string) {
        return false;
    }

    private static Exception a(Exception exception) {
        return exception;
    }
}

