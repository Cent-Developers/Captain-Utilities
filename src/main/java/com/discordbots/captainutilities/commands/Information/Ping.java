package com.discordbots.captainutilities.commands.Information;

import com.discordbots.captainutilities.core.Main;
import com.discordbots.captainutilities.util.CommandAccessLevel;
import com.discordbots.captainutilities.util.ICommand;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


public class Ping implements MessageCreateListener, ICommand
{
    String CommandName = "**Ping**";
    String Description = "Tells the latency of the bot in ms";
    String Usage = "`>Ping`";

    CommandAccessLevel commandAccessLevel = CommandAccessLevel.USER;

    @Override
    public void onMessageCreate(MessageCreateEvent message)
    {
        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "ping"))
        {
            SendEmbed(message);
        }
    }

    @Override
    public String HelpCommandVar()
    {
        return CommandName + "- " + Description + "\n Usage- " + Usage + "\nAccessLevel - " + commandAccessLevel;
    }

    private void SendEmbed(MessageCreateEvent message)
    {
        Color PingEmbedColor = new Color(255, 0, 0);
        long GatewayLatency = message.getApi().getLatestGatewayLatency().toMillis();
        CompletableFuture<Void> RESTLatency = message.getApi().measureRestLatency().thenAccept(Time -> {
            EmbedBuilder InitialPing = new EmbedBuilder()
                    .setTitle("**Testing Ping... :ping_pong:**")
                    .setColor(PingEmbedColor)
                    .setFooter("", message.getMessageAuthor().getAvatar());

            EmbedBuilder PingEmbed = new EmbedBuilder()
                    .setTitle("**Latency of the bot:** ")
                    .setDescription("**Pong!** :ping_pong:")
                    .addField("Gateway latency: ", GatewayLatency + "ms", false)
                    .addField("REST latency:",  Time.toMillis() + "ms", false)
                    .setFooter("You really shouldn't care about this, unless you know what it means!", message.getMessageAuthor().getAvatar())
                    .setColor(PingEmbedColor);

            message.getChannel().sendMessage(InitialPing).thenAccept(MessageToBeEdited -> MessageToBeEdited.getApi().getThreadPool().getScheduler().schedule(() -> {
                MessageToBeEdited.edit(PingEmbed);
            }, 2, TimeUnit.SECONDS));
        });
    }
}
