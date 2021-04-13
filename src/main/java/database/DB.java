package database;

/**
 * DB will have all the common database related properties and methods
 */
public class DB {
    // JDBC driver name and database URL
    static final String DATABASE_NAME = "property_hub";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/" + DATABASE_NAME;

    // Database credentials
    static final String USER = "dbadmin";
    static final String PASSWORD = "password";

    /**
     * To avoid the below warning, adding the private empty constructor Add a
     * private constructor to hide the implicit public one.sonarlint(java:S1118)
     */
    private DB() {
    }
}
