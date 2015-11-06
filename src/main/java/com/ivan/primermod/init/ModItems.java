package com.ivan.primermod.init;

import com.ivan.primermod.item.*;
import com.ivan.primermod.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	public static final ItemPM mapleLeaf = new ItemMapleLeaf();
	
	
	public static void init(){
	
		GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
	
	}
}
