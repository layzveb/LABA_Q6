package Server.Commands;

import Controller.CommandWithoutArg;
import Controller.Collection;


public class Info extends AbstractCommand implements CommandWithoutArg {

    public Info() {
        super("info", "вывод информации о коллекции");
    }

    @Override
    public String execute(Object o) {
        return Collection.getInfo();
    }
}

