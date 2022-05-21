package social.northernside.vpt.utils;

import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftChatMessage;

public class VenadeTitle {
    private String titleString;
    private String subtitleString;
    private int fadeIn;
    private int stay;
    private int fadeOut;

    public VenadeTitle(String titleString, String subtitleString, int fadeIn, int stay, int fadeOut) {
        this.titleString = titleString;
        this.subtitleString = subtitleString;
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    public void sendTitle(VenadePlayer player) {
        PacketPlayOutTitle times;
        if (this.titleString != null) {
            times = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, CraftChatMessage.fromString(titleString)[0]);
            ((CraftPlayer) player.getBukkitPlayer()).getHandle().playerConnection.sendPacket(times);
        }

        if (this.subtitleString != null) {
            times = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, CraftChatMessage.fromString(subtitleString)[0]);
            ((CraftPlayer) player.getBukkitPlayer()).getHandle().playerConnection.sendPacket(times);
        }

        times = new PacketPlayOutTitle(fadeIn, stay, fadeOut);
        ((CraftPlayer) player.getBukkitPlayer()).getHandle().playerConnection.sendPacket(times);
    }
}
