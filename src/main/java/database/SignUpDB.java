package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import utility.PasswordHash;
import utility.PasswordHashGenerate;

/**
 * SignUpDB will be responsible for user related database work
 */
public class SignUpDB {

    /**
     * Check if the user exists or not
     */
    public static boolean checkUserExists(String email) {
        boolean userExists = false;
        String query = "select count(*) from users where email = " + "'" + email + "'";

        Connection conn = null;
        Statement statement = null;

        try {
            // Register JDBC driver
            Class.forName(DB.JDBC_DRIVER);

            // Creating connection
            conn = DriverManager.getConnection(DB.DB_URL, DB.USER, DB.PASSWORD);

            // Executing a query
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getInt("count(*)") > 0)
                    userExists = true;
                break;
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return userExists;
    };

    /**
     * Saving the user's data (email) and then hashing the password, saving that
     * hash and salt in the passwords table
     */
    public static boolean signUpUser(String email, String password) {
        boolean userCreated = false;
        String query = "insert into users values(0, '" + email + "')";

        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName(DB.JDBC_DRIVER);
            conn = DriverManager.getConnection(DB.DB_URL, DB.USER, DB.PASSWORD);

            // Insert user
            statement = conn.createStatement();
            int result = statement.executeUpdate(query);

            // User created
            if (result == 1) {
                userCreated = true;

                // Storing the user's password hash and its salt
                PasswordHashGenerate generatedHash = PasswordHash.generateHashedPassword(password);

                ResultSet resultSet = statement.executeQuery("select * from users where email = '" + email + "'");
                int id = 1;
                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    break;
                }

                // Decoding salt
                String salt = Base64.getEncoder().encodeToString(generatedHash.salt);
                query = "insert into passwords values(0, '" + generatedHash.hashedPassword + "', '" + salt + "', " + id + ")";
                result = statement.executeUpdate(query);
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return userCreated;
    };
}
