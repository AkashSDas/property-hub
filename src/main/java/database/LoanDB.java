package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import models.Loan;

public class LoanDB {
    public static LinkedList<Loan> getAllBankLoans() {
        LinkedList<Loan> loans = new LinkedList<>();
        String query = "select * from loan";

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
                String bankName = resultSet.getString("bank_name");
                String bankLogoImageUrl = resultSet.getString("bank_logo_image_url");
                float minLoanAmount = resultSet.getFloat("min_loan_amount");
                float maxLoanAmount = resultSet.getFloat("max_loan_amount");
                String description = resultSet.getString("description");

                loans.add(new Loan(id, bankName, bankLogoImageUrl, minLoanAmount, maxLoanAmount, description));
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

        return loans;
    }
}
