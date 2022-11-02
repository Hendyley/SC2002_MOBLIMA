package AdminModule;
import MovieGoerModule.Account;
import MovieGoerModule.Role;
import java.io.Serializable;




public class Staff extends Account {


    public Staff(String username, String password) {
        super(username,password);
        super.setRole(Role.ADMIN);
    }


}
