package bai6;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/testdb",
            "postgres",
            "Devilking147"
        );
    }
}