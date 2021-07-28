package dospacite.minerwareutils.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;
import dospacite.minerwareutils.MinerwareUtils;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.profiler.IProfiler;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
List of methods that I have tried that did not work:
- IngameUI;renderIngameUI | at = Head -> No Output
- IngameUI;renderTitles | at = Head -> No Output
- IProfiler;startSection | at = Head -> No Output
 */
@Mixin(IngameGui.class)
public class MixinTitlePopupEvent {
    @Inject(at=@At("HEAD"),
            method = "Lnet/minecraft/client/gui/IngameGui;renderIngameGui(Lcom/mojang/blaze3d/matrix/MatrixStack;F)V",
            cancellable = true)
    public void onStartSection(MatrixStack matrixStack, float partialTicks, CallbackInfo ci) {
        MinerwareUtils.LOGGER.debug("Reached.");
    }

}
