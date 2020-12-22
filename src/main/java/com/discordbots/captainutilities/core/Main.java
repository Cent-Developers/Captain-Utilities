package com.discordbots.captainutilities.core;

import com.discordbots.captainutilities.commands.Ping;
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

        System.out.println("Started Bot! Bot is in " + Client.getServers() + " servers!");
        System.out.println("Loading listeners: " + Client.getListeners());

        Client.addListener(new Ping());
        System.out.println("Loaded listeners, Ready!");
    }
}
