package listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class RollHandler extends ListenerAdapter {

    private Random rand = new Random();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || !event.getMessage().getContentRaw().startsWith("$")) {
            return;
        }
        String command = event.getMessage().getContentRaw().substring(1);
        if (command.startsWith("roll")) {
            String[] args = command.split(" ");
            if (args.length <= 1) {
                event.getChannel().sendMessage("You must provide a number! ($roll 20)").queue();
                return;
            }
            int roll = getRandomNumber(Integer.parseInt(args[1]));
            event.getChannel().sendMessage("You rolled a " + roll + "!").queue();
        }
    }

    private int getRandomNumber(int max) {
        return rand.nextInt((max-1) + 1) + 1;
    }
}
