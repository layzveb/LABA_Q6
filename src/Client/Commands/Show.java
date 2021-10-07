package Client.Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import SpaceMarine.SpaceMarine;

import java.util.Map;

public class Show extends AbstractCommand implements CommandWithoutArg{

    public Show() {
        super("show", "вывод всех элементов коллекции");
    }

    @Override
    public String execute(Object o) {
        return null;
    }
}
