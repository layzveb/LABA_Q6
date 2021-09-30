package Client.Commands;

import Client.Invoker;
import Controller.CommandWithoutArg;

public class History extends AbstractCommand implements CommandWithoutArg {
    private Invoker invoker;

    public History(Invoker invoker) {
        super("history", "вывод последних 8 команд (без их аргументов)");
        this.invoker = invoker;
    }

    @Override
    public String execute(Object o) {
        return null;
    }
}

