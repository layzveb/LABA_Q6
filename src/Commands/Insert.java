package Commands;

import Controller.Collection;
import Controller.CommandWithObject;
import Exceptions.WrongCommandFormat;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;

import java.util.InputMismatchException;

public class Insert extends AbstractCommand {

    public Insert() {
        super("insert", " [id] добавить новый элемент с заданным ключом");
    }

    @Override
    public String execute(Object arg) {
        try {
            if (!arg.equals("")) {
                int id = Integer.parseInt((String) arg);
                if (Collection.isKeyFree(id)) {
                    SpaceMarine spaceMarine = SpaceMarineGenerator.generate();
                    spaceMarine.setId(id);

                    Collection.insert(id, spaceMarine);

                    return "Космический корабль залетел в коллекцию.";
                } else return "Космический корабль с указанным id же существует.";
            } else throw new WrongCommandFormat();
        } catch (NumberFormatException e) {
            return "Аргумент команды должен быть типа \"int\"";
        } catch (NullPointerException e) {
            return "Неверно указаны данные.";
        } catch (WrongCommandFormat e) {
            return "Данной команде НУЖЕН аргумент. Проверьте аргументацию\n";
        }
    }
}

