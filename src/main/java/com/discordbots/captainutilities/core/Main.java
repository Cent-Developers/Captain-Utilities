package com.discordbots.captainutilities.core;

import com.discordbots.captainutilities.commands.help.Help;
import com.discordbots.captainutilities.commands.Information.About;
import com.discordbots.captainutilities.commands.Information.Ping;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.util.Arrays;


public class Main
{
    public static final String Prefix = System.getenv().get("PREFIX");

    public static void main(String[] args)
    {
        String Token = System.getenv().get("TOKEN");

        System.out.println("Starting Bot....");

        DiscordApi Client = new DiscordApiBuilder().setToken(Token).login().join();

        System.out.println("Bot Online, Loading resources");

        Client.addListener(new Ping());
        Client.addListener(new Help());
        Client.addListener(new About());

        System.out.println("Loading listeners: " + Arrays.stream(Client.getListeners().values().toArray()).count());
        System.out.println("Loaded listeners");
        System.out.println("Loading resources...");
        System.out.println("Loaded resources! Ready for operation!");

    }
}
