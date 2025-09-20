//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // 1. Создание Client через конструктор
        Client client1 = new Client(1, "Саша", "Туманов", "+79981234567", "alex@gmail.com");
        System.out.println("Полная версия client1:");
        System.out.println(client1.toString());
        System.out.println("Краткая версия client1:");
        System.out.println(client1.toShortString());
        System.out.println();

        // 2. Создание Client из строки
        String data = "2;Анна;Кузнецова;+79982345678;anna@mail.ru";
        Client client2 = new Client(data);
        System.out.println("Полная версия client2:");
        System.out.println(client2.toString());
        System.out.println("Краткая версия client2:");
        System.out.println(client2.toShortString());
        System.out.println();

        try (InputStream is = Main.class.getResourceAsStream("json/reader.json")) {
            if (is == null) {
                System.err.println("Файл reader.json не найден в ресурсах!");
                return;
            }
            String jsonString = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JSONObject json = new JSONObject(jsonString);

            Client readerFromFile = new Client(json);
            System.out.println("Reader (from file JSON): " + readerFromFile);

        } catch (Exception e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

}