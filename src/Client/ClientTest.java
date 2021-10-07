package Client;

import Client.Commands.*;
import CommonObjects.Serializer;
import Utilites.ColorEdit;

public class ClientTest {
    public static void main(String[] args) {
        PacketTool client = new PacketTool();
        Serializer serializer = new Serializer();
        ClientTool clientTool = new ClientTool(client, serializer);
        Invoker invoker = new Invoker(clientTool);
        invoker.regist(new Clear(), new Exit(), new Help(invoker), new History(invoker), new Info(),
                new Insert(clientTool), new Max_by_id(), new Remove_key(), new Replace_if_greater(), new Save(), new Show(),
                new Update(), new Print_descending(), new Remove_any_by_category());

        while (true) {
            String input = Console.read();
            if (!input.equals("")) {
                invoker.readToSend(input);
            }else {
                Console.write(ColorEdit.RED_BOLD + "Вы не ввели команду..." + ColorEdit.RESET);
            }
        }
    }
}
