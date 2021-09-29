package Commands;

import Controller.CommandWithoutArg;
import Exceptions.WrongCommandFormat;

public class Exit extends AbstractCommand implements CommandWithoutArg {

    public Exit() {
        super("exit", "завершение программы без сохранения в файл");
    }

    @Override
    public String execute(Object o) {
        System.exit(0);
        return null;
    }
}