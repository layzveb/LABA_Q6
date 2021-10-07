package Client;

import CommonObjects.Serializer;
import CommonObjects.UniversalObjectToSend;
import Server.ServerAnswer;

public class ClientTool {
    private PacketTool packetTool;
    private Serializer siri;

    public ClientTool(PacketTool toolsForPakets, Serializer serializer){
        packetTool = toolsForPakets;
        siri = serializer;
    }

    public ServerAnswer receiveAns() {
        byte[] inMess = packetTool.receive();
        ServerAnswer messObj = siri.unserializeMes(inMess);
        return messObj;
    }

    public void sendRequest(UniversalObjectToSend request) {
        byte[] byteRequest = siri.serializeRequest(request);
        packetTool.send(byteRequest);
    }
}