package Server;

import Client.CommandKicker;
import CommonObjects.Serializer;

public class ServerTool {
    private PacketTool packetTool;
    private Serializer siri;

    public ServerTool(PacketTool toolsForPakets, Serializer serializer){
        packetTool = toolsForPakets;
        siri = serializer;
    }

    public CommandKicker receiveCommandObj() {
        byte[] inComm = packetTool.receive();
        UniversalObjectToSend messObj = siri.unserializeRequest(inComm);
        return messObj;
    }

    public void sendMess(ServerAnswer serverAnswer) {
        byte[] byteAnswer = siri.serializeMes(serverAnswer);
        packetTool.send(byteAnswer);
    }
}
