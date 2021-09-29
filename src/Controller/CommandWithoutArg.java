package Controller;

//интейрфес-маркер, это значит, что он не содержит никаких методов
//и существует для валидации команд в инвокере

import java.io.IOException;

//указывает что для команды не нужен аргумент
public interface CommandWithoutArg extends Commandable {
    String execute(Object o) throws IOException;
}
