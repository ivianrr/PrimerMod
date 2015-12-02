package com.ivan.primermod.block;

import com.ivan.primermod.block.tile.TileRubik;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRubik extends BlockModContainer
{

	public BlockRubik()
	{
		super(Material.wood);
		this.setBlockName("rubik");

	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileRubik();
	}
	@Override
	public boolean isOpaqueCube() {
	    return false;
	}

	@Override
	public int getRenderType() {
	    return -1;
	}
	public boolean renderAsNormalBlock() {
		return false;
		}
	
}
