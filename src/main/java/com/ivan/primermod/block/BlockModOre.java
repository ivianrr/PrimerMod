package com.ivan.primermod.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class BlockModOre extends BlockPM
{
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;

	public BlockModOre(String blockName, Material material, Item drop,
			int meta, int least_quantity, int most_quantity) 				//main constructor
	{
		super(material);
		this.drop = drop;
	    this.meta = meta;
	    this.least_quantity = least_quantity;
	    this.most_quantity = most_quantity;
	    this.setStepSound(soundTypeStone);
	    this.setHardness(3.0f);
	    this.setResistance(20.0f);
	    this.setHarvestLevel("pickaxe", 2);
	    this.setBlockName(blockName);
	}
	public BlockModOre(String blockName, Item drop){
		this(blockName,Material.rock,drop,0,1,1);
	}
	public BlockModOre(String blockName, Item drop,int meta){
		this(blockName,Material.rock,drop,meta,1,1);
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
	    return this.drop;
	}

	@Override
	public int damageDropped(int metadata) {
	    return this.meta;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
	    if (this.least_quantity >= this.most_quantity)
	        return this.least_quantity;
	    return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
}
