package dal;


import model.Admin;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.Optional;

public class LoginService {
    private Sql2o sql2o;

    public LoginService(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public boolean isValidAdminUser(String username, String hashedPass) {
        if (username == null || hashedPass == null) return false;
        Admin admin = getAdminFromDatabase().get();
        return  (admin.getName().equals(username) && admin.getHashcode().equals(hashedPass));
    }

    private Optional<Admin> getAdminFromDatabase() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from admin_details")
                    .executeAndFetch(Admin.class)
                    .stream()
                    .findFirst();
        }
    }


}
