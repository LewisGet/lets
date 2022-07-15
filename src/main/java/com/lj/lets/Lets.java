package com.lj.lets;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Lets.MODID, name = Lets.NAME, version = Lets.VERSION)
public class Lets
{
    @Mod.Instance
    public static Lets instance;

    public static final String MODID = "lets";
    public static final String NAME = "lets";
    public static final String VERSION = "1.0";

    @EventHandler
    public static void serverStaring(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new LetsCommand());
    }
}
