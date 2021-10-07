package Client;

import Client.Commands.AbstractCommand;
import SpaceMarine.SpaceMarine;

import java.io.Serializable;

public class CommandKicker implements Serializable {
    private static final long serialVersionUID = 777L;

    private AbstractCommand command;
    private String commandArg;
    private SpaceMarine spaceMarine;

    public CommandKicker(AbstractCommand command, String commandArg) {
        this.command = command;
        this.commandArg = commandArg;
    }

    public AbstractCommand getActualCommand() {
        return command;
    }
    
    public String getCommandArg() {
        return commandArg;
    }

    public void setCommandArg(String commandArg) {
        this.commandArg = commandArg;
    }

    public void setSpaceMarine(SpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }
    
    public SpaceMarine getSpaceMarine() {
        return spaceMarine;
    }
}
