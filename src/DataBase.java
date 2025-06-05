import java.sql.*;


public class DataBase {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    public static String jdbcPath ="jdbc:sqlite:AccountDB.db";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection(jdbcPath);
        Statement statement = conn.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS clientsAccounts (id INTEGER PRIMARY KEY, name TEXT);");
        if(!conn.isClosed()){
            System.out.println("Дб подключена");
        }


    }




}
