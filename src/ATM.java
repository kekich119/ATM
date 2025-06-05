
import java.util.Random;

public class ATM {
    public String name = "admin";
    public String password = "admin";


    public void register(String namez, String password) {

        setPassword(password);
        if (namez.equals(getName())) {
            login(namez, password);
        } else {
            setName(namez);
            System.out.println("Вы вошли в систему как " + getName());

            Card card = new Card();
            card.setNumberCard(getRandom());
            System.out.println("Ваш номер карты: " + card.numberCard);

        }
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