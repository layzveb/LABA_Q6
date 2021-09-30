package Client.Commands;

import Controller.Collection;
import Controller.CommandWithArg;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;

import java.util.InputMismatchException;

public class Replace_if_greater extends AbstractCommand implements CommandWithArg {

    public Replace_if_greater() {
        super("replace_if_greater", " [id] замена значения по ключу, если новое значение больше старого");
    }

    @Override
    public String execute(Object args) {
        try {
            if (Collection.getSize() == 0) return ("Коллекция итак пустая.");
            else {
                int arg = Integer.parseInt((String) args);
                if (!Collection.isKeyFree((arg))) {
                    SpaceMarine newSpaceMarine = SpaceMarineGenerator.generate();
                    if (Collection.getCollection().get(arg).compareTo(newSpaceMarine) < 0) {
                        newSpaceMarine.setId(arg);
                        Collection.update(arg, newSpaceMarine);
                        return "Космический корабль с id [" + arg + "] успешно заменен.";
                    } else return "Космический корабль с id [" + arg + "] не заменен.";
                } else return "Космический корабль с указанным id не найдено.";
            }
        } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"int\"");
        } catch (NullPointerException e) {
            return ("Неверно указаны данные.");
        }
    }
}


