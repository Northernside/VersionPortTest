package social.northernside.vpt.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class VenadeScoreboard {
    public String displayName;

    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = manager.getNewScoreboard();
    Objective objective = board.registerNewObjective("test", "dummy");

    public VenadeScoreboard(String displayName) {
        this.displayName = displayName;
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(displayName);
    }

    public void addScore(String scoreName, int scoreNumber) {
        Score score = objective.getScore(scoreName);
        score.setScore(scoreNumber);
    }

    public void updateScoreboard(Player player) {
        player.setScoreboard(board);
    }
}
