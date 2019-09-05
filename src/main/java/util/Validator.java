package util;

public class Validator {
    private final static String LOGIN
            = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,30}$";
    private final static String PASSWORD
            = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{4,30}$";

    public  static  boolean isCorrectLogin(String str) {
        return str.matches(LOGIN);
    }

    public static boolean isCorrectPassword(String year) {
        return year.matches(PASSWORD);
    }

    }
