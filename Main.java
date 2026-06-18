import java.util.*;

class UserAccount {

    String username;
    String password;

    UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class SecurityValidator {

    boolean isValid(UserAccount user) {

        String password = user.password;

        boolean number = false;
        boolean capital = false;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                number = true;
            }

            if (Character.isUpperCase(ch)) {
                capital = true;
            }
        }

        if (number && capital) {
            return true;
        }

        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();
                    
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        UserAccount user = new UserAccount(username, password);

        SecurityValidator check = new SecurityValidator();

        if (check.isValid(user)) {
            System.out.println("Password is VALID");
        } else {
            System.out.println("Password is INVALID");
        }
    }
}