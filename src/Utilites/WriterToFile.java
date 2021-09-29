package Utilites;

import SpaceMarine.SpaceMarine;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class WriterToFile {
    static String filename;

    public static void setFilename(String filename) {
        WriterToFile.filename = filename;
    }

    public static void writeCollection(TreeMap<Integer, SpaceMarine> collection) {
        try {
            if (filename.equals(null)) throw new FileNotFoundException();
            FileWriter fileWriter = new FileWriter(filename);
            for (Map.Entry<Integer, SpaceMarine> entry : collection.entrySet())
                fileWriter.write(entry.getValue().getCSV() + "\n");
            fileWriter.close();
        } catch (FileNotFoundException e) {
            Console.write("файла для записи коллекции не найдено");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
