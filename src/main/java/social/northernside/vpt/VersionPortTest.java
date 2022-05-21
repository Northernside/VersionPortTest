package social.northernside.vpt;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import social.northernside.vpt.listeners.PlayerJoinListener;
import social.northernside.vpt.listeners.PlayerToggleSneakListener;
import social.northernside.vpt.utils.VenadePlayer;

import java.util.HashMap;
import java.util.UUID;

public class VersionPortTest extends JavaPlugin {
    private static VersionPortTest instance;

    public HashMap<UUID, VenadePlayer> venadePlayers = new HashMap<>();

    public HashMap<UUID, VenadePlayer> getVenadePlayers() {
        return venadePlayers;
    }

    @Override
    public void onEnable() {
        VersionPortTest.instance = this;

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerToggleSneakListener(), this);

        // getCommand("example").setExecutor(new ExampleCommand());

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player gop : Bukkit.getOnlinePlayers()) {
                    VenadePlayer player = getVenadePlayers().get(gop.getUniqueId());
                    player.updateScoreboard();
                }
            }
        }.runTaskTimer(this, 0, 20);
    }

    @Override
    public void onDisable() {}

    public static VersionPortTest getInstance() {
        return instance;
    }
}
