package social.northernside.vpt.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import social.northernside.vpt.utils.VenadePlayer;

import java.util.HashMap;
import java.util.UUID;

public class PlayerJoinListener implements Listener {
    public static HashMap<UUID, VenadePlayer> venadePlayers = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);

        VenadePlayer player = new VenadePlayer(event.getPlayer());
        player.getBukkitPlayer().sendMessage("casa blanca");
        player.spawn();

        venadePlayers.put(player.getBukkitPlayer().getUniqueId(), player);
    }
}
