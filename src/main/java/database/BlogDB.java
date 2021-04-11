package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import models.Blog;

public class BlogDB {
    public static LinkedList<Blog> getAllBlogs() {
        LinkedList<Blog> blogs = new LinkedList<>();
        String query = "select * from blog";

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
                String authorName = resultSet.getString("author_name");
                String authorImageUrl = resultSet.getString("author_image_url");
                String publishedDate = resultSet.getString("published_date");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String text = resultSet.getString("text");
                String coverImageUrl = resultSet.getString("cover_image_url");
                String gifUrl = resultSet.getString("gif_url");

                blogs.add(new Blog(id, authorName, authorImageUrl, publishedDate, title, description, text,
                        coverImageUrl, gifUrl));
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

        return blogs;
    }

    public static Blog getBlog(int blogId) {
        Blog blog = null;
        String query = "select * from blog where id = " + blogId + " limit 1";

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
                String authorName = resultSet.getString("author_name");
                String authorImageUrl = resultSet.getString("author_image_url");
                String publishedDate = resultSet.getString("published_date");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String text = resultSet.getString("text");
                String coverImageUrl = resultSet.getString("cover_image_url");
                String gifUrl = resultSet.getString("gif_url");

                blog = new Blog(id, authorName, authorImageUrl, publishedDate, title, description, text, coverImageUrl,
                        gifUrl);
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

        return blog;
    }
}
