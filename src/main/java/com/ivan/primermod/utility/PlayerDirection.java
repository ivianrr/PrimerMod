package com.ivan.primermod.utility;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerDirection {
	private double pitch;
	private double yaw;
	private double x;
	private double y;
	private double z;
	private EntityPlayer player;
	public PlayerDirection(EntityPlayer player) {
		this.player=player;
	}
	public void updateData(){
		pitch = Math.toRadians(-player.rotationPitch);
		yaw  = Math.toRadians(-player.rotationYaw);
	}
	public void setPlayer(EntityPlayer player){
		this.player=player;
	}
	public double getX(){
		updateData();
		return Math.cos(pitch) * Math.sin(yaw);
	 }
	 public double getY(){
		updateData();
		return Math.sin(pitch);
	 }
	 public double getZ(){
		updateData();
		return Math.cos(pitch) * Math.cos(yaw);
	 }
	 public double getRealPitch(){
		return Math.toRadians(-player.rotationPitch);
	 }
	 public double getRealYaw(){
		return Math.toRadians(-player.rotationYaw);
	 }
	 public double getSpeedModule(){
		 return Math.sqrt((Math.pow(Math.sqrt(Math.pow(player.motionX,2) + Math.pow(player.motionY, 2)),2) + Math.pow(player.motionZ,2)));
	 }
	 public double getHorizontalSpeedModule(){
		 return Math.sqrt(Math.pow(player.motionX,2) + Math.pow(player.motionZ, 2));
	 }
 
}
