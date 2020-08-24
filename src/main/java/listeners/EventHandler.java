package listeners;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventHandler extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || !event.getMessage().getContentRaw().startsWith("$")) {
            return;
        }
        String command = event.getMessage().getContentRaw().substring(1);
        switch (command) {
            case "ping":
                event.getChannel().sendMessage("Pong!").queue();
                break;
            case "hello":
                event.getChannel().sendMessage("Hey there!").queue();
                break;
        }
    }
}
