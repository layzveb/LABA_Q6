package Client.Commands;

import Client.ClientTool;
import Controller.CommandWithSpaceMarine;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;

public class Insert extends AbstractCommand implements CommandWithSpaceMarine {

    private ClientTool clientTool;
    public Insert(ClientTool clientTool) {
        super("insert", " [id] добавить новый элемент с заданным ключом");
        this.clientTool = clientTool;
    }

    @Override
    public String execute(Object arg) {
        return null;
    }
}

