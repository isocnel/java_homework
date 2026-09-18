import java.util.Scanner;

public class Main {
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        greet(name);
        scanner.close();
    }
}
