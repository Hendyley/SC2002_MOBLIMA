package AdminModule;

import java.io.Serializable;

public class Staff implements Serializable {
    private String staffUsername;
    private String staffPassword;

    public Staff(String staffUsername, String staffPassword) {
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

}
