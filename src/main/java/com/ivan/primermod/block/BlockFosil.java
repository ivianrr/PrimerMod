package com.ivan.primermod.block;

import java.util.ArrayList;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockFosil extends BlockPM
{
	public BlockFosil()
	{
		super();
	    this.setStepSound(soundTypeStone);
	    this.setHardness(3.0f);
	    this.setResistance(20.0f);
	    this.setHarvestLevel("pickaxe", 2);
	    this.setBlockName("fosil");
	}
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
	    ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
	    drops.add(new ItemStack(Items.bone, world.rand.nextInt(2) + 1));
	    drops.add(new ItemStack(Items.dye, world.rand.nextInt(3),15));
	    return drops;
	}
}
