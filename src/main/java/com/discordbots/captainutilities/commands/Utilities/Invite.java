package com.discordbots.captainutilities.commands.Utilities;

import com.discordbots.captainutilities.core.Main;
import com.discordbots.captainutilities.util.CommandAccessLevel;
import com.discordbots.captainutilities.util.ICommand;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class Invite implements MessageCreateListener, ICommand
{
    String CommandName = "**Invite**";
    String Description = "Shows the invite link of the bot";
    String Usage = "`>invite`";
    CommandAccessLevel commandAccessLevel = CommandAccessLevel.USER;

    @Override
    public String HelpCommandVar()
    {
        return CommandName + "- " + Description + "\n Usage- " + Usage + "\nAccessLevel - " + commandAccessLevel;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent message)
    {
        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "invite"))
        {
            message.getChannel().sendMessage(SendEmbed(message));
        }
    }

    private EmbedBuilder SendEmbed(MessageCreateEvent message)
    {
        Color EmbedColor = new Color(94, 255, 214);

        return new EmbedBuilder()
                .setTitle("**Invite Link**")
                .setDescription("To invite me into your server, click [here]("+ message.getApi().createBotInvite() + ")" + "\nTo access my source code click [here](https://github.com/Cent-Developers/Captain-Utilities)")
                .setAuthor(message.getMessageAuthor().getDisplayName(), null, message.getMessageAuthor().getAvatar())
                .setColor(EmbedColor)
                .setThumbnail(ClassLoader.getSystemResourceAsStream("Logo.png"));
    }
}
