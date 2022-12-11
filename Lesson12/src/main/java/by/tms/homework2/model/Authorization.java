package by.tms.homework2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Scanner;

@ToString
@Setter
@Getter

public class Authorization {
    private static String password;
    private static String login;
    private static String confirmPassword;
    private static boolean isLogin;
    private static boolean isPassword;
    private static boolean isConfirmPassword;

    public Authorization(String login, String password, String confirmPassword) {
        Authorization.login = login;
        Authorization.password = password;
        Authorization.confirmPassword = confirmPassword;
    }

    public static void checkLogin() {
        if ((login == null) && (login.length() < 20)) {
            isLogin = false;
        }
        for (int i = 0; i < login.length(); i++) {
            char c = login.charAt(i);//нашел этот метод для использования в нашем задании
            int n = login.charAt(i);
            char underSlash = '_';//подскажите можно ли так сделать
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && login.length() > 20 && n != login.charAt(i)) {
                if (!(underSlash == '_')) {
                    isLogin = false;
                    break;
                }
            } else {
                isLogin = true;
            }
        }
    }

    public static void checkPassword() {
        if ((password == null) && (password.length() < 20)) {
            isPassword = false;
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int n = password.charAt(i);
            char underSlash = '_';
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && password.length() > 20 && n != password.charAt(i)) {
                if (!(underSlash == '_')) {
                    isPassword = false;
                    break;
                }
            } else {
                isPassword = true;
            }
        }
    }

    public static void checkConfirmPassword() {
        if (Objects.equals(password, confirmPassword)) {
            isConfirmPassword = true;
        }
    }

    public static boolean checkAuthorization(String login, String password, String confirmPassword) {
        Scanner scanner = new Scanner(System.in);
        login = scanner.nextLine();
        password = scanner.nextLine();
        confirmPassword = scanner.nextLine();
        try {
            checkLogin();//не мог добавить сюда методы, потому что идея просила сделать методы статичными
            checkPassword();
            checkConfirmPassword();
        } catch (WrongLoginException e) {//не понимаю почему здесь ошибка??
            if (!isLogin && login != null) {
                System.out.println(e.getMessage());
                System.out.println("Enter correct login");
                return false;
            }
        } catch (WrongPasswordException e) {
            if (!isPassword && !isConfirmPassword || isPassword != isConfirmPassword) {
                System.out.println(e.getMessage());
                System.out.println("Enter correct password");
                return false;
            }
        } finally {
            System.out.println("Final block checking");
        }
        return true;
    }
}
