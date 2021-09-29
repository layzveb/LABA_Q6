package Controller;

import java.io.IOException;

public interface CommandWithoutArg {
    String execute(Object o) throws IOException;
}
