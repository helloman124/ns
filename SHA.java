import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class p9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text to calculate SHA-512 hash: ");
        String text = scanner.nextLine();

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            digest.update(text.getBytes());

            byte[] hashedBytes = digest.digest();

     
            StringBuilder hexString = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
     
                String hex = Integer.toHexString(0xff & hashedByte);

                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            System.out.println("SHA-512 Hash: " + hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
