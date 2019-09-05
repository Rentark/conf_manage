package model.entity;

public enum Roles {
    USER("user"),
    SPEAKER("speaker"),
    MODERATOR("moderator"),
    ADMIN("admin");

    private String role;
    Roles(String role) { this.role = role;}

    public String getRole() {
        return role;
    }
}
