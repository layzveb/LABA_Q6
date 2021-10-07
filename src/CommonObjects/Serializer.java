package CommonObjects;

import Client.CommandKicker;
import Server.ServerAnswer;

import java.io.*;

public class Serializer {

    public byte[] serializeRequest(UniversalObjectToSend obj) {
        try {
            try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
                try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                    oos.writeObject(obj);
                    oos.flush();
                }
                return bos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] serializeMes(ServerAnswer obj) {
        try {
            try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
                try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                    oos.writeObject(obj);
                    oos.flush();
                }
                return bos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ServerAnswer unserializeMes(byte[] bytes) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ServerAnswer) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CommandKicker unserializeCommand(byte[] bytes) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (CommandKicker) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
