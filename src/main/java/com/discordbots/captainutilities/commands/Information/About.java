package com.discordbots.captainutilities.commands.Information;

import com.discordbots.captainutilities.core.Main;
import com.discordbots.captainutilities.util.ICommand;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class About implements MessageCreateListener, ICommand
{
    String CommandName = "**about**";
    String Description = "Displays info about the bot.";
    String Usage = "`>about`";

    @Override
    public String HelpCommandVar()
    {
        return CommandName + "- " + Description + "Usage- " + Usage;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent message)
    {
        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "about"))
        {
            message.getChannel().sendMessage(SendEmbed(message));
        }
    }

    public EmbedBuilder SendEmbed(MessageCreateEvent message)
    {
        Color AboutEmbedColor = new Color(116, 252, 95);

        return new EmbedBuilder()
                .setTitle("**About  Captain-Utilities**")
                .setDescription("I am a bot created by <@518382491338539017>, I am a very good Utility Bot!\n My source code is available on [Github](https://github.com/Cent-Developers/Captain-Utilities)!\n Also this command is incomplete... if you have made it feel free to open a pull request")
                .setAuthor(message.getMessageAuthor().getDisplayName(), null, message.getMessageAuthor().getAvatar())
                .setColor(AboutEmbedColor);

    }
}
