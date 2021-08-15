package dospacite.minerwareutils.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import dospacite.minerwareutils.MinerwareUtils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ConfigScreen extends Screen {

    private static final int TITLE_HEIGHT = 8;

    public ConfigScreen() {
        // Use the super class' constructor to set the screen's title
        super(new TranslationTextComponent("minerwareutils.configGui.title",
                MinerwareUtils.MOD_NAME));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        // First draw the background of the screen
        this.renderBackground(matrixStack);
        // Draw the title
        drawCenteredString(matrixStack, this.font, this.title.getString(),
                this.width / 2, TITLE_HEIGHT, 0xFFFFFF);
        // Call the super class' method to complete rendering
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}
