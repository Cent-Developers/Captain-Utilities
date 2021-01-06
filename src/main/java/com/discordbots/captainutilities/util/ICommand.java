package com.discordbots.captainutilities.util;

public interface ICommand
{
    //This interface contains few variables that helps us setup the help command
    String CommandName = "";
    String Description = "";
    String Usage = "";
    CommandAccessLevel commandAccessLevel = CommandAccessLevel.USER;

    String HelpCommandVar();

}
