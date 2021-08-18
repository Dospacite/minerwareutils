package dospacite.minerwareutils.mixin;

import dospacite.minerwareutils.events.MinerwareTitleEvent;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(IngameGui.class)
public class MixinTitlePopupEvent {

    /**
     * Mixes in to renderTitles in IngameGui and posts a title event.
     * @param title, the title.
     * @param subtitle, the subtitle.
     * @param p_238452_3_, unknown.
     * @param p_238452_4_, unknown.
     * @param p_238452_5_, unknown.
     * @param ci, callback info.
     */
    @Inject(at=@At("HEAD"),
            method = "renderTitles(Lnet/minecraft/util/text/ITextComponent;Lnet/minecraft/util/text/ITextComponent;III)V",
            cancellable = true)
    public void onStartSection(ITextComponent title, ITextComponent subtitle, int p_238452_3_, int p_238452_4_, int p_238452_5_, CallbackInfo ci) {
        // Make new title event and post it on the forge event bus.
        MinerwareTitleEvent event = new MinerwareTitleEvent(title, subtitle);
        MinecraftForge.EVENT_BUS.post(event);

        // Cancel rendering if event is cancelled.
        if(event.isCanceled()) {
            ci.cancel();
        }
    }
}
