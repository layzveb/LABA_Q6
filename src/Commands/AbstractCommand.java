package Commands;

import Controller.CommandWithObject;
import Controller.CommandWithoutArg;
import Utilites.ColorEdit;

public abstract class AbstractCommand implements CommandWithoutArg, CommandWithObject {
    private String name;
    private String description;

    public AbstractCommand(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {return description;}


    @Override
    public String toString() {
        return new StringBuilder().append(ColorEdit.YELLOW_BOLD_BRIGHT).append(" ✧  ").append(name).append(ColorEdit.RESET).append(ColorEdit.BLUE_BRIGHT).append(" ⋯ ").append(ColorEdit.RESET).append(description).toString();
    }
}
