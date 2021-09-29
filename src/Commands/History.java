package Commands;

import Controller.CommandWithoutArg;
import Controller.Invoker;
import Exceptions.WrongCommandFormat;

public class History extends AbstractCommand {
    private Invoker invoker;

    public History(Invoker invoker) {
        super("history", "вывод последних 8 команд (без их аргументов)");
        this.invoker = invoker;
    }

    @Override
    public String execute(Object o) {
        try {
            if (o.equals("")) {
        return invoker.history();
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде НЕ НУЖЕН аргумент. Проверьте аргументацию\n";
        }
    }
}

