package Client.Commands;

import Controller.Collection;
import Controller.CommandWithArg;
import SpaceMarine.SpaceMarine;

import java.util.Map;

public class Remove_key extends AbstractCommand implements CommandWithArg {

    public Remove_key() {
        super("remove_key", " [id] удаление элемента из коллекции по его ключу");
    }

    @Override
    public String execute(Object arg) {
            return null;
    }
}

