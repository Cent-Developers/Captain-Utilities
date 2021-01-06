package com.discordbots.captainutilities.commands.Utilities;

import com.discordbots.captainutilities.util.CommandAccessLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InviteTest
{
    @Test
    void CheckAttributes()
    {
        Invite invite = new Invite();
        //Name check
        Assertions.assertEquals("**Invite**", invite.CommandName);
        //Description Check
        assertEquals("Shows the invite link of the bot", invite.Description);
        //Usage Check
        assertEquals("`>invite`", invite.Usage);
        //Access level check
        assertEquals(CommandAccessLevel.USER, invite.commandAccessLevel);
    }
}