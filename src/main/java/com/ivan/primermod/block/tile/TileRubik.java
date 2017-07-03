package com.ivan.primermod.block.tile;

import com.ivan.primermod.utility.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
//multiblock methods fromhttp://lomeli12.net/tutorials/tutorial-how-to-make-a-simple-multiblock-structure/
public class TileRubik extends TileMod
{	
	private boolean hasMaster, isMaster;
	private int masterX, masterY, masterZ;
	@Override
	public void updateEntity() {
	    super.updateEntity();
	    if (!worldObj.isRemote) {
	        if (hasMaster()) { 
	            if (isMaster()) {
	                // Put stuff you want the multiblock to do here!
	            }
	        } else {
	            // Constantly check if structure is formed until it is.

	            if (checkMultiBlockForm())
	            {
	        	    LogHelper.info("block multiform");
	                setupStructure();

	            }
	        }
	    }
	        
	}

	public boolean checkMultiBlockForm() {
	    int i = 0;
	    // Scan a 3x3x3 area, starting with the bottom left corner
	    for (int x = xCoord - 1; x < xCoord + 2; x++)
	        for (int y = yCoord; y < yCoord + 3; y++)
	            for (int z = zCoord - 1; z < zCoord + 2; z++) {
	                 TileEntity tile = worldObj.getTileEntity(x, y, z);
	                 // Make sure tile isn't null, is an instance of the same Tile, and isn't already a part of a multiblock
	                 if (tile != null && (tile instanceof TileRubik)) {
	                     if (this.isMaster()) {
	                         if (((TileRubik)tile).hasMaster())
	                             i++;
	                     } else if (!((TileRubik)tile).hasMaster())
	                         i++;
	                 }
	             }
	     // check if there are 26 blocks present (3*3*3) and check that center block is empty

	    LogHelper.info("multi has "+(i)+"blocks");
	    return i > 26;
	}
	public void setupStructure() {
	    for (int x = xCoord - 1; x < xCoord + 2; x++)
	        for (int y = yCoord - 1; y < yCoord + 2; y++)
	            for (int z = zCoord - 1; z < zCoord + 2; z++) {
	                TileEntity tile = worldObj.getTileEntity(x, y, z);
	                // Check if block is center block
	                boolean master = (x == xCoord && y == (yCoord) && z == zCoord);
	                if (tile != null && (tile instanceof TileRubik)) {
	                    ((TileRubik) tile).setMasterCoords(xCoord, yCoord, zCoord);
	                    ((TileRubik) tile).setHasMaster(true);
	                    ((TileRubik) tile).setIsMaster(master);
	                }
	            }
	}
	// Reset method to be run when the master is gone or tells them to
	public void reset() {
	    masterX = 0;
	    masterY = 0;
	    masterZ = 0;
	    hasMaster = false;
	    isMaster = false;
	    LogHelper.info("block no longer master "+masterX+" "+masterY+" "+masterZ+" ");
	}
	public void resetStructure() {
	    for (int x = xCoord - 1; x < xCoord + 2; x++)
	        for (int y = yCoord - 1; y < yCoord + 2; y++)
	            for (int z = zCoord - 1; z < zCoord + 2; z++) {
	                TileEntity tile = worldObj.getTileEntity(x, y, z);
	                if (tile != null && (tile instanceof TileRubik))
	                    ((TileRubik) tile).reset();
	            }
	}
	public boolean checkForMaster() {
	    TileEntity tile = worldObj.getTileEntity(masterX, masterY, masterZ);
	    return (tile != null && (tile instanceof TileRubik));
	}
    public boolean hasMaster() {
        return hasMaster;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public int getMasterX() {
        return masterX;
    }

    public int getMasterY() {
        return masterY;
    }

    public int getMasterZ() {
        return masterZ;
    }

    public void setHasMaster(boolean bool) {
        hasMaster = bool;
    }

    public void setIsMaster(boolean bool) {
        isMaster = bool;
    }

    public void setMasterCoords(int x, int y, int z) {
        masterX = x;
        masterY = y;
        masterZ = z;
    }
	
	@Override
	public void writeCustomNBT(NBTTagCompound cmp) {
		cmp.setInteger("masterX", masterX);
        cmp.setInteger("masterY", masterY);
        cmp.setInteger("masterZ", masterZ);
        cmp.setBoolean("hasMaster", hasMaster);
        cmp.setBoolean("isMaster", isMaster);
        if (hasMaster() && isMaster()) {
            // Any other values should ONLY BE SAVED TO THE MASTER
        }
	}
	@Override
	public void readCustomNBT(NBTTagCompound cmp) {
		masterX = cmp.getInteger("masterX");
        masterY = cmp.getInteger("masterY");
        masterZ = cmp.getInteger("masterZ");
        hasMaster = cmp.getBoolean("hasMaster");
        isMaster = cmp.getBoolean("isMaster");
        if (hasMaster() && isMaster()) {
            // Any other values should ONLY BE READ BY THE MASTER
        }
	}


}
