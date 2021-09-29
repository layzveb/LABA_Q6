import Client.ClientTool;
import Client.PacketTool;
import Commands.Clear;
import Commands.Help;
import CommonObjects.CommandKicker;
import CommonObjects.Serializer;
import CommonObjects.ServerAnswer;
import Controller.Invoker;

public class ClientTest {
    public static void main(String[] args) {
        PacketTool client = new PacketTool();
        Serializer serializer = new Serializer();
        ClientTool clientTool = new ClientTool(client, serializer);
        Clear clear = new Clear();
        CommandKicker commandKicker = new CommandKicker(clear, "" );
        clientTool.sendCommand(commandKicker);
        ServerAnswer mess = clientTool.receiveAns();
        System.out.println(mess);
    }

}
