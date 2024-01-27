package emd;

import java.util.Scanner;

public class Tracker {
    static Scanner scan = new Scanner(System.in);

    static String toDoID = "";
    static String toDoName = "";
    static String toDoDate = "2024-12-17 12:00:00";

    public static void trace() {
        System.out.print("Enter the finishing date of the activity (yyyy-MM-dd HH:mm:ss): ");
        toDoDate = scan.nextLine();

        System.out.print("enter project name: ");
        toDoName = scan.nextLine();

        System.out.print("enter project ID: ");
        toDoID = scan.nextLine();
    }

}
