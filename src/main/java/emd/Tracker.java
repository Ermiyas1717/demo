package emd;

public class Tracker {

    String toDoName, remainTime, toDoDate = "2024-02-17 12:00:00";
    int toDoID = 0;

    void trac(int no, String name, String date, String remain) {
        toDoID = no;
        toDoName = name;
        toDoDate = date;
        remainTime = remain;
    }
}