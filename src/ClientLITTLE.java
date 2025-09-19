
public class ClientLITTLE {
    private String lastName;
    private String initials;
    private String phone;
    private String email;

    public ClientLITTLE(String lastName, String firstName, String phone, String email) {
        this.lastName = lastName;
        this.initials = (firstName == null || firstName.isEmpty() ? "" : firstName.charAt(0) + ".");
        this.phone = phone;
        this.email = email;
    }

    public String getLittleInfo() {
        String contactInfo = phone != null ? "phone: " + phone : "";
        if (email != null && !email.isEmpty()) {
            contactInfo += contactInfo.isEmpty() ? "email: " + email : ", email: " + email;
        }
        return String.format("%s %s%s", lastName, initials, contactInfo.isEmpty() ? "" : ", " + contactInfo);
    }
}