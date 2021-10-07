package Server;

import CommonObjects.*;
import Server.Commands.AbstractCommand;
import Server.Commands.Clear;
import Server.Commands.Help;
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
        ServerAnswer serverAnswer = new ServerAnswer("что-то пошло ужасно не так");

        UniversalObjectToSend universalObject = serverTool.receiveUniversalObject();

        if (universalObject instanceof ClearDTO) {
            serverAnswer = new ServerAnswer(commands.get("CLEAR").execute(""));
            commandHistory.addLast("CLEAR");
        }
        if (universalObject instanceof ExitDTO) {
            serverAnswer = new ServerAnswer(commands.get("EXIT").execute(""));
            commandHistory.addLast("EXIT");
        }
        if (universalObject instanceof HelpDTO) {
            serverAnswer = new ServerAnswer(commands.get("HELP").execute(""));
            commandHistory.addLast("HELP");
        }
        if (universalObject instanceof HistoryDTO) {
            serverAnswer = new ServerAnswer(commands.get("HISTORY").execute(""));
            commandHistory.addLast("HISTORY");
        }
        if (universalObject instanceof InfoDTO) {
            serverAnswer = new ServerAnswer(commands.get("INFO").execute(""));
            commandHistory.addLast("INFO");
        }
        if (universalObject instanceof MaxByIdDTO) {
            serverAnswer = new ServerAnswer(commands.get("MAX_BY_ID").execute(""));
            commandHistory.addLast("MAX_BY_ID");
        }
        if (universalObject instanceof PrintDescendingDTO) {
            serverAnswer = new ServerAnswer(commands.get("PRINT_DESCENDING").execute(""));
            commandHistory.addLast("PRINT_DESCENDING");
        }
        if (universalObject instanceof SaveDTO) {
            serverAnswer = new ServerAnswer(commands.get("SAVE").execute(""));
            commandHistory.addLast("SAVE");
        }
        if (universalObject instanceof ShowDTO) {
            serverAnswer = new ServerAnswer(commands.get("SHOW").execute(""));
            commandHistory.addLast("SHOW");
        }
        ///
        if (universalObject instanceof RemoveKeyDTO) {
            serverAnswer = new ServerAnswer(commands.get("REMOVE_KEY").execute(universalObject.getStringArgument()));
            commandHistory.addLast("REMOVE_KEY");
        }
        if (universalObject instanceof RemoveAnyByCategoryDTO) {
            serverAnswer = new ServerAnswer(commands.get("REMOVE_ANY_BY_CATEGORY").execute(universalObject.getStringArgument()));
            commandHistory.addLast("REMOVE_ANY_BY_CATEGORY");
        }
        ///
        if (universalObject instanceof InsertDTO) {
            serverAnswer = new ServerAnswer(commands.get("INSERT").execute(universalObject.getStringArgument(),(universalObject).getSpaceMarine()));
            commandHistory.addLast("INSERT");
        }
//        if (universalObject instanceof InsertDTO) {
//            serverAnswer = new ServerAnswer(commands.get("INSERT").execute(universalObject.getStringArgument(),(universalObject).getSpaceMarine()));
//            if(universalObject.getSpaceMarine() != null) {
//                commandHistory.addLast("INSERT");
//            }else{
//                serverTool.sendMess(serverAnswer);
//                universalObject = serverTool.receiveUniversalObject();
//                receiveToAnswer();
//            }
//        }
        if (universalObject instanceof UpdateDTO) {
            serverAnswer = new ServerAnswer(commands.get("UPDATE").execute(universalObject.getStringArgument(),(universalObject).getSpaceMarine()));
            commandHistory.addLast("UPDATE");
        }
        if (universalObject instanceof ReplaceIfGreaterDTO) {
            serverAnswer = new ServerAnswer(commands.get("REPLACE_IF_GREATER").execute(universalObject.getStringArgument(),(universalObject).getSpaceMarine()));
            commandHistory.addLast("REPLACE_IF_GREATER");
        }

        serverTool.sendMess(serverAnswer);
    }
}
