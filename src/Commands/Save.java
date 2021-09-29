package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Exceptions.WrongCommandFormat;
import Utilites.WriterToFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Save extends AbstractCommand implements CommandWithoutArg {

    public Save() {
        super("save", "сохранение коллекции в файл");
    }

    @Override
    public String execute(Object o) {
        WriterToFile.writeCollection(Collection.getCollection());
        return "Коллекция успешно сохранена.";
    }
}

