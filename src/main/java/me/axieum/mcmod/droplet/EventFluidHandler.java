package me.axieum.mcmod.droplet;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CreateFluidSourceEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventFluidHandler
{

	@SubscribeEvent
	public void onCreateFluidSource(CreateFluidSourceEvent e)
	{
		Block block = e.getState().getBlock();
		Biome biome = e.getWorld().getBiome(e.getPos());

		// Check if the liquid should be handled
		for (Liquid liquid : Config.liquids)
		{
			// Strange workaround that allows comparison between flowing_<name> and <name>
			if (liquid.getFluid().getUnlocalizedName().substring(6).equals(block.getUnlocalizedName()))
			{
				if (liquid.isBiomesBlacklisted())
				{
					// If the liquid is in blacklisting mode
					e.setResult(liquid.getBiomes().contains(biome) ? Result.DENY : Result.ALLOW);
				}
				else
				{
					// If the liquid is in whitelisting mode
					e.setResult(liquid.getBiomes().contains(biome) ? Result.ALLOW : Result.DENY);
				}
			}
		}
	}

}
