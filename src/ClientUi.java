import java.net.PasswordAuthentication;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ClientUi {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner in = new Scanner(System.in);
        System.out.println("Вас приветствует супер-банкомат 3000");
        System.out.println("Пожалуйста пройдите регистрацию или войдите в аккаунт");

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите пароль: ");
        String pass = in.nextLine();

        atm.register(name, pass);

    }
}