/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 */
package com.trolmastercard.sexmod;

import java.util.HashMap;
import java.util.UUID;

public class fs_class327 {
    static HashMap<UUID, GirlEntity> a = new HashMap();

    public static void b(GirlEntity em_class2582) {
        a.put(em_class2582.girlID(), em_class2582);
    }

    public static void a(GirlEntity em_class2582) {
        a.remove(em_class2582.girlID());
    }

    public static void a() {
        a.clear();
    }

    public static GirlEntity a(UUID uUID) {
        return a.get(uUID);
    }
}

