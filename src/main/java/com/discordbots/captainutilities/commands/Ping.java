package com.discordbots.captainutilities.commands;

import com.discordbots.captainutilities.core.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class Ping implements MessageCreateListener
{

    @Override
    public void onMessageCreate(MessageCreateEvent message)
    {
        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "ping"))
        {
            message.getChannel().sendMessage("Pong!");
        }
    }
}
