package me.axieum.mcmod.droplet;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fluids.Fluid;

public class Liquid
{

	private String name;
	private Fluid fluid;
	private boolean biomesBlacklisted = true;
	private ArrayList<Biome> biomes = new ArrayList<Biome>();

	public Liquid(Fluid fluid)
	{
		this.name = Block.REGISTRY.getNameForObject(fluid.getBlock()).toString();
		this.fluid = fluid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isBiomesBlacklisted()
	{
		return biomesBlacklisted;
	}

	public void setBiomesBlacklisted(boolean biomesBlacklisted)
	{
		this.biomesBlacklisted = biomesBlacklisted;
	}

	public ArrayList<Biome> getBiomes()
	{
		return biomes;
	}

	public void setBiomes(ArrayList<Biome> biomes)
	{
		this.biomes = biomes;
	}
	
	public void addBiome(Biome biome)
	{
		this.biomes.add(biome);
	}

	public Fluid getFluid()
	{
		return fluid;
	}

	public void setFluid(Fluid fluid)
	{
		this.fluid = fluid;
	}

}
