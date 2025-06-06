
import org.slf4j.spi.CallerBoundaryAware;

import java.sql.SQLException;
import java.util.Random;

public class ATM {
    public String name;
    public String pinKode;


    public void register(String namez, String pinKode) throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();
        dataBase.ConDB();
        setPinKode(pinKode);
        dataBase.ReadDb();
        setName(namez);
        for (int i = 0; i < dataBase.listName.size(); i++) {
            String s = dataBase.listName.get(i);
            String k = dataBase.listKode.get(i);
            if (namez.equals(s) && pinKode.equals(k)) {
                System.out.println("У вас уже есть аккаунт");
                ClientUi.mainMenu(this);
                DataBase.close();
                return;
            }
        }

        Card card = new Card();
        card.setNumberCard();
        setName(namez);
        DataBase.WriteDb(getName(), pinKode, String.valueOf(card.getNumberCard()), card.getBalance());
        System.out.println("Вы вошли в систему как " + getName());
        System.out.println("Ваш номер карты: " + card.getNumberCard());
        DataBase.close();
        ClientUi.mainMenu(this);
    }


    void setName(String name) {
        this.name = name;
    }


    String getName() {
        return name;
    }

    public void login(String name, String password) {


    }


    void setPinKode(String pinKode) {
        this.pinKode = pinKode;
    }


    public void getInfo() throws ClassNotFoundException {

        try {
            DataBase dataBase = new DataBase();
            dataBase.ConDB();

            int balance = dataBase.getBalanceByName(name);
            System.out.println("Ваш баланс: " + balance + ".руб");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void refill (String name, int balance) throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();
        dataBase.ConDB();
        dataBase.updateBalanceByName(name, balance);
    }



}