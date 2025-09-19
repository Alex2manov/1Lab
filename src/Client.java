
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Objects;

public class Client {
    private int clientId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    // Регулярные выражения для валидации
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^\\+?[0-9\\s\\-\\(\\)]{7,20}$"
    );

    private static final Pattern NAME_PATTERN = Pattern.compile(
            "^[a-zA-Zа-яА-ЯёЁ\\s\\-']{2,100}$"
    );


    //Конструктор
    public Client(int clientId, String firstName, String lastName, String phone, String email) {
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateEmail(email);

        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    // Статические методы валидации

    public static void validateFirstName(String firstName) {
        if (firstName.length() > 100) {
            throw new IllegalArgumentException("Имя не может превышать 100 символов");
        }
    }

    public static void validateLastName(String lastName) {
        if (lastName.length() > 100) {
            throw new IllegalArgumentException("Фамилия не может превышать 100 символов");
        }
    }

    public static void validatePhone(String phone) {
        if (phone.length() > 20) {
            throw new IllegalArgumentException("Телефон не может превышать 20 символов");
        }
    }

    public static void validateEmail(String email) {
        if (email.length() > 255) {
            throw new IllegalArgumentException("Email не может превышать 255 символов");
        }
    }

    // Геттеры и сеттеры для всех полей (инкапсуляция)

    public int getClientId() {
        return clientId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }
}

