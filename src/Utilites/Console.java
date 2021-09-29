package Utilites;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Console {
    static Scanner in = new Scanner(System.in);

    public static String read(){
        System.out.print("~ ");
        return in.nextLine();
    }

    public static void write(String mes) {
        System.out.println(mes);
    }
}
