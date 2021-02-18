package net.smileycorp.kinematica.core.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.smileycorp.kinematica.core.client.gui.*;
import net.smileycorp.kinematica.core.common.tileentity.*;

public class ContainerHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case 0:
				return new ContainerKilnChamber(player.inventory, (IInventory) world.getTileEntity(new BlockPos(x, y, z)));
			case 1:
				return new ContainerKilnFuel(player.inventory, (IInventory) world.getTileEntity(new BlockPos(x, y, z)));
			default :
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		switch (ID) {
			case 0:
				return new GuiKilnChamber(player.inventory, (TileEntityKiln) world.getTileEntity(new BlockPos(x, y, z)), (Container) getServerGuiElement(ID, player, world, x, y, z));
			case 1:
				return new GuiKilnFuel(player.inventory, (TileEntityKiln) world.getTileEntity(new BlockPos(x, y, z)), (Container) getServerGuiElement(ID, player, world, x, y, z));
			default :
				return null;
		}
	}

}
