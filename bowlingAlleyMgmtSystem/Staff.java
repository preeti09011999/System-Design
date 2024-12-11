public class Staff extends User {
    private String role;

    public Staff(String userId, String name, String email, String phoneNumber, String role) {
        super(name, email, phoneNumber);
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
