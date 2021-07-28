package dospacite.minerwareutils.mixin;

import dospacite.minerwareutils.MinerwareUtils;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.IPacket;
import net.minecraft.network.NetworkManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinTest {

    @Inject(at=@At("HEAD"),
            method = "Lnet/minecraft/network/NetworkManager;sendPacket(Lnet/minecraft/network/IPacket;Lio/netty/util/concurrent/GenericFutureListener;)V",
            cancellable = true)
    public void onPacketSent(IPacket<?> packetIn, GenericFutureListener<? extends Future<? super Void>> p_201058_2_, CallbackInfo ci) {
        MinerwareUtils.LOGGER.debug("Reached Test Mixin.");

    }
}
