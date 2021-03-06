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
        updateScoreboard();
        VenadeTablist tablist = new VenadeTablist("Header", "Footer");
        VenadeTitle title = new VenadeTitle("Title", "Subtitle", 10, 40, 10);
        tablist.setTab(this);
        title.sendTitle(this);
    }

    public Player getBukkitPlayer() {
        return player;
    }

    public int getSneakCount() {
        return this.sneakCount;
    }

    public void incrementSneakCount() {
        this.scoreboard.getBoard().resetScores("Sneak Counter: " + sneakCount);
        this.sneakCount += 1;
        this.scoreboard.addScore("Sneak Counter: " + sneakCount, 1);
    }

    public void updateScoreboard() {
        scoreboard.updateScoreboard(player);
    }
}
