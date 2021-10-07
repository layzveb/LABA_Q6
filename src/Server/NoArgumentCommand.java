package Server;

import CommonObjects.UniversalObjectToSend;
import Server.Commands.AbstractCommand;

import java.io.Serializable;

public class NoArgumentCommand extends UniversalObjectToSend implements Serializable {

    private String commandName;

    public NoArgumentCommand(String command) {
        this.commandName = command;
    }
}
