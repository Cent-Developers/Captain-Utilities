package com.discordbots.captainutilities.commands.Information;

import com.discordbots.captainutilities.util.CommandAccessLevel;
import com.discordbots.captainutilities.util.ICommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PingTest
{
    @Test
    void CheckIfAllAttributesAreCorrect()
    {
        Ping ping = new Ping();
        //Name check
        Assertions.assertEquals("**Ping**", ping.CommandName);
        //Description Check
        assertEquals("Tells the latency of the bot in ms", ping.Description);
        //Usage Check
        assertEquals("`>Ping`", ping.Usage);
        //Access level check
        assertEquals(CommandAccessLevel.USER, ping.commandAccessLevel);
    }
}