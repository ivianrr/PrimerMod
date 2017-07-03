package com.ivan.primermod.block;

import scala.Int;

import com.ivan.primermod.block.tile.TileRubik;
import com.ivan.primermod.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRubik extends BlockModContainer
{

	public BlockRubik()
	{
		super(Material.wood);
		this.setBlockName("rubik");

	}
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
	    TileEntity tile = world.getTileEntity(x, y, z);
	    if (tile != null && tile instanceof TileRubik) {
	        TileRubik multiBlock = (TileRubik) tile;
	        if (multiBlock.hasMaster()) {
	            if (multiBlock.isMaster()) {
	                if (!multiBlock.checkMultiBlockForm())
	                    multiBlock.resetStructure();
	            } else {
	                if (!multiBlock.checkForMaster())
	                    multiBlock.reset();
	            }
	        }
	    }
	    super.onNeighborBlockChange(world, x, y, z, block);
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileRubik();
	}
	
	
	

//	@Override
//	public boolean onBlockActivated(World world, int x,
//			int y, int z, EntityPlayer player,
//			int side, float xHit, float yHit,
//			float zHit)
//	{
//		
//		TileRubik tile;
//		if(world.getTileEntity(x, y, z) instanceof TileRubik){
//			tile =(TileRubik)world.getTileEntity(x, y, z);
//			tile.setTimer(Math.round(yHit*24000));
//			LogHelper.info("x: " + x + " y: " + y + " z: " + z + " side: " + side + " hit x: " + xHit + " hit y: " + yHit + " hit z: " + zHit +" time: "+Math.round(yHit*24000) );
//
//		}
//		return super.onBlockActivated(world, x, y,
//				z, player, side, xHit, yHit,
//				zHit);
//	}
	//Textures
	//------------------------------------------------
//	@Override
//	public boolean isOpaqueCube() {
//	    return false;
//	}
//
//	@Override
//	public int getRenderType() {
//	    return -1;
//	}
//	public boolean renderAsNormalBlock() {
//		return false;
//	}
	public IIcon[] icons = new IIcon[6];

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister reg)
	{
		for (int i = 0; i < 6; i++)
		{
			this.icons[i] = reg.registerIcon(this
					.getUnwrappedUnlocalizedName(this.getUnlocalizedName())
					+ "_" + i);
		}
	}
	@Override
	public IIcon getIcon(int side, int p_149691_2_)
	{
		return this.icons[side];
	}
}
