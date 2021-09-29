package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class PacketTool {
    private DatagramSocket serverSocket;
    private InetAddress IPAddress;
    private final int ACTIVE_PORT = 50001;
    private int clientPort;
    private byte[] dataBuffer = new byte[65000];
    private DatagramPacket receivePacket;
    private DatagramPacket sendPacket;

    public PacketTool() {
        setUp();
    }

    public void setUp() {
        try {
            serverSocket = new DatagramSocket(ACTIVE_PORT);
        } catch (SocketException socketException) {
            socketException.printStackTrace();
        }
        receivePacket = new DatagramPacket(dataBuffer, dataBuffer.length);
        System.out.println("ждем-с");

        try {
            serverSocket.receive(receivePacket);
            System.out.println("успех!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //из пакета вытягиваю данные о клиенте его адрес и порт, по которому идет связь
        IPAddress = receivePacket.getAddress();
        clientPort = receivePacket.getPort();
    }

    public byte[] receive() {
         receivePacket = new DatagramPacket(dataBuffer, dataBuffer.length);
        try {
            serverSocket.receive(receivePacket);
            System.out.println("poluchau");
            return receivePacket.getData();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

    public void send(byte[] toSend) {
         sendPacket = new DatagramPacket(toSend, toSend.length, IPAddress, clientPort);
        try {
            serverSocket.send(sendPacket);
            System.out.println("отправил");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
