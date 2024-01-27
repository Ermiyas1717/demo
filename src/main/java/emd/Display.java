package emd;

public class Display {

    public static void errorMessage() {
        System.out.println(
                "\n================================================\nproject ID is Already there try again.\n");
        System.exit(0);
    }

    public static void correctMessage() {

        System.out.println("\n =================================================\n");
        System.out.println("To Do project ID: " + Tracker.toDoID);
        System.out.println("To Do Name: " + Tracker.toDoName);
        new RemainTime();
        System.exit(0);
    }
}
