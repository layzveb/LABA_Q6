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
        try {
            if (Collection.getSize() == 0) return ("Коллекция и так пустая.");
            else {
                for (Map.Entry<Integer, SpaceMarine> entry : Collection.getCollection().entrySet())
                    if (entry.getKey() == Integer.parseInt((String) arg)) {
                        Collection.remove(entry.getKey());
                        return ("Космический корабль с id[" + arg + "] успешно удален.");
                    }
                return ("Космический корабль с указанным id не найден.");
            }
        } catch (NumberFormatException e) {
            return ("Аргумент команды должен быть типа \"int\"");
        }
    }
}

