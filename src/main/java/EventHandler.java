import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class EventHandler extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        System.out.println("Message receieved from " + event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());
        if (event.getMessage().getContentRaw().equals("!ping")) {
            event.getChannel().sendMessage("Pong!").queue();
        }
    }
}
