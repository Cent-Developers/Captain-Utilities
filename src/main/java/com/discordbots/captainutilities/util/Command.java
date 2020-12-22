package com.discordbots.captainutilities.util;

public interface Command
{
    //This interface contains few variables that helps us setup the help command
    String CommandName = "";
    String Description = "";
    String Usage = "";

    String HelpCommandVar();

}
