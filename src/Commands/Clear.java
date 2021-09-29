package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Exceptions.WrongCommandFormat;
import Utilites.Console;

public class Clear extends AbstractCommand {

    public Clear() {
        super("clear", "очистить коллекцию");
    }

    @Override
    public String execute(Object o) {
        try {
            if (o.equals("")) {
                if (Collection.getSize() == 0) return ("Коллекция итак пустая.");
                else {
                    Collection.clear();
                    return ("Коллекция очищена");
                }
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде НЕ НУЖЕН аргумент. Проверьте аргументацию\n";
        }
    }
}