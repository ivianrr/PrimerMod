package com.ivan.primermod.proxy;

import com.ivan.primermod.block.tile.TileRubik;
import com.ivan.primermod.client.handler.KeyInputEventHandler;
import com.ivan.primermod.client.render.RenderTileRubik;
import com.ivan.primermod.client.settings.Keybindings;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		registerKeyBindings();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
		initRenderers();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(Keybindings.charge);
		ClientRegistry.registerKeyBinding(Keybindings.release);
		
	}
	private void initRenderers(){
		 ClientRegistry.bindTileEntitySpecialRenderer(TileRubik.class, new RenderTileRubik());
	}
}
