package app;

import config.TokenLoader;
import listeners.EventHandler;
import listeners.RollHandler;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = new TokenLoader().getToken();
        builder.setToken(token);
        builder.addEventListener(
                new EventHandler(),
                new RollHandler()
        );
        try {
            builder.buildAsync();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
