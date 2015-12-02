package com.ivan.primermod.client.render;

import org.lwjgl.opengl.GL11;

import com.ivan.primermod.block.tile.TileRubik;
import com.ivan.primermod.utility.LogHelper;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RenderTileRubik  extends TileEntitySpecialRenderer
{

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{

	    // locationBlocksTexture is a "ResourceLocation" that points to a texture made of many block "icons".
	    // It will look very ugly, but creating our own ResourceLocation is beyond the scope of this tutorial.
	    this.bindTexture(TextureMap.locationBlocksTexture);

	    Tessellator tessellator = Tessellator.instance;
	    GL11.glPushMatrix();
	    GL11.glTranslated(x+.5, y+.5, z-.001); // +1 so that our "drawing" appears 1 block over our block (to get a better view)
	  
	    GL11.glRotated(180, 0.0F, 1, 0);
	    
	    
	    
	    
	    tessellator.startDrawingQuads();
	    tessellator.addVertexWithUV(0, 0, 0, 0, 0);
	    tessellator.addVertexWithUV(0, 1, 0, 0, 1);
	    tessellator.addVertexWithUV(1, 1, 0, 1, 1);
	    tessellator.addVertexWithUV(1, 0, 0, 1, 0);

	    tessellator.addVertexWithUV(0, 0, 0, 0, 0);
	    tessellator.addVertexWithUV(1, 0, 0, 1, 0);
	    tessellator.addVertexWithUV(1, 1, 0, 1, 1);
	    tessellator.addVertexWithUV(0, 1, 0, 0, 1);
 
	    int angle=0;
	    if (tileentity instanceof TileRubik){
	    angle = ((TileRubik)tileentity).getTimer();
	    }
	    GL11.glRotatef((float)angle*12,0,0,1);
	    
	    
	    
	    
	    
	    tessellator.draw();
	    GL11.glPopMatrix();


	
	}

}
