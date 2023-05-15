

import java.time.LocalDate;

public class Task {

    private String name;
    private String description;
    private LocalDate expireDate;
    private boolean status;

    public Task(String name, String description, LocalDate expireDate, boolean status) {
        this.name = name;
        this.description = description;
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

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
