package Client.Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import SpaceMarine.SpaceMarine;

import java.util.ArrayDeque;
import java.util.Map;

public class Print_descending extends AbstractCommand implements CommandWithoutArg {

    public Print_descending() {
        super("print_descending", "вывод элементов коллекции в порядке убывания");
    }

    @Override
    public String execute(Object o) {
        return null;
    }
}
