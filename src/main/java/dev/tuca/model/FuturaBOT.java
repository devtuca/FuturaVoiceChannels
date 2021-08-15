package dev.tuca.model;

import dev.tuca.listener.JoinChannelListener;
import dev.tuca.listener.MessageListener;
import dev.tuca.manager.RegisterManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class FuturaBOT {

    private JDA jda;

    public FuturaBOT(RegisterManager registerManager) throws LoginException {
        this.jda = JDABuilder.createDefault("NTkxNzA2NDM1MTMwMzU5ODIw.XQ0rjw.v7uNULmLSPgfd-FPNZccPUdMNfQ").build();
        jda.addEventListener(new MessageListener(registerManager));
        jda.addEventListener(new JoinChannelListener(registerManager));

    }

    public void stop() {
        jda.shutdown();
    }


}
