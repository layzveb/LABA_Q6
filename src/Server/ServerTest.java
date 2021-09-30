package Server;

import Controller.Collection;
import Server.Commands.*;
import CommonObjects.Serializer;
import Server.Invoker;
import Server.PacketTool;
import Server.ServerTool;
import Utilites.Console;
import Utilites.ReaderFromFile;
import Utilites.WriterToFile;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerTest {
    public static void main(String[] args) {
        PacketTool server = new PacketTool();
        Serializer serializer = new Serializer();
        ServerTool serverTool = new ServerTool(server, serializer);
        Invoker invoker = new Invoker(serverTool);
        invoker.regist(new Clear(), new Exit(), new Help(invoker), new History(invoker), new Info(),
                new Insert(), new Max_by_id(), new Remove_key(), new Replace_if_greater(), new Save(), new Show(),
                new Update(), new Print_descending(), new Remove_any_by_category());

        String filepath = "1";
        WriterToFile.setFilename(filepath);
        ReaderFromFile readerFromFile = new ReaderFromFile();
        try {
            Console.write(Collection.fillCollection(readerFromFile.readFromFile(filepath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collection.setDateCreation(LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-MM-y H:m:s")));
    while (true) {
        invoker.receiveToAnswer();

    }
    }
}
