package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Exceptions.WrongCommandFormat;
import Utilites.WriterToFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Save extends AbstractCommand {

    public Save() {
        super("save", "сохранение коллекции в файл");
    }

    @Override
    public String execute(Object o) throws IOException {
        try {
            if (o.equals("")) {
        WriterToFile.writeCollection(Collection.getCollection());
        return "Коллекция успешно сохранена.";
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде НЕ НУЖЕН аргумент. Проверьте аргументацию\n";
        }
    }
}

