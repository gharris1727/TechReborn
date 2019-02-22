/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2018 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import reborncore.client.gui.builder.widget.GuiButtonSimple;
import techreborn.tiles.TileChunkLoader;

public class GuiChunkLoader extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation("techreborn",
		"textures/gui/industrial_chunkloader.png");
	TileChunkLoader chunkloader;
	private GuiButton plusOneButton;
	private GuiButton plusTenButton;
	private GuiButton minusOneButton;
	private GuiButton minusTenButton;

	public GuiChunkLoader(final EntityPlayer player, final TileChunkLoader chunkLoader) {
		super(chunkLoader.createContainer(player));
		this.xSize = 176;
		this.ySize = 167;
		this.chunkloader = chunkLoader;
	}

	@Override
	public void initGui() {
		super.initGui();
		this.guiLeft = this.width / 2 - this.xSize / 2;
		this.guiTop = this.height / 2 - this.ySize / 2;
		this.plusOneButton = new GuiButtonSimple(0, this.guiLeft + 5, this.guiTop + 37, 40, 20, "+1");
		this.plusTenButton = new GuiButtonSimple(0, this.guiLeft + 45, this.guiTop + 37, 40, 20, "+10");

		this.minusOneButton = new GuiButtonSimple(0, this.guiLeft + 90, this.guiTop + 37, 40, 20, "-1");
		this.minusTenButton = new GuiButtonSimple(0, this.guiLeft + 130, this.guiTop + 37, 40, 20, "-10");

		this.buttons.add(this.plusOneButton);
		this.buttons.add(this.plusTenButton);
		this.buttons.add(this.minusOneButton);
		this.buttons.add(this.minusTenButton);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(final float p_146976_1_, final int p_146976_2_, final int p_146976_3_) {
		this.drawDefaultBackground();
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiChunkLoader.texture);
		final int k = (this.width - this.xSize) / 2;
		final int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(final int p_146979_1_, final int p_146979_2_) {
		final String name = I18n.format("tile.techreborn:chunk_loader.name");
		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6,
			4210752);
		this.fontRenderer.drawString(I18n.format("container.inventory", new Object[0]), 8,
			this.ySize - 96 + 2, 4210752);
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

}
