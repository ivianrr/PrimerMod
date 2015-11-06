package com.ivan.primermod.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.ivan.primermod.creativetab.CreativeTabPM;
import com.ivan.primermod.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockFlag extends BlockPM
{
	public BlockFlag()
	{
		super();
		this.setBlockName("flag");
		this.setHardness(0);
		this.setResistance(6000000F);
	}

	// @Override
	// public void onBlockDestroyedByPlayer(World mundo, int x, int y, int z,
	// int metadata) {
	// if (!mundo.isRemote)
	// {
	// LogHelper.info("Bloque roto en "+ x + y + z);
	// }
	// }
}
