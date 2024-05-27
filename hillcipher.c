#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MOD 26

// Function to encrypt plaintext
void encrypt(char *plaintext, int key[2][2]) {
    int len = strlen(plaintext);
    int encrypted[len];

    for (int i = 0; i < len; i += 2) {
        // Mapping characters to numerical values (a=0, b=1, ..., z=25)
        int char1 = plaintext[i] - 'a';
        int char2 = plaintext[i + 1] - 'a';

        // Performing matrix multiplication
        encrypted[i] = (key[0][0] * char1 + key[0][1] * char2) % MOD;
        encrypted[i + 1] = (key[1][0] * char1 + key[1][1] * char2) % MOD;
    }

    // Converting numerical values back to characters
    for (int i = 0; i < len; i++) {
        printf("%c", encrypted[i] + 'a');
    }
    printf("\n");
}

// Function to decrypt ciphertext
void decrypt(char *ciphertext, int key[2][2]) {
    int len = strlen(ciphertext);
    int invKey[2][2];
    int determinantKey = key[0][0] * key[1][1] - key[0][1] * key[1][0];

    // Finding modular multiplicative inverse of the determinant
    int detInv = -1;
    for (int i = 0; i < MOD; i++) {
        if ((determinantKey * i) % MOD == 1) {
            detInv = i;
            break;
        }
    }

    // Finding the adjugate of the key matrix
    invKey[0][0] = key[1][1];
    invKey[0][1] = -key[0][1];
    invKey[1][0] = -key[1][0];
    invKey[1][1] = key[0][0];

    // Applying modular arithmetic to the adjugate matrix
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            invKey[i][j] = (invKey[i][j] * detInv) % MOD;
            if (invKey[i][j] < 0)
                invKey[i][j] += MOD;
        }
    }

    int decrypted[len];
    for (int i = 0; i < len; i += 2) {
        int char1 = ciphertext[i] - 'a';
        int char2 = ciphertext[i + 1] - 'a';

        decrypted[i] = (invKey[0][0] * char1 + invKey[0][1] * char2) % MOD;
        decrypted[i + 1] = (invKey[1][0] * char1 + invKey[1][1] * char2) % MOD;
    }

    // Converting numerical values back to characters
    for (int i = 0; i < len; i++) {
        printf("%c", decrypted[i] + 'a');
    }
    printf("\n");
}

int main() {
    char plaintext[100]; // plaintext to encrypt
    int key[2][2]; // key matrix

    printf("Enter the plain text: ");
    scanf("%s", plaintext);

    printf("Enter the key matrix (4 integers separated by spaces): ");
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            scanf("%d", &key[i][j]);
        }
    }

    printf("Original text: %s\n", plaintext);

    printf("Encrypted text: ");
    encrypt(plaintext, key);

    char ciphertext[100]; // ciphertext to decrypt

    printf("Enter the ciphertext: ");
    scanf("%s", ciphertext);

    printf("Decrypted text: ");
    decrypt(ciphertext, key);

    return 0;
}
