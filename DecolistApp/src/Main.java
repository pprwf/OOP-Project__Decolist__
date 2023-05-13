import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        RoomController1 ct = new RoomController1();
        ct.furAllowAccess("bed");
        ct.furAllowAccess("table");
        ct.furAllowAccess("computer");
    }
}
