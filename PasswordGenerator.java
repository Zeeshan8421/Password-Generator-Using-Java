import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Include lowercase characters? (y/n): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include uppercase characters? (y/n): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.nextLine().equalsIgnoreCase("y");

        String generatedPassword = generatePassword(length, includeLowercase, includeUppercase, includeDigits, includeSpecial);
        System.out.println("Generated Password: " + generatedPassword);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase,
                                          boolean includeDigits, boolean includeSpecial) {
        StringBuilder validCharacters = new StringBuilder();

        if (includeLowercase) {
            validCharacters.append(LOWERCASE_CHARACTERS);
        }
        if (includeUppercase) {
            validCharacters.append(UPPERCASE_CHARACTERS);
        }
        if (includeDigits) {
            validCharacters.append(DIGITS);
        }
        if (includeSpecial) {
            validCharacters.append(SPECIAL_CHARACTERS);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            char randomChar = validCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
