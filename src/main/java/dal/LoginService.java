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

    public Optional<Admin> getAdminUserName(String username) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from admin_details where name = :username")
                    .addParameter("username", username)
                    .executeAndFetch(Admin.class)
                    .stream()
                    .findFirst();
        }
    }

    public Optional<Admin> getAdminUserHashcode(String hashcode) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from admin_details where hashcode = :hashcode")
                    .addParameter("hashcode", hashcode)
                    .executeAndFetch(Admin.class)
                    .stream()
                    .findFirst();
        }
    }


}
