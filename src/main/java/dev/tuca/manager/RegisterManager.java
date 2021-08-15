package dev.tuca.manager;

import dev.tuca.storage.SQLProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterManager {

    private final SQLProvider provider;

    public String getPlayerOfDiscordID(String discordID) {
        return provider.query(
                "select player from registro where discordID=?",
                set -> set.getString("player"),
                discordID
        ).orElse("Inexistente");
    }
}