import java.net.PasswordAuthentication;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ClientUi {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ATM atm = new ATM();
        Scanner in = new Scanner(System.in);
        System.out.println("Вас приветствует супер-банкомат 3000");
        System.out.println("Пожалуйста пройдите регистрацию или войдите в аккаунт");

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите PIN-KODE: ");
        String pass = in.nextLine();
        if (name.length()<8 && name.length() > 4){
            atm.register(name, pass);

        }else {
            System.out.println("Вы указали неправильное имя, оно меньше 4 букв или больше 8");
            System.out.println("Повторите попытку позже");
        }

    }

    public static void mainMenu(ATM atm) throws ClassNotFoundException, SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать, " + atm.getName());
        System.out.println("Вы можете узнать информацию о вашем аккаунте");
        System.out.println("1. Узнать баланс 2. Пополнить счёт 3. Узнать номер карты 4. Вывести средства");
        int choose = in.nextInt();

        if (choose == 1) {
            atm.getInfo();
        }
        if (choose == 2) {
            System.out.println("На сколько вы хотите пополнить баланс?");  //Добавить ограничение на пополнение
            int newBalance = in.nextInt();
            atm.refill(atm.getName(), newBalance);
        }


    }

}