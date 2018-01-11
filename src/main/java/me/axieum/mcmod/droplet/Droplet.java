package me.axieum.mcmod.droplet;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Droplet.MOD_ID, name = Droplet.NAME, version = Droplet.VERSION)
public class Droplet
{
    public static final String MOD_ID = "droplet";
	public static final String NAME = "Droplet";
    public static final String VERSION = "1.0";

    @Instance(Droplet.MOD_ID)
	public static Droplet instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	// Initialise and load the config
    	Config.load(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	// Register the class to listen for liquid events
    	MinecraftForge.EVENT_BUS.register(new EventFluidHandler());
    }

}
