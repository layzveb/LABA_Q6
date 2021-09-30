package Client.Commands;

import Controller.Collection;
import Controller.CommandWithArg;
import SpaceMarine.SpaceMarine;

import java.util.Map;

public class Remove_any_by_category extends AbstractCommand implements CommandWithArg {

    public Remove_any_by_category() {
        super("remove_any_by_category", " [category] удалить из коллекции один элемент, значение поля category которого эквивалентно заданному");
    }

    @Override
    public String execute(Object arg) {
        String sampleCategory = (String) arg;
        try {
            for (Map.Entry<Integer, SpaceMarine> spaceMarineEntry : Collection.getCollection().entrySet()) {
                if (spaceMarineEntry.getValue().getCategory().toString().equals(sampleCategory.toUpperCase())) {
                    Collection.remove(spaceMarineEntry.getKey());
                    return "Удален элемент с id: " + spaceMarineEntry.getKey();
                }
            }
            return "Элементов схожей категории не было обнаружено.";

        } catch (ClassCastException e) {
            return "Неверный аргумент команды.";
        }
    }
}
