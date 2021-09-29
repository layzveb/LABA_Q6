import CommonObjects.CommandKicker;
import CommonObjects.Serializer;
import CommonObjects.ServerAnswer;
import Server.PacketTool;
import Server.ServerTool;

public class ServerTest {
    public static void main(String[] args) {
        PacketTool server = new PacketTool();
        Serializer serializer = new Serializer();
        ServerTool serverTool = new ServerTool(server, serializer);
        CommandKicker commandKicker = serverTool.receiveCommandObj();
        System.out.println(commandKicker.getCommandName().execute(commandKicker.getCommandArg()));
        ServerAnswer answer = new ServerAnswer(commandKicker.getCommandName().execute(commandKicker.getCommandArg()));
        serverTool.sendMess(answer);
    }
}
