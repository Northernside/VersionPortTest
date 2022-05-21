package social.northernside.vpt.utils;

import org.bukkit.entity.Player;

public class VenadePlayer {
    private VenadeScoreboard scoreboard;
    private Player player;
    private int sneakCount = 0;

    public VenadePlayer(Player player) {
        this.player = player;
        this.scoreboard = new VenadeScoreboard("Venade Network");
        this.scoreboard.addScore("Sneak Counter: 0", 1);
    }

    public void spawn() {
        VenadePlayer venadePlayer = new VenadePlayer(player);
        updateScoreboard();
        player.setPlayerListHeaderFooter("Header", "Footer");
        player.sendTitle("Title", "Subtitle", 10, 40, 10);
    }

    public Player getBukkitPlayer() {
        return player;
    }

    public int getSneakCount() {
        return this.sneakCount;
    }

    public void incrementSneakCount() {
        this.scoreboard.board.resetScores("Sneak Counter: " + sneakCount);
        this.sneakCount += 1;
        this.scoreboard.addScore("Sneak Counter: " + sneakCount, 1);
    }

    public void updateScoreboard() {
        scoreboard.updateScoreboard(player);
    }
}
