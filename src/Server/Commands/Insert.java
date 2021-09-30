package Server.Commands;

import Controller.Collection;
import Controller.CommandWithArg;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;

public class Insert extends AbstractCommand implements CommandWithArg {

    public Insert() {
        super("insert", " [id] добавить новый элемент с заданным ключом");
    }

    @Override
    public String execute(Object arg) {
        try {
            int id = Integer.parseInt((String) arg);
            if (Collection.isKeyFree(id)) {
                SpaceMarine spaceMarine = SpaceMarineGenerator.generate();
                spaceMarine.setId(id);
                Collection.insert(id, spaceMarine);

                return "Космический корабль залетел в коллекцию.";
            } else return "Космический корабль с указанным id же существует.";

        } catch (NumberFormatException e) {
            return "Аргумент команды должен быть типа \"int\"";
        } catch (NullPointerException e) {
            return "Неверно указаны данные.";
        }
    }
}

