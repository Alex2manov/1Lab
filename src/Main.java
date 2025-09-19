//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Client c1 = new Client(1, "Иван", "Петров", "+79991234567", "ivan@mail.ru");
        Client c2 = new Client(1, "Иван", "Петров", "+79991234567", "ivan@mail.ru");

        System.out.println(c1.toString());      // полная версия
        System.out.println(c1.toShortString()); // краткая версия
        System.out.println(c1.equals(c2));      // true
    }
}