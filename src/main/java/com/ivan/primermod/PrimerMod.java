package com.ivan.primermod;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.ivan.primermod.client.handler.KeyInputEventHandler;
import com.ivan.primermod.handler.ConfigurationHandler;
import com.ivan.primermod.init.ModBlocks;
import com.ivan.primermod.init.ModItems;
import com.ivan.primermod.init.Recipes;
import com.ivan.primermod.proxy.IProxy;
import com.ivan.primermod.reference.Reference;
import com.ivan.primermod.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class PrimerMod
{
	@Mod.Instance("PrimerMod")
	public static PrimerMod instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		this.proxy.preInit(event);
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

		ModItems.init();
		ModBlocks.init();
		LogHelper.info("PreInicialization complete");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		this.proxy.init(event);
		Recipes.init();

		LogHelper.info("Inicialization complete");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		this.proxy.postInit(event);
		LogHelper.info("PostInicialization complete");
		// for(String oreName :
		// OreDictionary.getOreNames())LogHelper.info(oreName);
		for (ItemStack stack : OreDictionary.getOres("stickWood"))
			LogHelper.info(stack.getItem().getUnlocalizedName());
	}

}
