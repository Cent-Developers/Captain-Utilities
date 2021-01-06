package com.discordbots.captainutilities.commands.Information;

import com.discordbots.captainutilities.util.CommandAccessLevel;
import com.discordbots.captainutilities.util.ICommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AboutTest
{

    @Test
    void CheckAboutAttributes()
    {
        About about = new About();
        //name check
        assertEquals("**about**", about.CommandName);
        //Description check
        assertEquals("Displays info about the bot.", about.Description);
        //Usage Check
        assertEquals("`>about`", about.Usage);
        //Access level check
        assertEquals(CommandAccessLevel.USER, about.commandAccessLevel);
    }
}