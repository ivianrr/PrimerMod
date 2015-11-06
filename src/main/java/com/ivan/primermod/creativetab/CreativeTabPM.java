package com.ivan.primermod.creativetab;

import com.ivan.primermod.init.ModItems;
import com.ivan.primermod.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabPM {
	public static final CreativeTabs PM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()){
		@Override
		public Item getTabIconItem(){
			return ModItems.mapleLeaf;
		}
		/*
		@Override
		public String getTranslatedTabLabel(){
			return "Mod";
		}
		*/
		
	};
	
}
