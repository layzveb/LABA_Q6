import Commands.*;
import Controller.Collection;
import Controller.Invoker;
import Utilites.ColorEdit;
import Utilites.Console;
import Utilites.ReaderFromFile;
import Utilites.WriterToFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try {

            ReaderFromFile readerFromFile = new ReaderFromFile();
            Scanner scanner = new Scanner(System.in);
            String filepath;
            Console.write("Введите имя файла:\n ~ ");
            filepath = scanner.nextLine();
            WriterToFile.setFilename(filepath);

            Collection.setDateCreation(LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-MM-y H:m:s")));
            Invoker invoker = new Invoker();
            invoker.regist(new Clear(), new Exit(), new Help(invoker), new History(invoker), new Info(),
                    new Insert(), new Max_by_id(), new Remove_key(), new Replace_if_greater(), new Save(), new Show(),
                    new Update(), new Print_descending(), new Remove_any_by_category());
            Console.write(Collection.fillCollection(readerFromFile.readFromFile(filepath)));

            while (true) {
                String input = Console.read();
                if (!input.equals("")) {
                    Console.write(invoker.executeCommand(input));
                }else {
                    Console.write(ColorEdit.RED_BOLD + "Вы не ввели команду..." + ColorEdit.RESET);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

