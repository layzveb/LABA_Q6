package Client;

import CommonObjects.UniversalObjectToSend;
import Client.Commands.AbstractCommand;

import java.io.Serializable;

public class ArgumentCommand extends UniversalObjectToSend implements Serializable {
    private String commandName;
    private String stringArgument;

    public ArgumentCommand(String command, String stringArgument) {
        this.commandName = command;
        this.stringArgument = stringArgument;
    }
}
