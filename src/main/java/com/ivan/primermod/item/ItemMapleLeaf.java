package com.ivan.primermod.item;

import com.ivan.primermod.utility.LogHelper;
import com.ivan.primermod.utility.PlayerDirection;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;


public class ItemMapleLeaf extends ItemPM
{
	public ItemMapleLeaf()
	{
		super();
		this.setUnlocalizedName("mapleLeaf");
		//this.setMaxDamage(16);
		this.setMaxStackSize(64);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer player,
			Entity entity)
	{
		impulsarEntidad(player, 1.5,entity);
		// entity.performHurtAnimation();
		 //entity.attackEntityFrom(DamageSource.magic, 0.5F);
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player)
	{
		if (player.motionY < 2)
		{
			impulsar(player, 1.5);
			itemStack.stackSize--;
			if (player.motionY >= -1) player.fallDistance = 0;
			//itemStack.damageItem(1, player);
		}
		return itemStack;
	}

	public static void impulsar(EntityPlayer player, double horizontalMultipier)
	{
		PlayerDirection p = new PlayerDirection(player);
		if (p.getHorizontalSpeedModule() < 2)
		{
			player.addVelocity(p.getX() * horizontalMultipier, 0.75, p.getZ()
					* horizontalMultipier);
		}
	}
	public static void impulsarEntidad(EntityPlayer player, double horizontalMultipier,Entity entidad)
	{
		PlayerDirection p = new PlayerDirection(player);
		if (p.getHorizontalSpeedModule() < 2)
		{
			entidad.addVelocity(p.getX() * horizontalMultipier, 0.75, p.getZ()
					* horizontalMultipier);
		}
	}

}
