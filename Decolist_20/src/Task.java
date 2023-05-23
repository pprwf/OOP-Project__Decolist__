
import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable {

    private int number;
    private String taskName;
    private String taskDescription;
    private String expireDate;
    private String expireTime;
    private boolean status;

    public Task(int number, String taskName, String taskDescription, String expireDate, String expireTime, boolean staus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.expireDate = expireDate;
        this.expireTime = expireTime;
        this.status = staus;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
}
