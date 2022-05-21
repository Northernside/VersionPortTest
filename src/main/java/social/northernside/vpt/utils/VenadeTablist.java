package social.northernside.vpt.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

import java.lang.reflect.Field;

public class VenadeTablist {
    private String headerText;
    private String footerText;

    public VenadeTablist(String headerText, String footerText) {
        this.headerText = headerText;
        this.footerText = footerText;
    }

    public void setTab(VenadePlayer player) {
        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
        IChatBaseComponent header = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + this.headerText.replace('&', '§') + "\"}");
        IChatBaseComponent footer = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + this.footerText.replace('&', '§') + "\"}");

        try {
            Field a = packet.getClass().getDeclaredField("a");
            a.setAccessible(true);
            a.set(packet, header);

            Field b = packet.getClass().getDeclaredField("b");
            b.setAccessible(true);
            b.set(packet, footer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ((CraftPlayer) player.getBukkitPlayer()).getHandle().playerConnection.sendPacket(packet);
    }
}
