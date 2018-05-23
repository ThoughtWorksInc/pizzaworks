package config;

public class DatabaseConfig {
    private final String host;
    private final String port;
    private final String user;
    private final String databaseName;
    private final String password;

    public DatabaseConfig(String host, String port, String user, String databaseName, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.databaseName = databaseName;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getPassword() {
        return password;
    }
}
