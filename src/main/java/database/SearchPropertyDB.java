package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import models.Property;
import models.PropertyOwner;

/**
 * SearchPropertyDB will be responsible for all the properties, property_owner
 * and property_image_urls related database works
 */
public class SearchPropertyDB {

    /**
     * Get all the properties
     */
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
                String coverImageUrl = resultSet.getString("cover_image_url");
                String gifUrl = resultSet.getString("gif_url");

                properties.add(new Property(id, title, description, address, minPrice, maxPrice, status, ownerId, coverImageUrl, gifUrl));
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

    /**
     * Get all properties where the title or the address has location, passed by the
     * user
     */
    public static LinkedList<Property> getPropertiesForLocation(String location) {
        LinkedList<Property> properties = new LinkedList<>();
        String query = "select * from property where address like '%" + location + "%' or title like '%" + location + "%'";

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
                String coverImageUrl = resultSet.getString("cover_image_url");
                String gifUrl = resultSet.getString("gif_url");

                properties.add(new Property(id, title, description, address, minPrice, maxPrice, status, ownerId, coverImageUrl, gifUrl));
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

    /**
     * Get individual property using the propertyId
     */
    public static Property getPropertiesForLocation(int propertyId) {
        Property property = null;
        String query = "select * from property where id = " + propertyId;

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
                String coverImageUrl = resultSet.getString("cover_image_url");
                String gifUrl = resultSet.getString("gif_url");

                property = new Property(id, title, description, address, minPrice, maxPrice, status, ownerId, coverImageUrl, gifUrl);
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
        return property;
    }

    /**
     * Get property owener from the property_owner table using the ownerId from the
     * property
     */
    public static PropertyOwner getPropertyOwner(int ownerId) {
        PropertyOwner owner = null;
        String query = "select * from property_owner where id = " + ownerId + " limit 1";

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
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                String ownerImageUrl = resultSet.getString("owner_image_url");
                owner = new PropertyOwner(id, firstName, lastName, phoneNumber, email, ownerImageUrl);
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
        return owner;
    }

    /**
     * Get all the property images from the property_image_urls using the propertId
     */
    public static LinkedList<String> getPropertyImageUrls(int propertyId) {
        LinkedList<String> urls = new LinkedList<>();
        String query = "select * from property_image_urls where property_id = " + propertyId;

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
                String url = resultSet.getString("url");
                urls.add(url);
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
        return urls;
    }
}
