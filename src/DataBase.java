import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DataBase {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    public static String jdbcPath = "jdbc:sqlite:AccountDB.db";

    List<String> listName = new ArrayList<>();
    List<String> listKode = new ArrayList<>();
    List<Integer> listBalance = new ArrayList<>();


    public void ConDB() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection(jdbcPath);
        statmt = conn.createStatement();
        if (!conn.isClosed()) {
            System.out.println("Дб подключена");
        }
    }

    public static void WriteDb(String name, String pinKode, String numberCard, int balance) throws SQLException {
        PreparedStatement prepStmt = conn.prepareStatement(
                "INSERT INTO clients (name, pinKode, numberCard, balance) VALUES (?, ?, ?, ?);"
        );
        prepStmt.setString(1, name);
        prepStmt.setString(2, pinKode);
        prepStmt.setString(3, numberCard);
        prepStmt.setInt(4, balance);
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
        resSet = statmt.executeQuery("SELECT * FROM clients");
        while (resSet.next()) {
            String name = resSet.getString("name");
            listName.add(name);
            String pinKode = resSet.getString("pinKode");
            listKode.add(pinKode);


        }

    }

    public int getBalanceByName(String name) throws SQLException {
        String query = "SELECT balance FROM clients WHERE name = ? ";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("balance");
                } else {
                    throw new SQLException("Пользователь не найден");
                }
            }
        }
    }
}

