
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import java.util.Objects;

public class Client {
    private int clientId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    // Константы для валидации
    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_PHONE_LENGTH = 20;
    private static final int MAX_EMAIL_LENGTH = 255;

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


    //Конструктор 1
    public Client(int clientId, String firstName, String lastName, String phone, String email) {

        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    // 2. КОНСТРУКТОР ИЗ СТРОКИ
    // Формат: "1;Иван;Петров;+79991234567;ivan@mail.ru"
    public Client(String data) {
        this(
                Integer.parseInt(data.split(";")[0].trim()),
                data.split(";")[1].trim(),
                data.split(";")[2].trim(),
                data.split(";")[3].trim(),
                data.split(";")[4].trim()
        );
    }

    // 3. КОНСТРУКТОР ИЗ JSON
    // Пример: {"clientId":1,"firstName":"Иван","lastName":"Петров","phone":"+79991234567","email":"ivan@mail.ru"}
    public Client(JSONObject json) {
        this(
                json.getInt("ClientId"),
                json.getString("firstName"),
                json.getString("lastName"),
                json.getString("phone"),
                json.getString("email")
        );
    }

    // Полная строка
    @Override
    public String toString() {
        return String.format("Client{id=%d, firstName='%s', lastName='%s', phone='%s', email='%s'}",
                clientId, firstName, lastName, phone, email);
    }

    // Краткая строка
    public String toShortString() {
        String fi = firstName == null || firstName.isEmpty() ? "" : (firstName.charAt(0) + ".");
        return String.format("%s %s", lastName, fi).trim();
    }

    // Сравнение объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client other)) return false;
        return clientId == other.clientId &&
                firstName.equals(other.firstName) &&
                lastName.equals(other.lastName) &&
                phone.equals(other.phone) &&
                ((email == null && other.email == null) ||
                        (email != null && email.equals(other.email)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, firstName, lastName, phone, email);
    }

    // Статические методы валидации (общие)

    private static void validateNotNullOrBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " не может быть пустым");
        }
    }

    private static void validateMaxLength(String value, int maxLength, String fieldName) {
        if (value != null && value.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " не может превышать " + maxLength + " символов");
        }
    }

    //Общий патерн для методов
    private static void validatePattern(String value, Pattern pattern, String errorMessage) {
        if (value != null && !pattern.matcher(value).matches()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // Специфичные методы валидации
    private static void validateName(String name, String fieldName) {
        validateNotNullOrBlank(name, fieldName);
        validateMaxLength(name, MAX_NAME_LENGTH, fieldName);
        validatePattern(name, NAME_PATTERN, fieldName + " содержит недопустимые символы");
    }

    private static void validatePhone(String phone) {
        validateNotNullOrBlank(phone, "Телефон");
        validateMaxLength(phone, MAX_PHONE_LENGTH, "Телефон");
        validatePattern(phone, PHONE_PATTERN, "Неверный формат телефона");
    }

    private static void validateEmail(String email) {
        if (email != null && !email.isBlank()) {
            validateMaxLength(email, MAX_EMAIL_LENGTH, "Email");
            validatePattern(email, EMAIL_PATTERN, "Неверный формат email");
        }
    }

    private static void validateId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID клиента не может быть отрицательным");
        }
    }


    // Геттеры для всех полей (инкапсуляция)

    public int getClientId() {
        return clientId;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getPhone() {
        return phone;
    }


    public String getEmail() {
        return email;
    }

}

