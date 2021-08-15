package dev.tuca;

import dev.tuca.manager.RegisterManager;
import dev.tuca.model.FuturaBOT;
import dev.tuca.storage.SQLConnection;
import dev.tuca.storage.SQLProvider;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

public class FuturaVoiceChannels extends JavaPlugin {

    private FuturaBOT futuraBOT;
    private SQLConnection connection;

    @SneakyThrows
    @Override
    public void onEnable() {
        this.connection = new SQLConnection();
        SQLProvider provider = new SQLProvider();
        RegisterManager registerManager = new RegisterManager(provider);
        this.futuraBOT = new FuturaBOT(registerManager);

    }

    @Override
    public void onDisable() {
        connection.closeConnection();
        futuraBOT.stop();
    }

}
