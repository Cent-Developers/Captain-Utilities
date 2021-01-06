package com.discordbots.captainutilities.commands.help;

import com.discordbots.captainutilities.commands.Information.About;
import com.discordbots.captainutilities.commands.Information.Ping;
import com.discordbots.captainutilities.commands.Utilities.Invite;
import com.discordbots.captainutilities.core.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class Help implements MessageCreateListener
{
    private final String PingHelpInfo = new Ping().HelpCommandVar();
    private final String AboutHelpInfo = new About().HelpCommandVar();
    private final String InviteHelpInfo = new Invite().HelpCommandVar();

    @Override
    public void onMessageCreate(MessageCreateEvent message)
    {
        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "help"))
        {
            message.getChannel().sendMessage(CreateHelpEmbed(message));
        }
    }

    public EmbedBuilder CreateHelpEmbed(MessageCreateEvent message)
    {
        Color EmbedColor = new Color(0, 189, 201);

        return new EmbedBuilder()
                .setTitle("**Help:**")
                .setDescription("Here you will find all the info about\n all the commands!")
                .addField(":information_source: Information:", PingHelpInfo + "\n" + AboutHelpInfo, false)
                .addField(":gear: Utility: ", InviteHelpInfo, true)
                .setFooter("Prefix is: " + Main.Prefix, message.getMessageAuthor().getAvatar())
                .setThumbnail(ClassLoader.getSystemResourceAsStream("Logo.png"))
                .setColor(EmbedColor);
        //TODO: Revamp help command
    }
}
