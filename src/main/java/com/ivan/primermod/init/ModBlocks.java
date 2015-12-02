package com.ivan.primermod.init;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import com.ivan.primermod.block.BlockFlag;
import com.ivan.primermod.block.BlockFosil;
import com.ivan.primermod.block.BlockModOre;
import com.ivan.primermod.block.BlockMultiTexture;
import com.ivan.primermod.block.BlockPM;
import com.ivan.primermod.block.BlockNumbers;
import com.ivan.primermod.block.BlockRubik;
import com.ivan.primermod.block.tile.TileRubik;
import com.ivan.primermod.reference.Reference;
import com.ivan.primermod.utility.LogHelper;

import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
	public static final BlockPM Flag = new BlockFlag();
	public static final BlockPM Numbers = new BlockNumbers();
	public static final BlockPM LeafOre = new BlockModOre("leafore",Material.rock,ModItems.mapleLeaf,0,1,8);
	public static final BlockPM Fosil = new BlockFosil();
	public static final BlockRubik Rubik = new BlockRubik();

	
	public static void init()
	{
		GameRegistry.registerBlock(Flag, "flag");
		GameRegistry.registerBlock(Numbers,"numbers");
		GameRegistry.registerBlock(LeafOre, "leafore");
		GameRegistry.registerBlock(Fosil, "fosil");
		GameRegistry.registerBlock(Rubik, "rubik");
		
		GameRegistry.registerTileEntity(TileRubik.class, "tileRubik");
	}

}
