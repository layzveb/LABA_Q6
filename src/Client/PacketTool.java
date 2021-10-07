package Client;

import Utilites.ColorEdit;

import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PacketTool {

    private DatagramSocket clientSocket;
    private final int ACTIVE_PORT = 50001;
    private InetAddress IPAddress;
    private byte[] dataBuffer = new byte[65000];
    private DatagramPacket receivePacket;
    private DatagramPacket sendPacket;

    public PacketTool() {
        setUp();
    }

    public void setUp() {
        try {
            clientSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            IPAddress = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        byte[] pack = new byte[1];
        send(pack);

            receive();
            Console.write(ColorEdit.CYAN_BRIGHT+"⥢﹦﹦﹦﹦﹦﹦﹦﹦﹦﹦ "+ ColorEdit.GREEN_BOLD_BRIGHT+ "УСПЕШНОЕ ПОДКЛЮЧЕНИЕ"+ ColorEdit.RESET+ ColorEdit.CYAN_BRIGHT +" ﹦﹦﹦﹦﹦﹦﹦﹦﹦﹦﹦﹦﹦⥤" + ColorEdit.RESET);

    }

    public byte[] receive() {
         receivePacket = new DatagramPacket(dataBuffer, dataBuffer.length);
        try {
            clientSocket.receive(receivePacket);
            Console.write(ColorEdit.CYAN_BRIGHT+"⥢﹦﹦﹦﹦﹦﹦ "+ColorEdit.YELLOW+"ответ"+ColorEdit.CYAN_BRIGHT+" ﹦﹦﹦ "+ColorEdit.YELLOW+LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-MM-y H:m:s:SS"))+ColorEdit.CYAN_BRIGHT+" ﹦﹦﹦﹦﹦﹦﹦﹦"+ColorEdit.RESET);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receivePacket.getData();
    }

    public void send(byte[] toSend) {
        sendPacket = new DatagramPacket(toSend,toSend.length,IPAddress,ACTIVE_PORT);
        try {
            clientSocket.send(sendPacket);
            Console.write(ColorEdit.CYAN_BRIGHT+"﹦﹦﹦﹦﹦﹦﹦"+ColorEdit.YELLOW+" запрос"+ColorEdit.CYAN_BRIGHT+" ﹦﹦﹦ "+ColorEdit.YELLOW+LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-MM-y H:m:s:SS"))+ColorEdit.CYAN_BRIGHT+" ﹦﹦﹦﹦﹦﹦﹦⥤"+ColorEdit.RESET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
