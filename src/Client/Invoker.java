package Client;

import Client.Commands.AbstractCommand;
import Controller.CommandWithArg;
import Controller.CommandWithoutArg;
import Exceptions.ExtraArgumentException;
import Exceptions.NoArgumentException;
import Exceptions.NoCommandException;
import Utilites.ColorEdit;
import java.util.Map;
import java.util.TreeMap;

public class Invoker {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();
    private ClientTool clientTool;

    public Invoker(ClientTool clientTool) {
        this.clientTool = clientTool;
    }

    public void regist(AbstractCommand... allCommands) {
        for (AbstractCommand command : allCommands)
            commands.put(command.getName().toUpperCase(), command);
    }

    public void readToSend(String input) {
        String[] commandInput = (input.trim() + " ").split(" ", 2);
        try {
            String commandArg = commandInput[1].trim();
            String commandName = commandInput[0];
            AbstractCommand actualCommand = commands.get(commandName.toUpperCase());
            if (actualCommand == null) throw new NoCommandException();
            if (actualCommand instanceof CommandWithoutArg && !commandArg.equals("")){
                throw new ExtraArgumentException();
            }else if (actualCommand instanceof CommandWithArg && commandArg.equals("")) {
                throw new NoArgumentException();
            }
            CommandKicker commandKicker = new CommandKicker(actualCommand,commandArg);
            clientTool.sendCommand(commandKicker);
            Console.write(clientTool.receiveAns().toString());

        } catch (NoCommandException e) {
            Console.write(ColorEdit.RED_BOLD + "Такой команды не существует..." + ColorEdit.RESET);
        } catch (ExtraArgumentException e) {
            Console.write("Данной команде"+ColorEdit.RED_BOLD+"НЕ НУЖЕН"+ColorEdit.RESET+"аргумент. Проверьте аргументацию");
        } catch (NoArgumentException e) {
            Console.write("Данной команде"+ColorEdit.RED_BOLD+"НУЖЕН"+ColorEdit.RESET+"аргумент. Проверьте аргументацию");
        }
    }
}

