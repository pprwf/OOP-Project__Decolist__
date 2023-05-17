
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalDate;

public class Task {

    private String name;
    private String description;
    private JDateChooser expireDate;
    private boolean status;

    public Task(String name, String description, JDateChooser expireDate, boolean status) {
        this.name = name;
        this.description = description;
        this.expireDate.setDateFormatString("dd-MM-yyyy");
        this.expireDate = expireDate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JDateChooser getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(JDateChooser expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
