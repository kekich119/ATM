
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;

public class ATM {
    public String name;
    public String password;


    public void register(String namez, String password) throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();
        dataBase.ConDB();
        setPassword(password);
        dataBase.ReadDb();
        setName(namez);
        for (String s : dataBase.listName) {
            if (namez.equals(s)) {
                System.out.println("У вас уже есть аккаунт");
                DataBase.close();
                return;
            }
        }

            DataBase.WriteDb(getName());
            System.out.println("Вы вошли в систему как " + getName());
                Card card = new Card();
                card.setNumberCard(getRandom());
                System.out.println("Ваш номер карты: " + card.numberCard);
                DataBase.close();
        }










    int getRandom() {
        Random ran = new Random();
        return ran.nextInt(111, 999);
    }


    void setName(String name) {
        this.name = name;
    }


    String getName() {
        return name;
    }

    public void login(String name, String password) {
        setPassword(password);
        System.out.println("Вы: " + name);
    }


    void setPassword(String password) {
        this.password = password;
    }


}