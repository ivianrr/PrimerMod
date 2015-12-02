package com.ivan.primermod.block.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TileRubik extends TileMod
{
	private int timer=0;
	
	@Override
    public void updateEntity() {
        super.updateEntity();
        //if (!worldObj.isRemote) {
        	timer++;
        	//if (timer>200){
        		worldObj.setWorldTime(12000-timer);
        	//	timer=0;
        	//}
        //}
    }
	@Override
	public void writeCustomNBT(NBTTagCompound cmp) {
		cmp.setInteger("timer", timer);
	}

	public void readCustomNBT(NBTTagCompound cmp) {
		timer = cmp.getInteger("timer");
	}

public int getTimer(){
	return timer;
} 
}
