package model.entity;

import java.util.*;

public class User extends Entity {
    private int userID;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private double rating;
    private double bonuses;
    private List<UserActivity> userActivity = new ArrayList<>();
    private String role;

    public User() {
    }

    public User(UserBuilder userBuilder) {
        this.userID = userBuilder.userID;
        this.login = userBuilder.login;
        this.password = userBuilder.password;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.role = userBuilder.role;
        this.rating = userBuilder.rating;
        this.bonuses = userBuilder.bonuses;
        this.userActivity.addAll(userBuilder.userActivity);
    }

    public int getUserID() {
        return userID;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public double getRating() {
        return rating;
    }

    public double getBonuses() {
        return bonuses;
    }

    public List<UserActivity> getUserActivity() {
        return userActivity;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setBonuses(double bonuses) {
        this.bonuses = bonuses;
    }

    public void setUserActivity(List<UserActivity> userActivity) {
        this.userActivity = userActivity;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static class UserBuilder {
        private int userID;
        private String login;
        private String password;
        private String firstName;
        private String lastName;
        private double rating;
        private double bonuses;
        private List<UserActivity> userActivity = new ArrayList<>();
        private String role;

        public UserBuilder(String login, String password, String firstName, String lastName) {
            this.login = login;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder(User user) {
            this.login = user.getLogin();
            this.password = user.getPassword();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.role = user.getRole();
        }

        public UserBuilder setUserID(int userID) {
            this.userID = userID;
            return this;
        }

        public UserBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public UserBuilder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public UserBuilder setBonuses(double bonuses) {
            this.bonuses = bonuses;
            return this;
        }

        public UserBuilder setUserActivity(List<UserActivity> userActivity) {
            this.userActivity.addAll(userActivity);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
