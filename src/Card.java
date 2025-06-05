import java.util.Random;

public class Card {
    int balance;
    int numberCard;


    public void setBalance(int balance) {
        this.balance = balance;
    }




    public void setNumberCard() {
        this.numberCard = getRandom();
    }

    int getRandom() {
        Random ran = new Random();
        return ran.nextInt(111, 999);
    }

    public int getBalance(){
        return balance;
    }

    public int getNumberCard(){
        return numberCard;
    }







}
