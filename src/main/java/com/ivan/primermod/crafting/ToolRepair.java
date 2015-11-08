package com.ivan.primermod.crafting;

import java.util.List;

import com.ivan.primermod.init.ModItems;
import com.ivan.primermod.utility.NBTHelper;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ToolRepair extends ShapelessOreRecipe
{
	public ToolRepair(ItemStack par1ItemStack, ItemStack tool)
    {
        super(par1ItemStack, tool);
        
	}
	
    @Override
    public ItemStack getCraftingResult(InventoryCrafting var1){
    	ItemStack tool = var1.getStackInSlot(4);
    	
    	ItemStack result = tool.copy();
    	
    	result.setItemDamage(0);
    	return result;
    }
    
}
