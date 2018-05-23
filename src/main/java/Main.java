import config.DatabaseConfig;
import controllers.PizzaController;

import static spark.Spark.exception;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class Main {
    public static void main(String[] args) {
        port(getAssignedPort());
        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
        staticFiles.location("/public");
        String host = System.getenv("PGHOST");
        String port = System.getenv("PGPORT");
        String user = System.getenv("PGUSER");
        String databaseName = System.getenv("PGDATABASE");
        String password = System.getenv("PGPW");

        DatabaseConfig databaseConfig = new DatabaseConfig(host, port, user, databaseName, password);

        PizzaController.initialize(databaseConfig);
    }

    static int getAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }


}
