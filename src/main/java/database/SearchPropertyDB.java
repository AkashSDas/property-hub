package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import models.Property;

public class SearchPropertyDB {

    public static LinkedList<Property> getAllProperties() {
        LinkedList<Property> properties = new LinkedList<>();
        String query = "select * from property";

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

            // Looping through rows
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String address = resultSet.getString("address");
                float minPrice = resultSet.getFloat("min_price");
                float maxPrice = resultSet.getFloat("max_price");
                String status = resultSet.getString("status"); // sold, rent, buy
                int ownerId = resultSet.getInt("owner_id");

                properties.add(new Property(id, title, description, address, minPrice, maxPrice, status, ownerId));
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

        return properties;
    };

}
