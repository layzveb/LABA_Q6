package SpaceMarine;

import Utilites.Console;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SpaceMarineGenerator {

    public static SpaceMarine generate() {
        SpaceMarine spaceMarine = null;
        try {

            Scanner scanner = new Scanner(System.in);
            String name;

            do {
                Console.write("Введите имя Space Marine:");

//                Console.write("Введите имя Space Marine:");

                name = Console.read();
            } while (name.isEmpty());

            long x = 536;
            do {
                Console.write("Введите координату X:");
                try {
                    x = Long.parseLong(Console.read());
                    if (x > 535)
                        Console.write("Число должно быть меньше 535");
                } catch (NumberFormatException e) {
                    Console.write("Ошибка ввода целочисленного числа");
                }
            } while (x > 535);

            Long y;
            while (true) {
                Console.write("Введите координату Y:");
                try {
                    y = Long.valueOf(Console.read());
                    break;
                } catch (NumberFormatException e) {
                    Console.write("Ошибка ввода целочисленного числа");
                    continue;
                }
            }

            int health = -1;

            while (health < 0) {
                Console.write("Введите поле health:");
                try {
                    String string = Console.read();
                    health = Integer.parseInt(string);
                    if (health < 1)
                        Console.write("Число должно быть больше 0");
                    else break;
                } catch (NumberFormatException e) {
                    Console.write("Ошибка ввода целочисленного числа");
                    continue;
                }

            }

            Boolean loyal;
            while (true) {
                Console.write("Введите поле loyal:");
                try {
                    loyal = Boolean.valueOf(Console.read());
                    break;
                } catch (NumberFormatException e) {
                    Console.write("Ошибка ввода. Значение должно быть true/false");
                    continue;
                }

            }
            String achievements = "";
            Console.write("Введите поле achievements (для значения null введите enter):");
            achievements = Console.read();
            if (achievements.isEmpty())
                achievements = null;
            AstartesCategory category = null;
            while (true) {
                Console.write("Введите одно из значнеия поля Astarte's Category:");
                for (AstartesCategory category1 : AstartesCategory.values()) Console.write(category1.toString());
                try {
                    String string = Console.read().toUpperCase();
                    category = AstartesCategory.valueOf(string);
                } catch (IllegalArgumentException e) {
                    Console.write("Ошибка ввода");
                    continue;
                }
                break;
            }

            Chapter chapter = null;
            String tumb = "";
            while (!(tumb.toLowerCase().equals("y") || tumb.toLowerCase().equals("n"))) {
                Console.write("Есть ли десант у морского корабля?(y/n)");
                tumb = Console.read();
            }
            if (tumb.equals("y")) {
                String chapterName = "";
                do {
                    Console.write("Введите поле Chapter's name:");
                    chapterName = Console.read();
                } while (chapterName.isEmpty());
                String world = "";
                do {
                    Console.write("Введите поле Chapter's world:");
                    world = Console.read();
                } while (world.isEmpty());
                chapter = new Chapter(chapterName, world);
            }
            Coordinates coordinates = new Coordinates(x, y);
            spaceMarine = new SpaceMarine(0, name, coordinates, LocalDateTime.now(), health, loyal, achievements, category, chapter);
        } catch (NoSuchElementException e) {
            Console.write("Ввод был завершён...");
        }
        return spaceMarine;
    }
}
