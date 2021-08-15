package dev.tuca.listener;

import dev.tuca.manager.RegisterManager;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class JoinChannelListener extends ListenerAdapter {

    private final RegisterManager registerManager;

    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        String ownerName = registerManager.getPlayerOfDiscordID(event.getMember().getId());
        if (!ownerName.equals("Inexistente")) {
            Player player = Bukkit.getPlayer(ownerName);

            if (player != null || player.isOnline()) {
                ArmorStand as = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
                as.setPassenger(player);
                as.setCustomName("Olá");
                as.setCustomNameVisible(true);
            }
        }
    }
}
