package com.ivan.primermod.block;

import com.ivan.primermod.block.tile.TileRubik;
import com.ivan.primermod.creativetab.CreativeTabPM;
import com.ivan.primermod.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockModContainer extends BlockContainer
{

	protected BlockModContainer(Material material)
	{
		super(material);
		this.setCreativeTab(CreativeTabPM.PM_TAB);
		
	}
	@Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
        //tile.modid:blockname
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

	@Override
	public abstract TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_);
	
}
