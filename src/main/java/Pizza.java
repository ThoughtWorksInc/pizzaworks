import static spark.Spark.get;

public class Pizza {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
