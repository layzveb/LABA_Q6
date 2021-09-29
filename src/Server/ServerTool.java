package Server;

import CommonObjects.CommandKicker;
import CommonObjects.Serializer;
import CommonObjects.ServerAnswer;

public class ServerTool {
    private PacketTool packetTool;
    private Serializer siri;

    public ServerTool(PacketTool toolsForPakets, Serializer serializer){
        packetTool = toolsForPakets;
        siri = serializer;
    }

    public CommandKicker receiveCommandObj() {
        byte[] inComm = packetTool.receive();
        CommandKicker messObj = siri.unserializeCommand(inComm);
        return messObj;
    }

    public void sendMess(ServerAnswer serverAnswer) {
        byte[] byteAnswer = siri.serializeMes(serverAnswer);
        packetTool.send(byteAnswer);
    }
}
