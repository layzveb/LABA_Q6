package Server.Commands;

import Controller.Collection;
import Controller.CommandWithArg;
import Controller.CommandWithSpaceMarine;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;

import java.util.InputMismatchException;

public class Update extends AbstractCommand implements CommandWithSpaceMarine {

    public Update() {
        super("update", "[id] обновление значения элемента коллекции, id которого равен заданному");
    }

    @Override
    public String execute(Object arg, SpaceMarine newSpaceMarine) {
        try {
            int id = Integer.parseInt(String.valueOf(arg));
            if (!Collection.isKeyFree(id)) {
                newSpaceMarine.setId(id);
                Collection.update(id, newSpaceMarine);
                return ("Космический корабль с id [" + arg + "] успешно обновлен.");
            } else return ("Космический корабль с указанным id не найден.");
        } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"int\"");
        } catch (NullPointerException e) {
            return ("Неверно указаны данные.");
        }
    }
}

