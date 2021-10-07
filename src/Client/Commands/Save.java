package Client.Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Utilites.WriterToFile;

public class Save extends AbstractCommand implements CommandWithoutArg {

    public Save() {
        super("save", "сохранение коллекции в файл");
    }

    @Override
    public String execute(Object o) {
        return null;
    }
}

