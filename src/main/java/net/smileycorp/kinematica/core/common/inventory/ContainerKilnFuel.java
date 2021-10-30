package net.smileycorp.kinematica.core.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerKilnFuel extends Container {
	
	private final IInventory inventory;
	private int burnTime;
	private int currentItemBurnTime;
	
	
	public ContainerKilnFuel(InventoryPlayer playerInventory, IInventory blockInventory) {
		super();
		this.inventory = blockInventory;
		this.addSlotToContainer(new SlotFurnaceFuel(inventory, 2, 80, 44));
		
		//player inventory
		for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 9; ++j)
	            {
	                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	            }
        }
		
		//hotbar
        for (int k = 0; k < 9; ++k) {
        	this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
	}
	

	@Override
	public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, inventory);
    }
	
	@Override
	public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = this.listeners.get(i);
            
            if (this.burnTime != this.inventory.getField(0))
            {
                icontainerlistener.sendWindowProperty(this, 0, this.inventory.getField(0));
            }

            if (this.currentItemBurnTime != this.inventory.getField(1))
            {
                icontainerlistener.sendWindowProperty(this, 1, this.inventory.getField(1));
            }
        }
        
        this.burnTime = this.inventory.getField(0);
        this.currentItemBurnTime = this.inventory.getField(1);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.inventory.setField(id, data);
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.inventory.isUsableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index > 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0)
            {
                if (!this.mergeItemStack(itemstack1, 0, 1, false))
                {
                    return ItemStack.EMPTY;
                }
                if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

}
