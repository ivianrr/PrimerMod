package com.ivan.primermod.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init()
	{
	//Shaped Vanilla recipes
		//GameRegistry.addRecipe(new ItemStack(ModItems.mapleLeaf)," s ","sss"," s ",'s', new ItemStack(Items.stick));
	//Shapeless Vanilla recipes
		//GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.Flag),new ItemStack(ModItems.mapleLeaf),new ItemStack(ModItems.mapleLeaf) );
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mapleLeaf,3), new ItemStack(ModBlocks.Flag));
		//
	//Oredir Recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mapleLeaf,8)," s ","sds"," s ",'s',"stickWood",'d',new ItemStack(Blocks.dirt)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.Flag),new ItemStack(ModItems.mapleLeaf),new ItemStack(ModItems.mapleLeaf),new ItemStack(ModItems.mapleLeaf)));
	}
}
