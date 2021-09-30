package Client.Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;


public class Info extends AbstractCommand implements CommandWithoutArg {

    public Info() {
        super("info", "вывод информации о коллекции");
    }

    @Override
    public String execute(Object o) {
        return Collection.getInfo();
    }
}

