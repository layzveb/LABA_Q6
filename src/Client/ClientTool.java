package Client;

import CommonObjects.CommandKicker;
import CommonObjects.Serializer;
import CommonObjects.ServerAnswer;

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

    public void sendCommand(CommandKicker command) {
        byte[] byteCommand = siri.serializeCommand(command);
        packetTool.send(byteCommand);
    }

}