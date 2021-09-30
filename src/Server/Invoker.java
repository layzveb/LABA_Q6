package Server;

import Server.Commands.AbstractCommand;
import Client.CommandKicker;
import Utilites.ColorEdit;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;

public class Invoker {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();
    public static final int COMMAND_COMMANDHISTORY_SIZE = 8;
    private static ArrayDeque<String> commandHistory = new ArrayDeque<>(COMMAND_COMMANDHISTORY_SIZE);
    private ServerTool serverTool;

    public Invoker(ServerTool serverTool, AbstractCommand... allCommands) {
        this.serverTool = serverTool;
        regist(allCommands);
    }

    public String history() {
        StringBuilder history = new StringBuilder();
        for (String commandes : commandHistory) {
            if (!commandes.equals(null))
                history.append(ColorEdit.YELLOW_BOLD_BRIGHT).append("  • ").append(ColorEdit.RESET).append(commandes).append("; \n");
        }
        return history.toString();
    }

    public void regist(AbstractCommand... allCommands) {
        for (AbstractCommand command : allCommands)
            commands.put(command.getName().toUpperCase(), command);
    }

    public String getHelp() {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, AbstractCommand> entry : commands.entrySet())
            str.append(entry.getValue().toString()).append("\n");
        return str.toString();
    }

    public void receiveToAnswer() {
        CommandKicker commandCase = serverTool.receiveCommandObj();
        String mess = commandCase.getActualCommand().execute(commandCase.getCommandArg());
        ServerAnswer serverAnswer = new ServerAnswer(mess);
        commandHistory.addLast(commandCase.getActualCommand().getName());
        serverTool.sendMess(serverAnswer);
    }
}
