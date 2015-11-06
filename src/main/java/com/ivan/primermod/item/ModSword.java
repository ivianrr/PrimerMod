package com.ivan.primermod.item;

import com.google.common.collect.Sets;
import com.ivan.primermod.utility.NBTHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ModSword extends ModTool
{
	private static final Set minables = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});

	public ModSword(){
		super(4,ToolMaterial.IRON,minables);
		this.setMaxDamage(500);
		this.setFull3D();
		this.setUnlocalizedName("heavenSword");
	}
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player){
		setOwner(itemStack, world, player);
	}
	
	public void setOwner(ItemStack itemStack, World world, EntityPlayer player){
		if(!NBTHelper.hasTag(itemStack, "ownersname"))
		{
		NBTHelper.setString(itemStack, "ownersname", player.getDisplayName());
		}
	}

	public void onUpdate(ItemStack itemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if(par3Entity instanceof EntityPlayer){
			setOwner(itemStack, ((EntityPlayer)par3Entity).getEntityWorld(), (EntityPlayer)par3Entity);
		}
	}

//	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_)
{
		
		String name = NBTHelper.getString(itemStack, "ownersname");
		list.add(EnumChatFormatting.GREEN + "hola");
		if (name!=null)
				list.add("owner: " + name);
	}

}
