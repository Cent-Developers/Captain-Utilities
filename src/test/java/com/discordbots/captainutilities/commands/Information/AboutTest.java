package com.discordbots.captainutilities.commands.Information;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AboutTest {

    @Test
    void CheckAboutAttributes()
    {
        About about = new About();
        assertEquals("**about**", about.CommandName);
        assertEquals("Displays info about the bot.", about.Description);
        assertEquals("`>about`", about.Usage);
    }
}