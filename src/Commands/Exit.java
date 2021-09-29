package Commands;

import Controller.CommandWithoutArg;
import Exceptions.WrongCommandFormat;

public class Exit extends AbstractCommand {

    public Exit() {
        super("exit", "завершение программы без сохранения в файл");
    }

    @Override
    public String execute(Object o) {
        try {
            if (o.equals("")) {
                System.exit(0);
                return null;
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде НЕ НУЖЕН аргумент. Проверьте аргументацию\n";
        }
    }
}