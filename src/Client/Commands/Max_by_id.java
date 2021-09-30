package Client.Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;

public class Max_by_id extends AbstractCommand implements CommandWithoutArg {

    public Max_by_id() {
        super("max_by_id", "вывести любой объект из коллекции, значение поля id которого является максимальным");
    }

    @Override
    public String execute(Object o) {
        if (Collection.getSize() == 0) return ("Коллекция пустая.");
        else
            return Collection.getCollection().lastEntry().getValue().toString();
    }
}

