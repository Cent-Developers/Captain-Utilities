package com.discordbots.captainutilities.core;

import com.discordbots.captainutilities.commands.help.Help;
import com.discordbots.captainutilities.commands.technical.Ping;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main
{
    public static final String Prefix = System.getenv().get("PREFIX");

    public static void main(String[] args)
    {
        String Token = System.getenv().get("TOKEN");

        System.out.println("Starting Bot!");

        DiscordApi Client = new DiscordApiBuilder().setToken(Token).login().join();

        System.out.println("Started Bot! Bot is in " + Client.getServers().toString() + " servers!");
        System.out.println("Loading listeners: " + Client.getListeners().toString());

        Client.addListener(new Ping());
        Client.addListener(new Help());
        System.out.println("Loaded listeners, Ready!");
    }
}
