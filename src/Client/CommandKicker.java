package Client;

import Client.Commands.AbstractCommand;

import java.io.Serializable;

public class CommandKicker implements Serializable {
    private static final long serialVersionUID = 777L;

    private AbstractCommand command;
    private String commandArg;

    public CommandKicker(AbstractCommand command, String commandArg) {
        this.command = command;
        this.commandArg = commandArg;
    }

    public AbstractCommand getActualCommand() {
        return command;
    }

    public void setCommandName(AbstractCommand commandName) {
        this.command = commandName;
    }

    public String getCommandArg() {
        return commandArg;
    }

    public void setCommandArg(String commandArg) {
        this.commandArg = commandArg;
    }


}
