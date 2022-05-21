package social.northernside.vpt.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import social.northernside.vpt.VersionPortTest;
import social.northernside.vpt.utils.VenadePlayer;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);

        VenadePlayer player = new VenadePlayer(event.getPlayer());
        player.getBukkitPlayer().sendMessage("casa blanca");
        player.spawn();

        VersionPortTest.getInstance().getVenadePlayers().put(player.getBukkitPlayer().getUniqueId(), player);
    }
}
