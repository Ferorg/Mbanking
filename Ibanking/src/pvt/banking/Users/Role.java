package pvt.banking.Users;

public enum Role {

    Admin("Админ"),
    Client("Пользователь");
    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
