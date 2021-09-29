package Controller;


import Commands.AbstractCommand;
import Exceptions.NoCommandException;
import Utilites.ColorEdit;
import Utilites.Console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;

public class Invoker {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();
    public static final int COMMAND_COMMANDHISTORY_SIZE = 8;
    private static ArrayDeque<String> commandHistory = new ArrayDeque<>(COMMAND_COMMANDHISTORY_SIZE);

    public static void setCommands(Map<String, AbstractCommand> commands) {
        Invoker.commands = commands;
    }

    public String history() {
        StringBuilder history = new StringBuilder();
        for (String commandes : commandHistory) {
            if (!commandes.equals(null))
                history.append(ColorEdit.YELLOW_BOLD_BRIGHT).append("  • ").append(ColorEdit.RESET).append(commandes).append("; \n");
        }
        return history.toString();
    }

    public void regist(AbstractCommand... commands) {
        for (AbstractCommand command : commands)
            Invoker.commands.put(command.getName().toUpperCase(), command);
    }

    public String getHelp() {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, AbstractCommand> entry : commands.entrySet())
            str.append(entry.getValue().toString()).append("\n");
        return str.toString();
    }

    public static Map<String, AbstractCommand> getCommands() {
        return commands;
    }

    public String executeCommand(String input) {
        String[] commandInput = (input.trim() + " ").split(" ", 2);
        try {
            String commandArg = commandInput[1].trim();
            String commandName = commandInput[0];
            AbstractCommand ans = commands.get(commandName.toUpperCase());
            if (ans == null) throw new NoCommandException();
            commandHistory.addLast(ans.getName());
            return ans.execute(commandArg);
        } catch (IOException e) {
            e.printStackTrace();
            return ColorEdit.RED_BOLD + "Ошибка\n" + ColorEdit.RESET;
        } catch (NoCommandException e) {
            return ColorEdit.RED_BOLD + "Такой команды не существует..." + ColorEdit.RESET;
        }
    }
}


/*    public  String executeCommand(String commandName) throws IOException {
        String[] nameAndArgument = commandName.split(" ");
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                return ("Ошибка ввода, введите \"help\".");
            } else {
                if (commands.get(nameAndArgument[0]) instanceof CommandWithoutArg) {
                    try {
                        String s = nameAndArgument[1];
                        return ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (Exception e) {
                        commandHistory.addLast(nameAndArgument[0]);
                        return commands.get(nameAndArgument[0]).execute(null);
                    }
                } else {
                    try {
                        String s = nameAndArgument[2];
                        return ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (IndexOutOfBoundsException e1) {
                        try {
                            commandHistory.addLast(nameAndArgument[0] + " " + nameAndArgument[1].trim());
                            return commands.get(nameAndArgument[0]).execute(nameAndArgument[1].trim());
                        } catch (IndexOutOfBoundsException | FileNotFoundException e2) {
                            return ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
*/
