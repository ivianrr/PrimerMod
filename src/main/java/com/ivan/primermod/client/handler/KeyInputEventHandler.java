package com.ivan.primermod.client.handler;

import net.minecraft.entity.player.EntityPlayer;

import com.ivan.primermod.client.settings.Keybindings;
import com.ivan.primermod.item.ItemMapleLeaf;
import com.ivan.primermod.reference.Key;
import com.ivan.primermod.utility.LogHelper;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler 
{
	public static Key getPressedKeybinding()
	{
		if (Keybindings.charge.isPressed())
		{
			return Key.CHARGE;
		}
		else if (Keybindings.release.isPressed())
		{
			return Key.RELEASE;
		}
		return Key.UNKNOWN;		
	}
	
	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
	{
//		Key tecla = getPressedKeybinding();
//		if (tecla==Key.CHARGE)
//		{
//			if (FMLClientHandler.instance().getClient().inGameHasFocus)
//			{
//		            if (FMLClientHandler.instance().getClientPlayerEntity() != null)
//		            {
//		                EntityPlayer entityPlayer = FMLClientHandler.instance().getClientPlayerEntity();
//		               
//		            }
//		    }
//		}
	}
}
