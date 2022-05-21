package social.northernside.vpt.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import social.northernside.vpt.utils.VenadePlayer;

public class PlayerToggleSneakListener implements Listener {
    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        if (!event.isSneaking())
            return;

        VenadePlayer player = PlayerJoinListener.venadePlayers.get(event.getPlayer().getUniqueId());
        player.incrementSneakCount();
        player.updateScoreboard();
    }
}
