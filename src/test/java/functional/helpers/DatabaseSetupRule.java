package functional.helpers;

import com.google.common.collect.Lists;
import org.junit.rules.ExternalResource;
import org.sql2o.Sql2o;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.PostgresQuirks;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;

public class DatabaseSetupRule extends ExternalResource {
    private String host = "localhost";
    private String port = "5434";
    private String user = "superpizza";
    private String databaseName = "pizzaworks";
    private String password = "password";

    private EmbeddedPostgres postgres;
    private Connection conn;
    private Sql2o sql2o;

    @Override
    protected void before() throws Throwable {
        super.before();
        postgres = new EmbeddedPostgres(V10);
        String url = postgres.start(host, Integer.parseInt(port), databaseName, user, password);

        conn = DriverManager.getConnection(url);

        ArrayList<String> commandList = Lists.newArrayList("/bin/bash", "-ic", "./db-scripts/migrate.sh");
        ProcessBuilder pb = new ProcessBuilder(commandList);
        Map<String, String> env = pb.environment();
        env.put("PGHOST", host);
        env.put("PGPORT", port);
        env.put("PGUSER", user);
        env.put("PGDATABASE", databaseName);
        env.put("PGPW", password);

        File directory = new File(".");
        pb.directory(directory);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
        p.waitFor();

        // make sure we use default UUID converter.
        sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + "/" + databaseName + "",
                user, password, new PostgresQuirks() {
            {
                // make sure we use default UUID converter.
                converters.put(UUID.class, new UUIDConverter());
            }
        });
    }

    @Override
    protected void after() {
        super.after();
        // close db connection
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Connection could not close");
        }
        // stop Postgres
        postgres.stop();
    }

    public Sql2o getSql2o() {
        return sql2o;
    }
}
