import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        RoomController1 ct = new RoomController1();
        ct.furAllowAccess("bed", "red");
        ct.furAllowAccess("bed", "blue");
        ct.furAllowAccess("table", "red");
        ct.furAllowAccess("computer", "red");
        ct.furAllowAccess("computer", "blue");
        ct.furAllowAccess("computer", "green");
        ct.furAllowAccess("computer", "yellow");
    }
}
