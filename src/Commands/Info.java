package Commands;

import Controller.CommandWithoutArg;
import Controller.Collection;
import Exceptions.WrongCommandFormat;


public class Info extends AbstractCommand {

    public Info() {
        super("info", "вывод информации о коллекции");
    }

    @Override
    public String execute(Object o) {
        try {
            if (o.equals("")) {
                return Collection.getInfo();
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде НЕ НУЖЕН аргумент. Проверьте аргументацию\n";
        }
    }
}

