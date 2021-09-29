package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Exceptions.WrongCommandFormat;
import Utilites.Console;

public class Clear extends AbstractCommand implements CommandWithoutArg{

    public Clear() {
        super("clear", "очистить коллекцию");
    }

    @Override
    public String execute(Object o) {
//        if (Collection.getSize() == 0) return ("Коллекция итак пустая.");
//        else {
//            Collection.clear();
//            return ("Коллекция очищена");
//        }
        return "tttttt";
    }
}