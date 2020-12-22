import com.discordbots.captainutilities.commands.technical.Ping;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PingTest
{
    @Test
    void CheckIfAllAttributesAreCorrect()
    {
        //Name check
        Assertions.assertEquals("Ping", Ping.CommandName);
        //Description Check
        assertEquals("Tells the latency of the bot in ms", Ping.Description);
        //Usage Check
        assertEquals("`>Ping`", Ping.Usage);
    }
}