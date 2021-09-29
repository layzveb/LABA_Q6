package Commands;

import Controller.Collection;
import Controller.CommandWithoutArg;
import Exceptions.WrongCommandFormat;
import SpaceMarine.SpaceMarine;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;

public class Print_descending extends AbstractCommand {

    public Print_descending() {
        super("print_descending", "вывод элементов коллекции в порядке убывания");
    }

    @Override
    public String execute(Object o) throws IOException {
        try {
            if (o.equals("")) {
                if (Collection.getSize() == 0) return "Коллекция пустая";
                ArrayDeque<String> deque = new ArrayDeque();
                for (Map.Entry<Integer, SpaceMarine> spaceMarineEntry : Collection.getCollection().entrySet())
                    deque.addFirst(spaceMarineEntry.getValue().toString());
                StringBuilder res = new StringBuilder();
                while (!deque.isEmpty()) {
                    res.append(deque.pop()).append("\n");
                }
                return res.toString();
            } else throw new WrongCommandFormat();
        } catch (WrongCommandFormat e) {
            return "Данной команде НЕ НУЖЕН аргумент. Проверьте аргументацию\n";
        }
    }
}
