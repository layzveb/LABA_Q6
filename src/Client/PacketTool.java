package Client;

import java.io.IOException;
import java.net.*;

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
    }

    public byte[] receive() {
         receivePacket = new DatagramPacket(dataBuffer, dataBuffer.length);
        try {
            clientSocket.receive(receivePacket);
            System.out.println("poluchau");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receivePacket.getData();
    }

    public void send(byte[] toSend) {
        sendPacket = new DatagramPacket(toSend,toSend.length,IPAddress,ACTIVE_PORT);
        try {
            clientSocket.send(sendPacket);
            System.out.println("пакет отправлен!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
