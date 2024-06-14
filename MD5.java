import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class p10{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to calculate MD5 hash:");
        String text = scanner.nextLine();
        scanner.close();
       
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            String hashedText = sb.toString();
            System.out.println("Hashed text: " + hashedText);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

