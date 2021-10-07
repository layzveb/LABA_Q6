package Client;

import Client.Commands.*;
import CommonObjects.*;
import Controller.CommandWithArg;
import Controller.CommandWithSpaceMarine;
import Controller.CommandWithoutArg;
import Exceptions.ExtraArgumentException;
import Exceptions.NoArgumentException;
import Exceptions.NoCommandException;
import SpaceMarine.SpaceMarine;
import SpaceMarine.SpaceMarineGenerator;
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

            if (actualCommand instanceof Clear) {
                ClearDTO clearDTO = new ClearDTO();
                clientTool.sendRequest(clearDTO);
            }
            if (actualCommand instanceof Exit) {
                ExitDTO exitDTO = new ExitDTO();
                clientTool.sendRequest(exitDTO);
            }
            if (actualCommand instanceof Help) {
                HelpDTO  helpDTO= new HelpDTO();
                clientTool.sendRequest(helpDTO);
            }
            if (actualCommand instanceof History) {
                HistoryDTO historyDTO = new HistoryDTO();
                clientTool.sendRequest(historyDTO);
            }
            if (actualCommand instanceof Info) {
                InfoDTO infoDTO = new InfoDTO();
                clientTool.sendRequest(infoDTO);
            }
            if (actualCommand instanceof Max_by_id) {
                MaxByIdDTO maxByIdDTO = new MaxByIdDTO();
                clientTool.sendRequest(maxByIdDTO);
            }
            if (actualCommand instanceof Print_descending) {
                PrintDescendingDTO printDescendingDTO = new PrintDescendingDTO();
                clientTool.sendRequest(printDescendingDTO);
            }
            if (actualCommand instanceof Save) {
                SaveDTO saveDTO = new SaveDTO();
                clientTool.sendRequest(saveDTO);
            }
            if (actualCommand instanceof Show) {
                ShowDTO showDTO = new ShowDTO();
                clientTool.sendRequest(showDTO);
            }
            ///
            if (actualCommand instanceof Remove_key) {
                RemoveKeyDTO removeKeyDTO = new RemoveKeyDTO();
                removeKeyDTO.setStringArgument(commandArg);
                clientTool.sendRequest(removeKeyDTO);
            }
            if (actualCommand instanceof Remove_any_by_category) {
                RemoveAnyByCategoryDTO removeAnyByCategoryDTO = new RemoveAnyByCategoryDTO();
                removeAnyByCategoryDTO.setStringArgument(commandArg);
                clientTool.sendRequest(removeAnyByCategoryDTO);
            }
            ///
            if (actualCommand instanceof Insert) {
                InsertDTO insertDTO = new InsertDTO();
                insertDTO.setStringArgument(commandArg);
                insertDTO.setSpaceMarine(SpaceMarineGenerator.generate());
                clientTool.sendRequest(insertDTO);
            }
//            if (actualCommand instanceof Insert) {
//                InsertDTO insertDTO = new InsertDTO();
//                insertDTO.setStringArgument(commandArg);
//                insertDTO.setSpaceMarine(null);
//                clientTool.sendRequest(insertDTO);
//                if (clientTool.receiveAns().equals("Космический корабль с указанным id уже существует.")) return;
//                insertDTO.setStringArgument(commandArg);
//                insertDTO.setSpaceMarine(SpaceMarineGenerator.generate());
//                clientTool.sendRequest(insertDTO);
//            }
            if (actualCommand instanceof Update) {
                UpdateDTO updateDTO = new UpdateDTO();
                updateDTO.setStringArgument(commandArg);
                updateDTO.setSpaceMarine(SpaceMarineGenerator.generate());
                clientTool.sendRequest(updateDTO);
            }
            if (actualCommand instanceof Replace_if_greater) {
                ReplaceIfGreaterDTO replaceIfGreaterDTO = new ReplaceIfGreaterDTO();
                replaceIfGreaterDTO.setStringArgument(commandArg);
                replaceIfGreaterDTO.setSpaceMarine(SpaceMarineGenerator.generate());
                clientTool.sendRequest(replaceIfGreaterDTO);
            }


//                SpaceMarine spaceMarine = SpaceMarineGenerator.generate();
//                SpaceMarineCommand spaceMarineCommand = new SpaceMarineCommand(actualCommand.getName(), spaceMarine, commandArg);
//                clientTool.sendRequest(spaceMarineCommand);


//            if (actualCommand instanceof CommandWithoutArg) {
//                NoArgumentCommand noArgumentCommand = new NoArgumentCommand(actualCommand.getName());
//                clientTool.sendRequest(noArgumentCommand);
//            }
//
//            if (actualCommand instanceof CommandWithArg) {
//                ArgumentCommand argumentCommand = new ArgumentCommand(actualCommand.getName(), commandArg);
//                clientTool.sendRequest(argumentCommand);
//            }

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

