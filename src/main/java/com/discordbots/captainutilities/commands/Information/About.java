package com.discordbots.captainutilities.commands.Information;

import com.discordbots.captainutilities.core.Main;
import com.discordbots.captainutilities.util.CommandAccessLevel;
import com.discordbots.captainutilities.util.ICommand;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class About implements MessageCreateListener, ICommand
{
    String CommandName = "**about**";
    String Description = "Displays info about the bot.";
    String Usage = "`>about`";
    CommandAccessLevel commandAccessLevel = CommandAccessLevel.USER;

    @Override
    public String HelpCommandVar()
    {
        return CommandName + "- " + Description + "\nUsage- " + Usage + "\nAccessLevel - " + commandAccessLevel;
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
        long CurrentTime = System.currentTimeMillis();
        long elapsedTime = CurrentTime - Main.TimeAtStart;
        String FormattedElapsedTime = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(elapsedTime),
                TimeUnit.MILLISECONDS.toMinutes(elapsedTime) -
                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedTime)),
                TimeUnit.MILLISECONDS.toSeconds(elapsedTime) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime)));

        int MaxEvaluationTime = 10;
        int MinEvaluationTime = 2;
        int EvaluationTime = (int)(Math.random() * (MaxEvaluationTime - MinEvaluationTime + 1)) + MinEvaluationTime;

        return new EmbedBuilder()
                .setTitle("**About  Captain-Utilities**")
                .setDescription("I am a bot created by <@518382491338539017>, I am a very good Utility Bot to use in your server!\nMy source code is available on [Github](https://github.com/Cent-Developers/Captain-Utilities)! consider helping me ? I'd be thankful :)")
                .addField("**Invite Link**", "if you want to use me in your server click [here](" + message.getApi().createBotInvite() + ")")
                .addField("Statistics", "`Time online` - " + FormattedElapsedTime + "\n`Servers` - " + message.getApi().getServers().size(), false)
                .addField("**Current Ping:**", "`Gateway Latency` - " + message.getApi().getLatestGatewayLatency().toMillis() + "\n`Evaluation time` - " + EvaluationTime, true)
                .setAuthor(message.getMessageAuthor().getDisplayName(), null, message.getMessageAuthor().getAvatar())
                .setThumbnail(ClassLoader.getSystemResourceAsStream("Logo.png"))
                .setColor(AboutEmbedColor);

    }
}
