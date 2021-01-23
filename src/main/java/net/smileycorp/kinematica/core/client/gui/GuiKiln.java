package net.smileycorp.kinematica.core.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityKiln;

@SideOnly(Side.CLIENT)
public class GuiKiln extends GuiContainer {
	
	protected static final ResourceLocation guiTexture = 
			ModDefinitions.getResource("textures/gui/container/kiln.png");
	 private final InventoryPlayer inventory;
	    private final IInventory tile;

	    public GuiKiln(InventoryPlayer inventory, IInventory tile, Container container)
	    {
	        super(container);
	        this.inventory = inventory;
	        this.tile = tile;
	    }

	    /**
	     * Draws the screen and all the components in it.
	     */
	    public void drawScreen(int mouseX, int mouseY, float partialTicks)
	    {
	        this.drawDefaultBackground();
	        super.drawScreen(mouseX, mouseY, partialTicks);
	        this.renderHoveredToolTip(mouseX, mouseY);
	    }

	    /**
	     * Draw the foreground layer for the GuiContainer (everything in front of the items)
	     */
	    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	    {
	        String s = this.tile.getDisplayName().getUnformattedText();
	        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
	        this.fontRenderer.drawString(this.inventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	    }

	    /**
	     * Draws the background layer of this container (behind the items).
	     */
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
	            this.drawTexturedModalRect(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
	        }

	        int l = this.getCookProgressScaled(24);
	        this.drawTexturedModalRect(i + 79, j + 34, 176, 14, l + 1, 16);
	    }

	    private int getCookProgressScaled(int pixels)
	    {
	        int i = this.tile.getField(2);
	        int j = this.tile.getField(3);
	        return j != 0 && i != 0 ? i * pixels / j : 0;
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