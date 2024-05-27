import java.util.Scanner;  
public class p2
{        
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String capalpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";    
   
   public static String encryptData(String inputStr, int shiftKey) {
    String encryptStr = "";

    for (int i = 0; i < inputStr.length(); i++) {
        char currentChar = inputStr.charAt(i);

        if (Character.isLowerCase(currentChar)) {
            int pos = ALPHABET.indexOf(currentChar);
            int encryptPos = (pos + shiftKey) % 26;
            encryptStr += ALPHABET.charAt(encryptPos);
        } else if (Character.isUpperCase(currentChar)) {
            int pos = capalpha.indexOf(currentChar);
            int encryptPos = (pos + shiftKey) % 26;
            encryptStr += capalpha.charAt(encryptPos);
        } else {
            encryptStr += currentChar; // Non-alphabetic character, keep unchanged
        }
    }
    return encryptStr;
}
   
public static String decryptData(String inputStr, int shiftKey) {
    String decryptStr = "";

    for (int i = 0; i < inputStr.length(); i++) {
        char currentChar = inputStr.charAt(i);

        if (Character.isLowerCase(currentChar)) {
            int pos = ALPHABET.indexOf(currentChar);
            int decryptPos = (pos - shiftKey) % 26;
            if (decryptPos < 0) {
                decryptPos += 26; // positive value
            }
            decryptStr += ALPHABET.charAt(decryptPos);
        } else if (Character.isUpperCase(currentChar)) {
            int pos = capalpha.indexOf(currentChar);
            int decryptPos = (pos - shiftKey) % 26;
            if (decryptPos < 0) {
                decryptPos += 26; // positive value
            }
            decryptStr += capalpha.charAt(decryptPos);
        } else {
            decryptStr += currentChar; // Non-alphabetic character, keep unchanged
        }
    }
    return decryptStr;
}
 public static void main(String[] args)  
    {          
        Scanner sc = new Scanner(System.in);        
        System.out.println("Enter a string for encryption using Caesar Cipher: ");  
        String inputStr = sc.nextLine();  
         
        System.out.println("Enter the value by which each character in the plaintext message gets shifted: ");  
        int shiftKey = Integer.valueOf(sc.nextLine());  
         
        System.out.println("Encrypted Data :"+encryptData(inputStr, shiftKey));  
        System.out.println("Decrypted Data : "+decryptData(encryptData(inputStr, shiftKey), shiftKey));  
     
    }  

}
