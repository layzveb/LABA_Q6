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
        StringBuilder res = new StringBuilder();
        if (Collection.getSize() == 0) return ("Коллекция пустая.");
        else for (Map.Entry<Integer, SpaceMarine> entry : Collection.getCollection().entrySet())
            res.append(entry.getValue()).append("\n");
        return res.toString();
    }
}
