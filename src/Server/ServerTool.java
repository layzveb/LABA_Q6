package Server;

import Client.CommandKicker;
import CommonObjects.Serializer;
import CommonObjects.UniversalObjectToSend;

public class ServerTool {
    private PacketTool packetTool;
    private Serializer siri;

    public ServerTool(PacketTool toolsForPakets, Serializer serializer){
        packetTool = toolsForPakets;
        siri = serializer;
    }

    public UniversalObjectToSend receiveUniversalObject() {
        byte[] inComm = packetTool.receive();
        UniversalObjectToSend messObj = siri.unserializeRequest(inComm);
        return messObj;
    }

    public void sendMess(ServerAnswer serverAnswer) {
        byte[] byteAnswer = siri.serializeMes(serverAnswer);
        packetTool.send(byteAnswer);
    }
}
