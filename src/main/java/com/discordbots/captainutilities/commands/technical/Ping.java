package com.discordbots.captainutilities.commands.technical;

import com.discordbots.captainutilities.core.Main;
import com.discordbots.captainutilities.util.Command;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;


public class Ping implements MessageCreateListener, Command
{
    public static final String CommandName = "Ping";
    public static final String Description = "Tells the latency of the bot in ms";
    public static final String Usage = "`!Ping`";

    @Override
    public void onMessageCreate(MessageCreateEvent message)
    {
        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "ping"))
        {
            message.getChannel().sendMessage(CreatePingEmbed(message));
        }
    }

    @Override
    public String HelpCommandVar()
    {
        return CommandName + "- " + Description + " Usage- " + Usage;
    }

    private EmbedBuilder CreatePingEmbed(MessageCreateEvent message)
    {
        Color PingEmbedColor = new Color(29, 233, 182);
        String GatewayLatency = message.getApi().getLatestGatewayLatency().toString();
        String RESTLatency = message.getApi().measureRestLatency().toString();

        int GatewayLatencyInt = Integer.parseInt(GatewayLatency);
        int RESTLatencyInt = Integer.parseInt(RESTLatency);

        int AverageLatency = GatewayLatencyInt/2 + RESTLatencyInt/2;

        return new EmbedBuilder()
                .setTitle("**Latency of the bot:** ")
                .setDescription("This says the current latency of the bot:")
                .addField("Average latency: ", AverageLatency + "ms", false)
                .addField("Gateway latency: ", GatewayLatency + "ms", false)
                .addField("REST latency:", RESTLatency + "ms", false)
                .setFooter("You really shouldn't care about this, unless you know what it means!")
                .setThumbnail(message.getMessageAuthor().getAvatar())
                .setColor(PingEmbedColor);
    }
}
