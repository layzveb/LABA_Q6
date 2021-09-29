package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Exceptions.WrongCommandFormat;
import SpaceMarine.SpaceMarine;

import java.util.Map;

public class Show extends AbstractCommand {

    public Show() {
        super("show", "вывод всех элементов коллекции");
    }

    @Override
    public String execute(Object o) {
        try {
            if (o.equals("")) {
                StringBuilder res = new StringBuilder();
                if (Collection.getSize() == 0) return ("Коллекция пустая.");
                else for (Map.Entry<Integer, SpaceMarine> entry : Collection.getCollection().entrySet())
                    res.append(entry.getValue()).append("\n");
                return res.toString();
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде НЕ НУЖЕН аргумент. Проверьте аргументацию\n";
        }
    }
}
