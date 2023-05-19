
import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable {

    private String taskName;
    private String taskDescription;
    private String expireDate;
    private String expireTime;
    private boolean status;

    public Task(String taskName, String taskDescription, String expireDate, String expireTime, boolean staus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.expireDate = expireDate;
        this.expireTime = expireTime;
        this.status = staus;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        status = false;
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
