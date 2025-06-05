
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
                login(namez, pinKode);
                DataBase.close();
                return;
            }
        }

            Card card = new Card();
            card.setNumberCard();
            DataBase.WriteDb(getName(), pinKode, String.valueOf(card.getNumberCard()));
            System.out.println("Вы вошли в систему как " + getName());
                System.out.println("Ваш номер карты: " + card.getNumberCard());
                DataBase.close();
        }





    void setName(String name) {
        this.name = name;
    }


    String getName() {
        return name;
    }

    public void login(String name, String password) {
        setPinKode(password);
        System.out.println("Вы были перенаправлены в раздел входа");

    }


    void setPinKode(String pinKode) {
        this.pinKode = pinKode;
    }


}