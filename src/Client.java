
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

    //Конструктор
    public Client(int clientId, String firstName, String lastName, String phone, String email) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    // Геттеры и сеттеры для всех полей (инкапсуляция)

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() > 100) {
            throw new IllegalArgumentException("Имя не может превышать 100 символов");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() > 100) {
            throw new IllegalArgumentException("Фамилия не может превышать 100 символов");
        }
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && phone.length() > 20) {
            throw new IllegalArgumentException("Телефон не может превышать 20 символов");
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.length() > 255) {
            throw new IllegalArgumentException("Email не может превышать 255 символов");
        }
        this.email = email;
    }
}

