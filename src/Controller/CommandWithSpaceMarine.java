package Controller;

import SpaceMarine.SpaceMarine;

import java.io.IOException;

public interface CommandWithSpaceMarine {
    String execute(Object arg) throws IOException;
}
