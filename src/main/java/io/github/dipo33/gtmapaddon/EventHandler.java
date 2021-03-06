package io.github.dipo33.gtmapaddon;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import io.github.dipo33.gtmapaddon.command.MinedCommand;
import io.github.dipo33.gtmapaddon.network.SyncMinedChunksMessage;
import net.minecraft.entity.player.EntityPlayerMP;

public class EventHandler {

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        final SyncMinedChunksMessage message = new SyncMinedChunksMessage(MinedCommand.MINED_CHUNKS_STORAGE);
        GTMapAddonMod.NETWORK_CHANNEL.sendTo(message, (EntityPlayerMP) event.player);
    }
}
