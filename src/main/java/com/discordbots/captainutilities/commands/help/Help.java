package com.discordbots.captainutilities.commands.help;

import com.discordbots.captainutilities.commands.technical.Ping;
import com.discordbots.captainutilities.core.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class Help implements MessageCreateListener
{
    private final Ping ping = new Ping();

    private final String PingHelpInfo = ping.HelpCommandVar();

    @Override
    public void onMessageCreate(MessageCreateEvent message)
    {
        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "Help"))
        {
            message.getChannel().sendMessage(CreateHelpEmbed(message));
        }
    }

    private EmbedBuilder CreateHelpEmbed(MessageCreateEvent message)
    {
        Color EmbedColor = new Color(0, 189, 201);

        return new EmbedBuilder()
                .setTitle("**Help:**")
                .setDescription("Here you will find all the info about\n all the commands!")
                .addField("**Technical** ⚙", PingHelpInfo, false)
                .setThumbnail(message.getMessageAuthor().getAvatar())
                .setColor(EmbedColor);
    }
}
