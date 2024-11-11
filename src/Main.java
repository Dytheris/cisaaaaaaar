import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1. Зашифровать текст");
        System.out.println("2. Расшифровать текст");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        System.out.print("Введите сдвиг (число от 1 до 25): ");
        int shift = scanner.nextInt();

        String result;
        if (choice == 1) {
            result = encrypt(text, shift);
            System.out.println("Зашифрованный текст: " + result);
        } else if (choice == 2) {
            result = decrypt(text, shift);
            System.out.println("Расшифрованный текст: " + result);
        } else {
            System.out.println("Некорректный выбор.");
        }

        scanner.close();
    }

    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                boolean isUpper = Character.isUpperCase(ch);
                char base = isUpper ? 'A' : 'a';
                int shifted = (ch - base + shift) % 26 + base;
                encrypted.append((char) shifted);
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }
}
