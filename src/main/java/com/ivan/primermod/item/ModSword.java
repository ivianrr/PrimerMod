package com.ivan.primermod.item;

import com.google.common.collect.Sets;
import com.ivan.primermod.utility.NBTHelper;
import com.ivan.primermod.utility.PlayerDirection;

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
	private static final Set minables = Sets.newHashSet(new Block[] {
			Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab,
			Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone,
			Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore,
			Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore,
			Blocks.diamond_block, Blocks.ice, Blocks.netherrack,
			Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore,
			Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail,
			Blocks.golden_rail, Blocks.activator_rail });

	public ModSword()
	{
		super(4, ToolMaterial.IRON, minables);
		this.setMaxDamage(500);
		this.setFull3D();
		this.setUnlocalizedName("heavenSword");
		this.setNoRepair();
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		setOwner(itemStack, world, player);
	}

	public void setOwner(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (NBTHelper.getString(itemStack, "ownersname") == ""
				|| !NBTHelper.hasTag(itemStack, "ownersname"))
		{
			NBTHelper.setString(itemStack, "ownersname",
					player.getDisplayName());
		}
	}

	public void onUpdate(ItemStack itemStack, World par2World,
			Entity par3Entity, int par4, boolean par5)
	{
		if (par3Entity instanceof EntityPlayer)
		{
			setOwner(itemStack, ((EntityPlayer) par3Entity).getEntityWorld(),
					(EntityPlayer) par3Entity);
		}
	}

	// @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player,
			List list, boolean p_77624_4_)
	{

		String name = NBTHelper.getString(itemStack, "ownersname");
		if (name != "")
		{
			list.add("Owner: " + name);
		} else
		{
			list.add("Ownerless sword");
		}
		;

		int cargas = NBTHelper.getInt(itemStack, "cargas");
		list.add(EnumChatFormatting.RED + "Blood: " + cargas);
		if (cargas == 0)
			list.add(EnumChatFormatting.DARK_PURPLE + "La espada está hambrienta");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player)
	{
		
		boolean sneaking=player.isSneaking();
		
		if ((player.capabilities.isCreativeMode == true))
		{
			if(sneaking){
				player.setVelocity(0, 0, 0);
				return itemStack;
			}
			impulsar(player, 1.5);
		} else
		{
			int cargas = NBTHelper.getInt(itemStack, "cargas");

			if (cargas > 0 && player.motionY < 2)
			{
				if (sneaking)
				{
					player.setVelocity(0, 0, 0);
				} else
				{
					impulsar(player, 1.5);
				}

				NBTHelper.setInteger(itemStack, "cargas", --cargas);
				if (player.motionY >= -1) player.fallDistance = 0;
			}
		}
		return itemStack;
	}

	public static void impulsar(EntityPlayer player, double multipier)
	{
		PlayerDirection p = new PlayerDirection(player);

		player.addVelocity(p.getX() * multipier, 0.75, p.getZ()
				* multipier);
	}

	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer player,
			Entity entity)
	{
		// TO-DO : blacklist no-mob entities
		//entity.isCreatureType(type, forSpawnCount)
		int cargas = NBTHelper.getInt(itemStack, "cargas");
		cargas++;
		NBTHelper.setInteger(itemStack, "cargas", cargas);

		return false;
	}

}
