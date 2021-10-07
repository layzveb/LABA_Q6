package Server.Commands;

import Controller.Collection;
import Controller.CommandWithArg;
import Controller.CommandWithSpaceMarine;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;

public class Insert extends AbstractCommand implements CommandWithSpaceMarine {

    public Insert() {
        super("insert", " [id] добавить новый элемент с заданным ключом");
    }

    @Override
    public String execute(Object arg, SpaceMarine newSpaceMarine) {
        try {
            int id = Integer.parseInt((String) arg);
            if (Collection.isKeyFree(id)) {
                newSpaceMarine.setId(id);
                Collection.insert(id, newSpaceMarine);
                return "Космический корабль залетел в коллекцию.";
            } else return "Космический корабль с указанным id уже существует.";

        } catch (NumberFormatException e) {
            return "Аргумент команды должен быть типа \"int\"";
        } catch (NullPointerException e) {
            return "Неверно указаны данные.";
        }
    }
}

