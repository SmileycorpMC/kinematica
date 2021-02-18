package net.smileycorp.kinematica.core.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;



public class TileEntityBase extends TileEntity implements ITickable, ISidedInventory {
	
	protected NonNullList<ItemStack> stacks = NonNullList.<ItemStack>create();
	protected int burnTime;
	protected String customName;
	private final String name;
    
	protected TileEntityBase(String name) {
		this.name=name;
	}
	
	public int getSizeInventory() {
        return this.stacks.size();
    }

    public boolean isEmpty() {
        for (ItemStack itemstack : this.stacks) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getStackInSlot(int index) {
        return this.stacks.get(index);
    }
    
    public ItemStack decrStackSize(int index, int count) {
        ItemStack stack = ItemStackHelper.getAndSplit(this.stacks, index, count);
        if (!stack.isEmpty()) {
    		this.markDirty();
    	}
        return stack;
    }
    
    public ItemStack removeStackFromSlot(int index) {
    	ItemStack stack = ItemStackHelper.getAndRemove(this.stacks, index);
    	if (!stack.isEmpty()) {
    		this.markDirty();
    	}
        return stack;
    }
    
    public boolean isBurning() {
        return this.burnTime > 0;
    }

	@Override
	public void clear() {
		this.stacks.clear();
	}

	@Override
	public int getField(int id) {
		switch (id)
        {
            case 0:
                return this.burnTime;
            default:
                return 0;
        }
	}

	@Override
	public int getFieldCount() {
		return 1;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (this.world.getTileEntity(this.pos) != this)
        {
            return false;
        }
        else
        {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
	}

	public void openInventory(EntityPlayer player) {}
	
	public void closeInventory(EntityPlayer player) {}

	@Override
	public void setField(int index, int value) {
		switch (index) {
			case 0:
	            this.burnTime = value;
	            break;
		}
		
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.kinematica." + name;
	}
	
	@Override
	public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }
	
	public void setCustomInventoryName(String name) {
        this.customName = name;
    }


	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return true;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack stack, EnumFacing facing) {
		return isItemValidForSlot(index, stack);
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return null;
	}   
	
	@Override
	public void update() {}
	
	 public ITextComponent getDisplayName() {
		 return (ITextComponent)(this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
	 }

	@Override
	public void setInventorySlotContents(int arg0, ItemStack arg1) {
		// TODO Auto-generated method stub
		
	}

}
