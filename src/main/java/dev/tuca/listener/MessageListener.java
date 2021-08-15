package dev.tuca.listener;

import dev.tuca.manager.RegisterManager;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@RequiredArgsConstructor
public class MessageListener extends ListenerAdapter {

    private final RegisterManager registerManager;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        if(event.getMessage().getAuthor().isBot()) return;
        channel.sendMessage(registerManager.getPlayerOfDiscordID(event.getMessage().getAuthor().getId())).queue();
    }
}

