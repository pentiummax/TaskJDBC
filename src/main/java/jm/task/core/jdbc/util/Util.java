package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    private static Connection connection;

    private Util() {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?" +
                    "verifyServerCertificate=false" +
                    "&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp" +
                    "&serverTimezone=UTC", "root", "password");

        }
        return connection;
    }

}
