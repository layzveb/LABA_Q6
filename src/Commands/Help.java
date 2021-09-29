package Commands;

import Controller.CommandWithoutArg;
import Controller.Invoker;
import Exceptions.WrongCommandFormat;

public class Help extends AbstractCommand {
    String name = "help";
    private Invoker invoker;

    public Help(Invoker invoker) {
        super("help", "вывод справки по доступным командам");
        this.invoker = invoker;
    }

    @Override
    public String execute(Object o) {
        try {
            if (o.equals("")) {
                return (invoker.getHelp());
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде НЕ НУЖЕН аргумент. Проверьте аргументацию\n";
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
