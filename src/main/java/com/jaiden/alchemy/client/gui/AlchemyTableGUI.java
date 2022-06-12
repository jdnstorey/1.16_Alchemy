package com.jaiden.alchemy.client.gui;


import com.jaiden.alchemy.Alchemy;
import com.jaiden.alchemy.common.container.AlchemyTableContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AlchemyTableGUI extends ContainerScreen<AlchemyTableContainer> {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Alchemy.MODID, "textures/gui/alchemy_table_gui.png");

    public AlchemyTableGUI(AlchemyTableContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.imageWidth = 175;
        this.imageHeight = 183;
    }

    @Override
    protected void renderBg(MatrixStack stack, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        if (this.minecraft == null) {
            return;
        }
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bind(GUI_TEXTURE);
        int startX = (this.width - this.imageWidth) / 2;
        int startY = (this.height - this.imageHeight) / 2;
        this.blit(stack, startX, startY, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }
}
