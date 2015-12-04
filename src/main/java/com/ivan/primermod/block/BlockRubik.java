package com.ivan.primermod.block;

import scala.Int;

import com.ivan.primermod.block.tile.TileRubik;
import com.ivan.primermod.utility.LogHelper;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
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
//	public boolean renderAsNormalBlock() {
//		return false;
//	}

	@Override
	public boolean onBlockActivated(World world, int x,
			int y, int z, EntityPlayer player,
			int side, float xHit, float yHit,
			float zHit)
	{
		
		TileRubik tile;
		if(world.getTileEntity(x, y, z) instanceof TileRubik){
			tile =(TileRubik)world.getTileEntity(x, y, z);
			tile.setTimer(Math.round(yHit*24000));
			LogHelper.info("x: " + x + " y: " + y + " z: " + z + " side: " + side + " player: " + player + " hit x: " + xHit + " hit y: " + yHit + " hit z: " + zHit +" time: "+Math.round(yHit*24000) );

		}
		return super.onBlockActivated(world, x, y,
				z, player, side, xHit, yHit,
				zHit);
	}
}
