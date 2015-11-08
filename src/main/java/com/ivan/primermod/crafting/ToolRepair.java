package com.ivan.primermod.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ivan.primermod.init.ModItems;
import com.ivan.primermod.utility.LogHelper;
import com.ivan.primermod.utility.NBTHelper;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;


public class ToolRepair extends ShapelessOreRecipe
{
	public static final int REPAIR_PER_INGOT = 128;
	public Item repairmaterial;

	public ToolRepair(ItemStack par1ItemStack, ItemStack tool,
			Item repairmaterial)
	{
		super(par1ItemStack, tool);
		this.repairmaterial = repairmaterial;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv)
	{
		ItemStack tool = inv.getStackInSlot(4);
		if (tool == null) return null;
		int durability = tool.getItemDamage();

		if (durability == 0)
		{
			return null;
		}

		int totalrepair = 0;
		for (int i = 0; i <= inv.getSizeInventory(); i++)
		{
			ItemStack stack = inv.getStackInSlot(i);
			if (stack != null && stack.getItem().equals(repairmaterial))
			{
				totalrepair++;
			}
		}

		if (totalrepair == 0) return null;

		int damage = durability - (totalrepair * REPAIR_PER_INGOT);

		if (damage < 0)
		{
			if (damage <= -REPAIR_PER_INGOT)
			{
				return null;
			}
			damage = 0;
		}

		ItemStack result = tool.copy();
		result.setItemDamage(damage);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean matches(InventoryCrafting var1, World world)
	{
		ArrayList<Object> required = new ArrayList<Object>(this.getInput());
		required.add(new ItemStack(repairmaterial));

		for (int x = 0; x < var1.getSizeInventory(); x++)
		{
			ItemStack slot = var1.getStackInSlot(x);

			if (slot != null && x != 4)
			{
				if (!slot.getItem().equals(repairmaterial))
				{
					return false;
				}
			}
		}

		return true;
	}

}
