package net.smileycorp.kinematica.core.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityKiln;

@SuppressWarnings("deprecation")
@SideOnly(Side.CLIENT)
public class GuiKilnFuel extends GuiContainer {
	
	protected static final ResourceLocation guiTexture = 
			ModDefinitions.getResource("textures/gui/container/multiblock_fuel.png");
	 private final InventoryPlayer inventory;
	    private final IInventory tile;

	    public GuiKilnFuel(InventoryPlayer inventory, IInventory tile, Container container)
	    {
	        super(container);
	        this.inventory = inventory;
	        this.tile = tile;
	    }

	    /**
	     * Draws the screen and all the components in it.
	     */
	    @Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks)
	    {
	        this.drawDefaultBackground();
	        super.drawScreen(mouseX, mouseY, partialTicks);
	        this.renderHoveredToolTip(mouseX, mouseY);
	    }

	    /**
	     * Draw the foreground layer for the GuiContainer (everything in front of the items)
	     */
	    @Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	    {
	        String s = this.tile.getDisplayName().getUnformattedText()+" "+I18n.translateToLocal("localisation.container.Fuel");;
	        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
	        this.fontRenderer.drawString(this.inventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	    }

	    /**
	     * Draws the background layer of this container (behind the items).
	     */
	    @Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	    {
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(guiTexture);
	        int i = (this.width - this.xSize) / 2;
	        int j = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

	        if (((TileEntityKiln)tile).isBurning())
	        {
	            int k = this.getBurnLeftScaled(13);
	            this.drawTexturedModalRect(i + 80, j + 32 - k, 176, 12 - k, 14, k + 1);
	        }
	        
	    }

	    private int getBurnLeftScaled(int pixels)
	    {
	        int i = this.tile.getField(1);

	        if (i == 0)
	        {
	            i = 200;
	        }

	        return this.tile.getField(0) * pixels / i;
	    }
	}