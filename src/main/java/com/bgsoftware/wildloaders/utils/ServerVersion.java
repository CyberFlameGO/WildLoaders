package com.bgsoftware.wildloaders.utils;

import org.bukkit.Bukkit;

public enum ServerVersion {

    v1_7(17),
    v1_8(18),
    v1_9(19),
    v1_10(110),
    v1_11(111),
    v1_12(112),
    v1_13(113),
    v1_14(114),
    v1_15(115),
    v1_16(116),
    v1_17(117);

    private static final ServerVersion currentVersion;
    private static final String bukkitVersion;
    private static final boolean legacy;

    static {
        bukkitVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        String[] sections = bukkitVersion.split("_");
        currentVersion = ServerVersion.valueOf(sections[0] + "_" + sections[1]);
        legacy = isLessThan(ServerVersion.v1_13);
    }

    private final int code;

    ServerVersion(int code){
        this.code = code;
    }


    public static boolean isAtLeast(ServerVersion serverVersion){
        return currentVersion.code >= serverVersion.code;
    }

    public static boolean isLessThan(ServerVersion serverVersion){
        return currentVersion.code < serverVersion.code;
    }

    public static boolean isEquals(ServerVersion serverVersion){
        return currentVersion.code == serverVersion.code;
    }

    public static boolean isLegacy(){
        return legacy;
    }

    public static String getBukkitVersion(){
        return bukkitVersion;
    }

}
