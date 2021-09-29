package Controller;

import SpaceMarine.AstartesCategory;
import SpaceMarine.Chapter;
import SpaceMarine.Coordinates;
import SpaceMarine.SpaceMarine;
import Utilites.ColorEdit;

import java.time.LocalDateTime;
import java.util.*;

public class Collection {
    //коллекция
    private static TreeMap<Integer, SpaceMarine> collection = new TreeMap<Integer, SpaceMarine>();
    private static String dateCreation;

    public static TreeMap<Integer, SpaceMarine> getCollection() {
        return collection;
    }

    public static void setCollection(TreeMap<Integer, SpaceMarine> collection) {
        Collection.collection = collection;
    }

    public static String getDateCreation() {
        return dateCreation;
    }

    public static void setDateCreation(String dateCreation) {
        Collection.dateCreation = dateCreation;
    }

    public static void clear() {
        collection.clear();
    }

    public static void insert(Integer ind, SpaceMarine spaceMarine) {
        if (isKeyFree(ind))
            collection.put(ind, spaceMarine);
    }

    public static void update(Integer ind, SpaceMarine spaceMarine) {
        if (!isKeyFree(ind))
            collection.replace(ind, spaceMarine);
    }

    public static void remove(Integer ind) {
        collection.remove(ind);
    }

    public static int getSize() {
        return collection.size();
    }

    public static boolean isKeyFree(Integer ind) {
        try {
            for (Map.Entry<Integer, SpaceMarine> entry : collection.entrySet())
                if (entry.getKey() == ind) return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static String getInfo() {
        return new StringBuilder()
                .append("\n꧁_______________________________________________________꧂")
                .append("\n               Тип коллекции: ")
                .append(ColorEdit.YELLOW_BOLD_BRIGHT).append("TreeMap").append(ColorEdit.RESET).append("                   \uD80C\uDC6A")
                .append("\n           Количество элементов коллекции: 21")
                .append(ColorEdit.YELLOW_BOLD_BRIGHT).append(getSize()).append(ColorEdit.RESET)
                .append("\n         Дата создания коллекции: ")
                .append(ColorEdit.YELLOW_BOLD_BRIGHT).append(getDateCreation()).append(ColorEdit.RESET)
                .append("\n꧁_______________________________________________________꧂\n")
                .toString();
    }

    public static String fillCollection(String data) {
        String[] lines = data.split("\n");
        for (String line : lines) {
            try {
                String[] params = line.split(",");
                SpaceMarine spaceMarine = new SpaceMarine();
                spaceMarine.setId(Integer.parseInt(params[0]));
                spaceMarine.setName(params[1]);
                spaceMarine.setCoordinates(new Coordinates(Long.parseLong(params[2]), Long.valueOf(params[3])));
                spaceMarine.setCreationDate(LocalDateTime.parse(params[4]));
                spaceMarine.setHealth(Integer.parseInt(params[5]));
                spaceMarine.setLoyal(Boolean.valueOf(params[6]));
                spaceMarine.setAchievements(params[7]);
                spaceMarine.setCategory(AstartesCategory.valueOf(params[8]));
                if (!params[9].equals("null"))
                    spaceMarine.setChapter(new Chapter(params[9], params[10]));
                else spaceMarine.setChapter(null);
                collection.put(Integer.parseInt(params[0]), spaceMarine);
            } catch (Exception e) {
            }
        }
        return (collection.size() == 0) ? "Коллекция пуста." : "Коллекция заполнена. Количество элементов: " +ColorEdit.YELLOW_BOLD_BRIGHT+ collection.size()+ColorEdit.RESET;
    }

}
