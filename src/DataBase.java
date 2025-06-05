import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DataBase {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    public static String jdbcPath ="jdbc:sqlite:AccountDB.db";
    List<String> listName = new ArrayList<>();



    public void ConDB() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection(jdbcPath);
        statmt = conn.createStatement();
        if(!conn.isClosed()){
            System.out.println("Дб подключена");
        }
    }

    public static void WriteDb(String name) throws SQLException {
        PreparedStatement prepStmt = conn.prepareStatement(
            "INSERT INTO clientsAccounts (name) VALUES (?);"
        );
        prepStmt.setString(1, name);
        prepStmt.executeUpdate();
        prepStmt.close();
    }

    public static void close() throws SQLException {
        if (resSet != null) resSet.close();
        if (statmt != null) statmt.close();
        if (conn != null) conn.close();
        System.out.println("Соединение закрыто");
    }


    public void ReadDb() throws SQLException {
        resSet = statmt.executeQuery("SELECT * FROM clientsAccounts");

        while (resSet.next()){
            String name = resSet.getString("name");
            listName.add(name);
        }
    }


}

