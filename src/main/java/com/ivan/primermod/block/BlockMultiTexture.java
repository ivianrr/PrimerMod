package com.ivan.primermod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockMultiTexture extends BlockPM
{
	public BlockMultiTexture()
	{
		super();
	}
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
