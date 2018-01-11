package me.axieum.mcmod.droplet;

import java.io.File;
import java.util.ArrayList;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Config
{

	public static ArrayList<Liquid> liquids = new ArrayList<Liquid>();

	public static void load(File file)
	{
		// [Create] and load the file
		Configuration config = new Configuration(file);
		config.load();

		for (Fluid fluid : FluidRegistry.getRegisteredFluids().values())
		{
			if (!fluid.canBePlacedInWorld())
				return;

			Liquid liquid = new Liquid(fluid);

			config.getCategory(liquid.getName());

			liquid.setBiomesBlacklisted(config.getBoolean("biomesBlacklisted", liquid.getName(), true, "Fluid is not infinite in biomes when blacklisted"));

			String[] biomes = config.getStringList("biomes", liquid.getName(), new String[]{""}, "Add any biome ids here (e.g. River = 7)");
			if (biomes.length > 0)
			{
				for (String biome : biomes)
				{
					if (biome.isEmpty())
						return; // Prevents empty arrays from being processed

					try
					{
						liquid.addBiome(Biome.getBiome(Integer.parseInt(biome)));
					}
					catch (NumberFormatException e)
					{
						System.out.println(e.getMessage());
					}
				}
			}

			liquids.add(liquid);
		}

		// Save the config ready for use
		config.save();
	}

}
