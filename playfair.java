import java.util.Scanner;

public class playfair {
private String key;
private char[][] matrix;

public playfair(String key) {
this.key = key;
this.matrix = generateMatrix(key);
}

// Function to generate the 5x5 matrix from the key
private char[][] generateMatrix(String key) {
String filteredKey = key.replaceAll("[^a-zA-Z]", "").toUpperCase();
StringBuilder keyBuilder = new StringBuilder(filteredKey);
for (char c = 'A'; c <= 'Z'; c++) {
if (c == 'J') continue; // Skip 'J' since it's combined with 'I'
if (keyBuilder.indexOf(String.valueOf(c)) == -1) {
keyBuilder.append(c);
}
}
char[][] matrix = new char[5][5];
int index = 0;
for (int i = 0; i < 5; i++) {
for (int j = 0; j < 5; j++) {
matrix[i][j] = keyBuilder.charAt(index++);
}
}
return matrix;
}

// Function to find the positions of two characters in the matrix
private int[] findPosition(char ch) {
int[] pos = new int[2];
for (int i = 0; i < 5; i++) {
for (int j = 0; j < 5; j++) {
if (matrix[i][j] == ch) {
pos[0] = i;
pos[1] = j;
return pos;
}
}
}
return pos;
}

// Function to encrypt a pair of characters
private String encryptPair(char a, char b) {
StringBuilder encryptedPair = new StringBuilder();
int[] posA = findPosition(a);
int[] posB = findPosition(b);
if (posA[0] == posB[0]) {
encryptedPair.append(matrix[posA[0]][(posA[1] + 1) % 5]);
encryptedPair.append(matrix[posB[0]][(posB[1] + 1) % 5]);
} else if (posA[1] == posB[1]) {
encryptedPair.append(matrix[(posA[0] + 1) % 5][posA[1]]);
encryptedPair.append(matrix[(posB[0] + 1) % 5][posB[1]]);
} else {
encryptedPair.append(matrix[posA[0]][posB[1]]);
encryptedPair.append(matrix[posB[0]][posA[1]]);
}
return encryptedPair.toString();
}

// Function to encrypt the plaintext
public String encrypt(String plaintext) {
StringBuilder encryptedText = new StringBuilder();
plaintext = plaintext.replaceAll("[^a-zA-Z]", "").toUpperCase().replace("J", "I");
for (int i = 0; i < plaintext.length(); i += 2) {
char a = plaintext.charAt(i);
char b = (i + 1 < plaintext.length()) ? plaintext.charAt(i + 1) : 'X';
if (a == b) {
b = 'X';
i--;
}
encryptedText.append(encryptPair(a, b));
}
return encryptedText.toString();
}
public void displayMatrix() {
System.out.println("Playfair Matrix:");
for (int i = 0; i < 5; i++) {
for (int j = 0; j < 5; j++) {
System.out.print(matrix[i][j] + " ");
}
System.out.println();
}
}


public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the key: ");
String key = scanner.nextLine();
playfair cipher = new playfair(key);
System.out.print("Enter the plaintext: ");
String plaintext = scanner.nextLine();

cipher.displayMatrix();

String encryptedText = cipher.encrypt(plaintext);
System.out.println("Encrypted text: " + encryptedText);
scanner.close();

}
}
