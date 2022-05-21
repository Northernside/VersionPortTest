package social.northernside.vpt.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class VenadeScoreboard {
    private String displayName;

    private ScoreboardManager manager;
    private Scoreboard board;
    private Objective objective;

    public VenadeScoreboard(String displayName) {
        this.displayName = displayName;
        this.manager = Bukkit.getScoreboardManager();
        this.board = manager.getNewScoreboard();
        this.objective = board.registerNewObjective("test", "dummy");

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

    public Scoreboard getBoard() {
        return board;
    }
}
