package Server;

import Server.Commands.AbstractCommand;
import CommonObjects.UniversalObjectToSend;
import SpaceMarine.SpaceMarine;

import java.io.Serializable;

public class SpaceMarineCommand extends UniversalObjectToSend implements Serializable {
    private String commandName;
    private SpaceMarine spaceMarine;
    private String stringArgument;

    public SpaceMarineCommand(String command, SpaceMarine spaceMarine, String stringArgument) {
        this.commandName = command;
        this.spaceMarine = spaceMarine;
        this.stringArgument = stringArgument;
    }
}
